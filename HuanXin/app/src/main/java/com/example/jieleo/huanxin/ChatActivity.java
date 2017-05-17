package com.example.jieleo.huanxin;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jieleo.huanxin.adapter.ChatAdapter;
import com.example.jieleo.huanxin.bean.MyChatBean;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMTextMessageBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ChatActivity extends AppCompatActivity {

    private String contactName;
    private EMMessageListener mEmMessageListener;
    private List<MyChatBean> mChatBeen;
    private EditText mEditText;
    private RecyclerView mRecyclerView;
    private ChatAdapter mAdapter;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        mEditText = (EditText) findViewById(R.id.my_edt);
        mRecyclerView = (RecyclerView) findViewById(R.id.chat_rv);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);


        mAdapter=new ChatAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setAdapter(mAdapter);
        contactName = getIntent().getStringExtra("contactName");
        mChatBeen = new ArrayList<>();


        mToolbar.setTitle(contactName);

        mEmMessageListener = new EMMessageListener() {
            @Override
            public void onMessageReceived(final List<EMMessage> list) {
                Log.d("ChatActivity", "收到消息");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("ChatActivity", ((EMTextMessageBody) list.get(0).getBody()).getMessage());
                        mChatBeen.addAll(manageMessage(list));

                        mAdapter.setChatBeen(mChatBeen);
                    }
                });
            }

            @Override
            public void onCmdMessageReceived(List<EMMessage> list) {
                Log.d("ChatActivity", "收到透传消息");
            }

            @Override
            public void onMessageRead(List<EMMessage> list) {
                Log.d("ChatActivity", "收到已读回执");
            }

            @Override
            public void onMessageDelivered(List<EMMessage> list) {
                Log.d("ChatActivity", "收到已送到回执");
            }

            @Override
            public void onMessageChanged(EMMessage emMessage, Object o) {
                Log.d("ChatActivity", "消息状态变动");
            }
        };

        //发送 不需要对当前会话显示Notification的广播
        Intent intent=new Intent("ChatNow");
        intent.putExtra("ChatNowName",contactName);
        sendBroadcast(intent);
        EMClient.getInstance().chatManager().addMessageListener(mEmMessageListener);
    }

    public void sendMessage(View view) {
        if (TextUtils.isEmpty(mEditText.getText().toString())) {
            Toast.makeText(this, "请输入内容", Toast.LENGTH_SHORT).show();
        } else {
            String content = mEditText.getText().toString();
            MyChatBean.ContactMsg contactMsg = new MyChatBean.ContactMsg();
            contactMsg.setCurrentTimes(System.currentTimeMillis());
            contactMsg.setMsg(content);
            contactMsg.setType(1);
            MyChatBean bean = new MyChatBean();
            bean.setContactMsg(contactMsg);
            bean.setContactName(contactName);
            mChatBeen.add(bean);
            EMMessage message = EMMessage.createTxtSendMessage(content, contactName);
            EMClient.getInstance().chatManager().sendMessage(message);
            mAdapter.setChatBeen(mChatBeen);
        }


    }

    public List<MyChatBean> manageMessage(List<EMMessage> messages) {
        List<MyChatBean> chatBean = new ArrayList<>();
        for (EMMessage message : messages) {
            if (message.getFrom().equals(contactName)){
            MyChatBean bean = new MyChatBean();
            MyChatBean.ContactMsg contactMsg = new MyChatBean.ContactMsg();
            bean.setContactName(contactName);
            contactMsg.setCurrentTimes(message.getMsgTime());
            contactMsg.setMsg(((EMTextMessageBody) message.getBody()).getMessage());
            contactMsg.setType(0);
            bean.setContactMsg(contactMsg);
            chatBean.add(bean);
            }
        }
        return chatBean;
    }

    @Override
    protected void onPause() {
        super.onPause();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EMClient.getInstance().chatManager().removeMessageListener(mEmMessageListener);
        //发一条需要显示当前联系人Notification的广播
        Intent intent=new Intent("ChatOver");
        sendBroadcast(intent);
    }
}
