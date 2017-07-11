package com.example.jieleo.customviewdemo.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.jieleo.customviewdemo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 沉浸式状态栏
 */
public class ImmersiveActivity extends AppCompatActivity {

    @InjectView(R.id.iv_01)
    ImageView mIv01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immersive);
        ButterKnife.inject(this);



//        fullScreen();

        hideActionBar();


        Glide.with(this).load("http://cdn.duitang.com/uploads/item/201603/25/20160325210305_enVRr.thumb.700_0.jpeg").into(mIv01);
    }

    /**
     * 透明状态栏
     */
    private void hideActionBar() {
        if (Build.VERSION.SDK_INT>=21){
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
    }


    /**
     * 全屏显示
     */
    private void fullScreen() {
        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(option);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}
