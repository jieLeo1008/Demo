package com.example.jieleo.customviewdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

public class DownLoadService extends Service {

    private DownloadBinder mBinder = new DownloadBinder();


    public DownLoadService() {

    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("DownLoadService", "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("DownLoadService", "onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("DownLoadService", "onBind");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("DownLoadService", "onUnBind");
        return super.onUnbind(intent);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("DownLoadService", "onDestroy");
    }

    public class DownloadBinder extends Binder {

        public void startDownload() {
            Log.d("DownloadBinder", "startDownload");
        }


        public int getProgress() {
            Log.d("DownloadBinder", "getProgress executed");
            return 0;
        }

    }
}
