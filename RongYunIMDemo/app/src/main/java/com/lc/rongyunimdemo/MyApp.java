package com.lc.rongyunimdemo;

import android.app.Application;
import android.content.Context;

import io.rong.imkit.RongIM;

/**
 * Created by Benny on 2018/2/1.
 */

public class MyApp extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
//        RongIM.init(this);
    }


    public static Context getAppContext() {
        return context;
    }
}
