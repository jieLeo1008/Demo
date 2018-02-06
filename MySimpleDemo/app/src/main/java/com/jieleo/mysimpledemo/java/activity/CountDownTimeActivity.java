package com.jieleo.mysimpledemo.java.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.jieleo.mysimpledemo.R;
import com.jieleo.mysimpledemo.java.view.CountDownView;

public class CountDownTimeActivity extends BaseActivity implements CountDownView.CountDown {


    private CountDownView mCountDownView;


    @Override
    public int bindLayout() {
        return R.layout.activity_count_down_time;
    }

    @Override
    public void initView() {

        mCountDownView = bindView(R.id.count_down);
        mCountDownView.setCountDown(this);
    }

    @Override
    public void initDate() {
        mCountDownView.setStartTime("2017-11-15 23:40:05");
        mCountDownView.setServerTime("2017-11-15 23:39:59");
        mCountDownView.startCountDown("2017-11-15 23:40:05","2017-11-15 23:39:59");

    }

    @Override
    public void bindEvent() {

    }

    @Override
    public void complete() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(CountDownTimeActivity.this, "到零了", Toast.LENGTH_SHORT).show();

                        mCountDownView.setPause();
                    }
                });
            }
        }).run();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mCountDownView.isThreadAlive()){
            Toast.makeText(this, "线程继续", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "线程停止", Toast.LENGTH_SHORT).show();
        }
    }
}
