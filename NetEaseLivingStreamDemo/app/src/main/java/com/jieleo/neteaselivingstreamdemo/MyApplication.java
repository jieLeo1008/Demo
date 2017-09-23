package com.jieleo.neteaselivingstreamdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by YongJie on 2017/8/30.
 */

public class MyApplication extends Application {

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
