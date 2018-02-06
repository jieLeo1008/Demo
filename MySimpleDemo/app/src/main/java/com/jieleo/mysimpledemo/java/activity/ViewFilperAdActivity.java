package com.jieleo.mysimpledemo.java.activity;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ViewFlipper;

import com.jieleo.mysimpledemo.R;

/**
 * Created by Benny on 2017/10/23.
 */

public class ViewFilperAdActivity extends BaseActivity{

    private ViewFlipper mViewFlipper;
    @Override
    public int bindLayout() {
        return R.layout.activity_view_filper_ad;
    }

    @Override
    public void initView() {

        mViewFlipper= (ViewFlipper) findViewById(R.id.my_flipper);

        mViewFlipper.addView(LayoutInflater.from(this).inflate(R.layout.item_text,null));
        mViewFlipper.addView(LayoutInflater.from(this).inflate(R.layout.item_text,null));
        mViewFlipper.addView(LayoutInflater.from(this).inflate(R.layout.item_text,null));


    }

    @Override
    public void initDate() {


        mViewFlipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public void bindEvent() {

    }
}
