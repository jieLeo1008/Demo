package com.example.jieleo.customviewdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.jieleo.customviewdemo.utils.manager.MyActivityManager;

/**
 * Created by YongJie on 2017/9/5.
 * 要做一个完美的基类
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(bindLayout());

        MyActivityManager.addActivity(this);

        Log.d("BaseActivity", getClass().getName());
        Log.d("BaseActivity", getClass().getSimpleName());

        initView();

        initData();

        bindEvent();

    }

    /**
     * 绑定布局文件
     *
     * @return
     */
    public abstract int bindLayout();
    /**
     * 初始化View
     */
    public abstract void initView();

    /**
     * 初始化数据
     */
    public abstract void initData();



    /**
     * 绑定事件
     */
    public abstract void bindEvent();
    /**
     * 绑定View
     * @param resId
     * @param <T>
     * @return
     */
    public <T extends View> T bindView(int resId) {
        return (T) findViewById(resId);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyActivityManager.removeActivity(this);

    }


}
