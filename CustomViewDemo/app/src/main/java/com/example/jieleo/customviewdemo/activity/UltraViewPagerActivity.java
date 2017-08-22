package com.example.jieleo.customviewdemo.activity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.jieleo.customviewdemo.R;
import com.example.jieleo.customviewdemo.adapter.UltraPagerAdapter;
import com.tmall.ultraviewpager.UltraViewPager;
import com.tmall.ultraviewpager.transformer.UltraScaleTransformer;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class UltraViewPagerActivity extends AppCompatActivity {


    @InjectView(R.id.btn_01)
    Button mBtn01;
    @InjectView(R.id.ultra_view_pager)
    UltraViewPager mUltraViewPager;

    private UltraPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultra_view_pager);
        ButterKnife.inject(this);




        init();
    }

    private void init() {
        mUltraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);

        mAdapter=new UltraPagerAdapter(true);

        mUltraViewPager.setAdapter(mAdapter);

        mUltraViewPager.setMultiScreen(0.7f);

        mUltraViewPager.setItemRatio(1.0f);

        mUltraViewPager.setAutoMeasureHeight(true);

        mUltraViewPager.setPageTransformer(false,new UltraScaleTransformer());




    }


    @OnClick(R.id.btn_01)
    public void onViewClicked() {


    }
}
