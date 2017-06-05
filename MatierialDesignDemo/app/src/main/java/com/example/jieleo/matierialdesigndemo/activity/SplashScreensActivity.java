package com.example.jieleo.matierialdesigndemo.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jieleo.matierialdesigndemo.R;

public class SplashScreensActivity extends AppCompatActivity {

    Handler mHandler =new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what==100){
                finish();
            }
            return false;
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screens);
        mHandler.sendEmptyMessageDelayed(100,3000);
    }
}
