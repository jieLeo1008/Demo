package com.example.jieleo.myinquiry;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

/**
 * Created by OldFour on 2017/4/2.
 */

public class MyApp extends Application {
    public  static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
    }

    public static Context getmContext() {
        return mContext;
    }
}
