package com.jieleo.tileoverlydemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.jieleo.tileoverlydemo.R;
import com.jieleo.tileoverlydemo.base.MyApp;

public class FirstLocoActivity extends AppCompatActivity {
    public LocationClient mLocationClient=null;

    public BDLocationListener mListener =new MyLocationListener();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_loco);



        mLocationClient=new LocationClient(MyApp.getContext());

        initLocation();

        mLocationClient.registerLocationListener(mListener);

        mLocationClient.start();
    }


    public class MyLocationListener implements BDLocationListener{

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            Log.d("MyLocationListener", "bdLocation.getLatitude():" + bdLocation.getLatitude());
            Log.d("MyLocationListener", "bdLocation.getLongitude():" + bdLocation.getLongitude());

            Log.d("MyLocationListener", "bdLocation.getLocType():" + bdLocation.getLocType());
        }

        @Override
        public void onConnectHotSpotMessage(String s, int i) {
            Log.d("MyLocationListener", "i:" + i);

            Log.d("MyLocationListener", s);
        }




    }


    private void initLocation(){

        LocationClientOption option =new LocationClientOption();

        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);

        option.setCoorType("gcj02");

        option.setScanSpan(2000);

        option.setOpenGps(true);

        option.setLocationNotify(true);
        //可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果

//        option.setIsNeedLocationDescribe(true);
        //可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”

        option.setIsNeedLocationPoiList(true);
        //可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到

        option.setIgnoreKillProcess(false);
        //可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死

        option.SetIgnoreCacheException(false);
        //可选，默认false，设置是否收集CRASH信息，默认收集

        option.setEnableSimulateGps(false);
        //可选，默认false，设置是否需要过滤GPS仿真结果，默认需要

        mLocationClient.setLocOption(option);
    }
}
