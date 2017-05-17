package com.example.jieleo.huanxin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jieleo.huanxin.adapter.ContactListAdapter;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OldFour on 2017/5/9.
 */

public class ContactListFragment extends Fragment implements ContactListAdapter.OnItemClick {

    private ContactBroadCastReceiver mBroadCastReceiver;

    private LRecyclerView mLRecyclerView;

    private LRecyclerViewAdapter mLRecyclerViewAdapter;

    private ContactListAdapter mContactListAdapter;
    private List<String> mContactList;



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("ContactListFragment", "onAttach");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragement_contact_list, container, false);
        //绑定组件
        mLRecyclerView = (LRecyclerView) view.findViewById(R.id.lrv);

        mContactListAdapter = new ContactListAdapter(getContext());
        mLRecyclerViewAdapter = new LRecyclerViewAdapter(mContactListAdapter);
        mLRecyclerView.setLayoutManager(new LinearLayoutManager(MyApp.getContext(), LinearLayoutManager.VERTICAL, false));
        mLRecyclerView.setAdapter(mLRecyclerViewAdapter);
        //注册广播接收器
        mBroadCastReceiver = new ContactBroadCastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("Contact");
        intentFilter.addAction("ContactInvited");
        getActivity().registerReceiver(mBroadCastReceiver, intentFilter);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContactListAdapter.setOnItemClick(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getActivity().unregisterReceiver(mBroadCastReceiver);
    }

    @Override
    public void onClick(int position) {
        Log.d("ContactListFragment", mContactList.get(position));
        Intent intent=new Intent(getActivity(),ChatActivity.class);
        intent.putExtra("contactName",mContactList.get(position));
        startActivity(intent);
    }

    public class ContactBroadCastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, final Intent intent) {
            switch (intent.getAction()) {
                case "Contact":
                    mContactList=new ArrayList<>();
                    mContactList.clear();
                    mContactList = intent.getStringArrayListExtra("ContactList");
                    if (mContactList != null) {
                        mContactListAdapter.setContacts(mContactList);
                    }
                    break;
                case "ContactInvited":
                    Log.d("ContactBroadCastReceive", "收到邀请广播");
                    View view = LayoutInflater.from(getContext()).inflate(R.layout.item_get_invite, mLRecyclerView, false);
                    TextView textView = (TextView) view.findViewById(R.id.invite_name);
                    Button accept= (Button) view.findViewById(R.id.accept_invite);
                    Button refuse= (Button) view.findViewById(R.id.refuse_invite);
                    textView.setText(intent.getStringExtra("name"));
                    accept.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //同意邀请
                            try {
                                EMClient.getInstance().contactManager().acceptInvitation(intent.getStringExtra("name"));
                                mLRecyclerViewAdapter.removeHeaderView();
                                Intent intent1=new Intent("NotifyContact");
                                getActivity().sendBroadcast(intent1);

                            } catch (HyphenateException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    refuse.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //拒绝邀请
                            try {
                                EMClient.getInstance().contactManager().declineInvitation(intent.getStringExtra("name"));
                                mLRecyclerViewAdapter.removeHeaderView();
                            } catch (HyphenateException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    mLRecyclerViewAdapter.addHeaderView(view);
                    mLRecyclerViewAdapter.notifyDataSetChanged();

                    break;

            }
        }
    }



}
