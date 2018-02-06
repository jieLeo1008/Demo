package com.benny.carddemo;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;

import com.benny.carddemo.widget.StackCardsView;
import com.tmall.ultraviewpager.UltraViewPager;
import com.tmall.ultraviewpager.transformer.*;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private UltraViewPager mUltraViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUltraViewPager=findViewById(R.id.ultra_vp);

        mUltraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);

        PagerAdapter pagerAdapter =new UltraPageAdapter(this);

        mUltraViewPager.setAdapter(pagerAdapter);

        mUltraViewPager.initIndicator();

        mUltraViewPager.getIndicator()
                .setOrientation(UltraViewPager.Orientation.HORIZONTAL)
                .setFocusColor(Color.GREEN)
                .setNormalColor(Color.WHITE)
                .setRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, getResources().getDisplayMetrics()));

        //设置indicator对齐方式
        mUltraViewPager.getIndicator().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
//构造indicator,绑定到UltraViewPager
        mUltraViewPager.getIndicator().build();


        mUltraViewPager.setMultiScreen(0.6f);

        mUltraViewPager.setItemRatio(1.0f);
        mUltraViewPager.setPageTransformer(false, new UltraDepthScaleTransformer());
    }



}
