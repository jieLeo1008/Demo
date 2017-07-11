package com.example.baselib;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationListener;

/**
 * Created by OldFour on 2017/6/14.
 */

public abstract class BaseApplication extends Application {

    public  static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        init();

        //声明AMapLocationClient类对象
        AMapLocationClient mLocationClient = null;
//声明定位回调监听器
        AMapLocationListener mLocationListener = new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                Log.d("MyApplication", "aMapLocation.getLatitude():" + aMapLocation.getLatitude());
                Log.d("MyApplication", "aMapLocation.getLongitude():" + aMapLocation.getLongitude());
            }
        };
//初始化定位
        mLocationClient = new AMapLocationClient(this);
//设置定位回调监听
        mLocationClient.setLocationListener(mLocationListener);
    }

    public abstract void init();
}
