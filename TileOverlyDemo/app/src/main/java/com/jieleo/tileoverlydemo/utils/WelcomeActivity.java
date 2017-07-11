package com.jieleo.tileoverlydemo.utils;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.jieleo.tileoverlydemo.R;
import com.jieleo.tileoverlydemo.activity.DetailsActivity;
import com.jieleo.tileoverlydemo.activity.MainActivity;
import com.jieleo.tileoverlydemo.activity.MyTabActivity;

public class WelcomeActivity extends AppCompatActivity {



    private TextView mTextView;
    private MyCountDownTimer mMyCountDownTimer;
    private Handler mHandler =new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mTextView = (TextView) findViewById(R.id.tv_01);
        mMyCountDownTimer=new MyCountDownTimer(1000,1000);
        mMyCountDownTimer.start();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                finish();
            }
        },1000);
    }

    class MyCountDownTimer extends CountDownTimer{

        /**
         *
         * @param millisInFuture
         *      表示以毫秒为单位 倒计时的总数
         *
         *      例如 millisInFuture=1000 表示1秒
         *
         * @param countDownInterval
         *      表示 间隔 多少微秒 调用一次 onTick 方法
         *
         *      例如: countDownInterval =1000 ; 表示每1000毫秒调用一次onTick()
         *
         */

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        /**
         * 倒计时
         * @param l
         */
        @Override
        public void onTick(long l) {
            mTextView.setText("点击跳过  "+l/1000);
        }

        /**
         * 正在跳转
         */
        @Override
        public void onFinish() {
                mTextView.setText("点击跳过   "+0);
        }
    }
}
