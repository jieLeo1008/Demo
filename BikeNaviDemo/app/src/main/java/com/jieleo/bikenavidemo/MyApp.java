package com.jieleo.bikenavidemo;

import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by YongJie on 2017/6/23.
 */

public class MyApp extends Application {

    public  static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        SDKInitializer.initialize(this);
    }

    public static Context getContext() {
        return context;
    }
}
