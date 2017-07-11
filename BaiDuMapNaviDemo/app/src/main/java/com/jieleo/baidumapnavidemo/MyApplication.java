package com.jieleo.baidumapnavidemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by OldFour on 2017/6/22.
 */

public class MyApplication extends Application {
    public static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        context =getApplicationContext();
    }


    public static Context getContext() {
        return context;
    }
}
