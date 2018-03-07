package com.benny.viewdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by Benny on 2018/3/6.
 */

public class MyApp extends Application{


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
