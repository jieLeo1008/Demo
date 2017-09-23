package com.example.jieleo.customviewdemo.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YongJie on 2017/7/20.
 */

public class SyncService extends Service {

    private ServerReceiver mServerReceiver;


    /**
     * handler延时处理
     */
    Handler mHandler = new Handler(msg -> {
        Bundle bundle = msg.getData();

        Log.d("SyncService", bundle.getInt("xx", 10) + "");

        if (msg.what==100){
            Toast.makeText(SyncService.this, "系统已开机", Toast.LENGTH_SHORT).show();
        }

        return false;
    });

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("SyncService", "创建服务");

        mServerReceiver = new ServerReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("order");
        intentFilter.addAction("cancel");
        registerReceiver(mServerReceiver, intentFilter);

    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("SyncService", "停止服务");
        unregisterReceiver(mServerReceiver);
    }


    class ServerReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, final Intent intent) {

            switch (intent.getAction()) {
                case "order":
                    int data = intent.getIntExtra("hh", 0);

                    Message message = new Message();

                    Bundle bundle = new Bundle();

                    bundle.putInt("xx", data);

                    message.setData(bundle);

                    mHandler.sendMessageDelayed(message, 3000);

                    break;

                case "cancel":

                    break;
                default:
                    mHandler.sendEmptyMessageDelayed(100,5000);
            }


        }
    }
}
