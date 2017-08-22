package com.example.jieleo.customviewdemo.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.jieleo.customviewdemo.R;
import com.example.jieleo.customviewdemo.service.DownLoadService;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class DownloadActivity extends AppCompatActivity {

    @InjectView(R.id.bind_sevice)
    Button mBindSevice;
    @InjectView(R.id.unbind_service)
    Button mUnbindService;
    @InjectView(R.id.start_download)
    Button mStartDownload;

    private DownLoadService.DownloadBinder mDownloadBinder;


    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mDownloadBinder = (DownLoadService.DownloadBinder) service;
            Log.d("DownloadActivity", "绑定成功");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("DownloadActivity", name.toString());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        ButterKnife.inject(this);


    }

    @OnClick({R.id.bind_sevice, R.id.unbind_service,R.id.start_download})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bind_sevice:

                Intent bindIntent = new Intent(this, DownLoadService.class);
                //绑定服务
                bindService(bindIntent, mConnection, BIND_AUTO_CREATE);


                break;
            case R.id.unbind_service:


                unbindService(mConnection);


                break;

            case R.id.start_download:

                mDownloadBinder.startDownload();

                mDownloadBinder.getProgress();

                break;
        }
    }
}
