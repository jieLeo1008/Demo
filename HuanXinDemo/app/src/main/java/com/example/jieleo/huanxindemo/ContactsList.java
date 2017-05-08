package com.example.jieleo.huanxindemo;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hyphenate.EMContactListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import java.util.ArrayList;
import java.util.List;

public class ContactsList extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView mRecyclerView;
    private TextView contactName;
    private Button acceptBtn, refuseBtn,toChatBtn;
    List<String> userNames=new ArrayList<>();
    private ContactsListAdapter mAdapter;
    private String name;
    private Handler mHandler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what==100){
                userNames= (List<String>) msg.obj;
                Log.d("ContactsList", "userNames:" + userNames);
            }
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        contactName = (TextView) findViewById(R.id.contact_name);
        acceptBtn = (Button) findViewById(R.id.accept_request);
        refuseBtn = (Button) findViewById(R.id.refuse_request);
        toChatBtn = (Button) findViewById(R.id.to_chat);

        new Thread(new Runnable() {
            @Override
            public void run() {
        try {
            userNames = EMClient.getInstance().contactManager().getAllContactsFromServer();
            Message message=new Message();
            message.obj=userNames;
            message.what=100;
            mHandler.sendMessage(message);
        } catch (HyphenateException e) {
            e.printStackTrace();
        }

            }
        }).start();

        mAdapter = new ContactsListAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MyApp.getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setUserNames(userNames);
        toChatBtn.setOnClickListener(this);
        acceptBtn.setOnClickListener(this);
        refuseBtn.setOnClickListener(this);

        acceptBtn.setVisibility(View.INVISIBLE);
        refuseBtn.setVisibility(View.INVISIBLE);


        EMClient.getInstance().contactManager().setContactListener(new EMContactListener() {
            @Override
            public void onContactAdded(String username) {
                Log.d("ContactsList", "好友请求被同意");
            }

            @Override
            public void onContactDeleted(String username) {
                Log.d("ContactsList", "好友请求被拒绝");
            }

            @Override
            public void onContactInvited(final String username, String reason) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                contactName.setText(username);
                                name=username;
                                Log.d("ContactsList", "好友的名字"+username);
                                acceptBtn.setVisibility(View.VISIBLE);
                                refuseBtn.setVisibility(View.VISIBLE);

                            }
                        });
                    }
                }).run();

            }

            @Override
            public void onFriendRequestAccepted(String username) {
                Log.d("ContactsList", "被删除时回调");
            }

            @Override
            public void onFriendRequestDeclined(String username) {
                Log.d("ContactsList", "增加联系人时会回调");
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.accept_request:
                try {
                    EMClient.getInstance().contactManager().acceptInvitation(name);

                } catch (HyphenateException e) {
                    e.printStackTrace();
                }
                try {
                    userNames = EMClient.getInstance().contactManager().getAllContactsFromServer();
                } catch (HyphenateException e) {
                    e.printStackTrace();
                }
                Log.d("ContactsList", "userNames:" + userNames);
                mAdapter.setUserNames(userNames);

                break;
            case R.id.refuse_request:
                try {
                    EMClient.getInstance().contactManager().declineInvitation(name);
                } catch (HyphenateException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.to_chat:
                startActivity(new Intent(this,ChatActivity.class));
                break;
        }
    }
}
