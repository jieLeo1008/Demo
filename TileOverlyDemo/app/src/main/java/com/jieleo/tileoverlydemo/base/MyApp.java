package com.jieleo.tileoverlydemo.base;

import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by YongJie on 2017/6/24.
 */

public class MyApp extends Application {


    public static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
