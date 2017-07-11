package com.jieleo.locationsdkdemo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

public class MainActivity extends Activity {


    private MyReceiver mMyReceiver;



    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;



    //声明AMapLocationClientOption对象
    public AMapLocationClientOption mLocationOption = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //声明定位回调监听器
        AMapLocationListener mLocationListener = new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {

                Log.d("MainActivity", aMapLocation.getProvince());
                mLocationClient.stopLocation();
            }
        };
//初始化定位
        mLocationClient = new AMapLocationClient(MyApp.getmContext());
//设置定位回调监听
        mLocationClient.setLocationListener(mLocationListener);


        //初始化AMapLocationClientOption对象
        mLocationOption = new AMapLocationClientOption();


        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);


        mLocationOption.setOnceLocation(true);


//        mLocationOption.setMockEnable(true);

        mLocationClient.startLocation();


        mMyReceiver=new MyReceiver();
        IntentFilter intentFilter =new IntentFilter("ha");
        registerReceiver(mMyReceiver,intentFilter);

        startActivity(new Intent(this,Main2Activity.class));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mMyReceiver);
    }

    class MyReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, intent.getStringExtra("haha"), Toast.LENGTH_SHORT).show();
        }
    }
}
