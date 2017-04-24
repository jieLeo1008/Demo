package com.example.jieleo.huanxindemo;

import android.app.Application;
import android.content.Context;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;

/**
 * Created by OldFour on 2017/4/18.
 */

public class MyApp extends Application {


    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
        EMOptions options=new EMOptions();
        options.setAcceptInvitationAlways(false);
        EMClient.getInstance().init(mContext,options);
        EMClient.getInstance().setDebugMode(true);
    }


    public static Context getContext() {
        return mContext;
    }
}
