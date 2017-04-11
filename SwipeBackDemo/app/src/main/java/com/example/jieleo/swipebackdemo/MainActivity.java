package com.example.jieleo.swipebackdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import nsu.edu.com.library.PreferenceUtils;
import nsu.edu.com.library.SwipeBackActivity;
import nsu.edu.com.library.SwipeBackLayout;

public class MainActivity extends SwipeBackActivity implements SwipeBackLayout.SwipeListener {

    private SwipeBackLayout mSwipeBackLayout;

    private String mKey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSwipeBackLayout=getSwipeBackLayout();
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        //设置滑动模式
        mKey=getString(R.string.key_tracking_mode);
        //设置滑动起始位值
        PreferenceUtils.setPrefInt(this,mKey,SwipeBackLayout.EDGE_LEFT);
        //添加滑动监听
        mSwipeBackLayout.addSwipeListener(this);
    }
    public void newActivity(View view){
        startActivity(new Intent(MainActivity.this,MainActivity.class));
    }

    @Override
    public void onScrollStateChange(int state, float scrollPercent) {

    }

    @Override
    public void onEdgeTouch(int edgeFlag) {
        vibrate(20);
    }

    @Override
    public void onScrollOverThreshold() {
        vibrate(20);
    }

    private void vibrate(long duration) {
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = {
                0, duration
        };
        vibrator.vibrate(pattern, -1);
    }
}
