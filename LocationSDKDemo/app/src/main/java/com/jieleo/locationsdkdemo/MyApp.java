package com.jieleo.locationsdkdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by YongJie on 2017/6/29.
 */

public class MyApp  extends Application{


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
