package com.example.jieleo.customviewdemo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.example.jieleo.customviewdemo.MainActivity;

import java.util.Observable;


/**
 * Created by YongJie on 2017/9/6.
 */

public class LaunchReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("LaunchReceiver", "收到广播");
        Intent i =new Intent(context,MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);

        new Thread(() -> Log.d("LaunchReceiver", "哈哈哈")).run();

    }
}
