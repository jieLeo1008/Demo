package com.example.jieleo.modulesdemo;


import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.baselib.AppConfig;
import com.example.baselib.BaseActivity;
import com.example.baselib.utils.permisson.MPermission;
import com.example.baselib.utils.permisson.PermissionFailed;
import com.example.baselib.utils.permisson.PermissionSuccess;

public class MainActivity extends BaseActivity {


    private MyReceiver mMyReceiver;


    @Override
    public int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void init() {

        MPermission.needPermission(this,200,new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        });


        mMyReceiver=new MyReceiver();
        IntentFilter filter=new IntentFilter("哈哈");
        registerReceiver(mMyReceiver,filter);
    }

    @PermissionSuccess(requestCode = 200)
    public void requestPermissionSuccess(){
        Intent intent=getStartActivityIntent(AppConfig.MAP_ACTIVITY);
        intent.putExtra("xx","12345");
        startActivity(intent);
    }
    @PermissionFailed(requestCode = 200)
    public void requestPermissionFailed(){
        Toast.makeText(this, "请授予定位权限", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MPermission.onRequestPermissionsResult(this,requestCode,permissions,grantResults);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mMyReceiver);
    }

    class MyReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("MyReceiver", "收到广播");
        }
    }
}
