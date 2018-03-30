package com.benny.viewdemo.ui.java.activity;


import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.benny.viewdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationActivity extends BaseActivity {

    @BindView(R.id.btn_01)
    Button mBtn01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
    }

    @Override
    public void findView() {
        ButterKnife.bind(this);
    }

    @Override
    public void initView() {

    }

    @Override
    public void setOnClick() {
        mBtn01.setOnClickListener(this);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.btn01:
                sendNotify();
                break;
        }
    }


    @Override
    public void initData() {

    }



    private void sendNotify() {



    }
}
