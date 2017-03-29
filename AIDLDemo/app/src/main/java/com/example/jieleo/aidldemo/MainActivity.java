package com.example.jieleo.aidldemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ServiceConnection mServiceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            /**
             * 初始化AIDL对象
             */
            mMyAIDL=MyAIDL.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    private MyAIDL mMyAIDL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mServiceConnection);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /**
             * 绑定服务
             */
            case R.id.button:
                Intent intent=new Intent(this,MyService.class);
                bindService(intent,mServiceConnection,BIND_AUTO_CREATE);
                break;
            /**
             * 获取服务里面的内容
             */
            case R.id.button2:
                if (mMyAIDL!=null){
                    try {
                        mMyAIDL.getData();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }
}
