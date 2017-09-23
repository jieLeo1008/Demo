package com.jieleo.mysimpledemo.java.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.jieleo.mysimpledemo.R;
import com.jieleo.mysimpledemo.kotlin.MainActivity;


public class WelcomeActivity extends AppCompatActivity {

    private ImageView mImageView;

    private int[] picList=new int[]{R.mipmap.first,R.mipmap.second,R.mipmap.third};

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {

            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
            finish();
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mImageView = (ImageView) findViewById(R.id.start_iv);

        mImageView.setBackgroundResource(picList[(int) (Math.random() * picList.length)]);



        mHandler.sendEmptyMessageDelayed(100,2000);

    }
}
