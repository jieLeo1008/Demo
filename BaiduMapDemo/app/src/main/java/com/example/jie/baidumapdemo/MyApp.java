package com.example.jie.baidumapdemo;

import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by jie on 2017/3/19.
 */

public class MyApp extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
        SDKInitializer.initialize(mContext);
    }


    public static Context getmContext() {
        return mContext;
    }
}
