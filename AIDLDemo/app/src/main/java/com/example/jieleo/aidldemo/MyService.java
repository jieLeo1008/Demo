package com.example.jieleo.aidldemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by jieleo on 2017/3/29.
 */

public class MyService extends Service {
    private MyBinder mBinder=new MyBinder();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    class MyBinder extends MyAIDL.Stub{

        @Override
        public void getData() throws RemoteException {
            Log.d("MyBinder", "服务里的内容");
        }
    }
}
