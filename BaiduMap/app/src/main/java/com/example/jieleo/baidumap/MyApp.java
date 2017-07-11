package com.example.jieleo.baidumap;

import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.bikenavi.BikeNavigateHelper;

/**
 * Created by OldFour on 2017/6/17.
 */

public class MyApp extends Application {

    public static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        SDKInitializer.initialize(this);
        SDKInitializer.setCoordType(CoordType.BD09LL);
        
    }

    public static Context getContext() {
        return context;
    }
}
