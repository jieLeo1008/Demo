package com.example.jieleo.amapdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by OldFour on 2017/4/7.
 */

public class MyApp extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
    }

    public static Context getmContext() {
        return mContext;
    }
}
