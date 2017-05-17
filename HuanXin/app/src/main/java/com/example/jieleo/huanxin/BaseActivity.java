package com.example.jieleo.huanxin;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.umeng.analytics.MobclickAgent;

/**
 * Created by OldFour on 2017/5/8.
 */
@SuppressLint("Registered")
public class BaseActivity extends EaseBaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
        MobclickAgent.onPause(this);
    }
}
