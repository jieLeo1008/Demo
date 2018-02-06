package com.jieleo.mysimpledemo.java.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * Created by YongJie on 2017/9/20.
 * 要做一个完美的基类  ✌️
 */

public abstract class BaseActivity extends AppCompatActivity {

    public  boolean NEED_FULLSCREEN=true;


//    private int screenW;
//    private int screenH;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        initView();
        initDate();
        bindEvent();


        if (NEED_FULLSCREEN){
            immersionNotice();
        }

    }


    public abstract int bindLayout();

    public abstract void initView();

    public abstract void initDate();

    public abstract void bindEvent();


    public <T extends View> T bindView(int resId) {
        return (T) findViewById(resId);
    }


    /**
     * 实现沉浸式通知栏
     */
    private void immersionNotice(){

//        screenW = getWindowManager().getDefaultDisplay().getWidth();

//        screenH = getWindowManager().getDefaultDisplay().getHeight();

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {

            hideActionBar();

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

            }

        }
        else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            ViewGroup decorViewGroup = (ViewGroup) window.getDecorView();
            View statusBarView = new View(window.getContext());
            int statusBarHeight = getStatusBarHeight(window.getContext());
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, statusBarHeight);
            params.gravity = Gravity.TOP;
            statusBarView.setLayoutParams(params);
            statusBarView.setBackgroundColor(Color.parseColor("#00ffffff"));
            decorViewGroup.addView(statusBarView);
        }

    }

    /**
     * 隐藏ActionBar
     */
    private void hideActionBar() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            View decorView = getWindow().getDecorView();

            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;

            decorView.setSystemUiVisibility(option);

            getWindow().setStatusBarColor(Color.TRANSPARENT);

        }
    }


    private static int getStatusBarHeight(Context context) {

        int statusBarHeight = 0;

        Resources res = context.getResources();

        int resourceId = res.getIdentifier("status_bar_height", "dimen", "android");

        if (resourceId > 0) {

            statusBarHeight = res.getDimensionPixelSize(resourceId);

        }

        return statusBarHeight;
    }


}
