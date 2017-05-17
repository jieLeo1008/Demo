package com.example.jieleo.huanxin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by OldFour on 2017/5/9.
 */

public class ChatListFragment extends Fragment {


    public BroadcastReceiver mBroadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("ChatListFragment", "收到广播");
        }
    };

//    private MBroadCastReceiver mBroadcastReceiver;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("Contact");
//            mBroadcastReceiver=new MBroadCastReceiver();
        getActivity().registerReceiver(mBroadcastReceiver,intentFilter);
        return inflater.inflate(R.layout.fragemnt_chat_list,container,false);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getActivity().unregisterReceiver(mBroadcastReceiver);
    }

//    public class MBroadCastReceiver extends BroadcastReceiver{
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            Log.d("ChatListFragment", "收到广播");
//        }
//    }
}
