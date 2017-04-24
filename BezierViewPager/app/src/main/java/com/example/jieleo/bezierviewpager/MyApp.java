package com.example.jieleo.bezierviewpager;

import android.app.Application;
import android.content.Context;

/**
 * Created by OldFour on 2017/4/22.
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
