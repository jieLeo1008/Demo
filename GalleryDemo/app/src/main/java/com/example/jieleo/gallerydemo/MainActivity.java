package com.example.jieleo.gallerydemo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private RelativeLayout main;
    private List<ImageView> mImageViews;
    private int pageWidth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        main = (RelativeLayout) findViewById(R.id.activity_main);
        initData();
        mViewPager.setOffscreenPageLimit(5);
        pageWidth= (int) (getResources().getDisplayMetrics().widthPixels*3.0f/5.0f);
        ViewGroup.LayoutParams layoutParams=mViewPager.getLayoutParams();
        if (layoutParams==null){
            layoutParams=new ViewGroup.LayoutParams(pageWidth,ViewGroup.LayoutParams.MATCH_PARENT);
        }else {
            layoutParams.width=pageWidth;
        }
        mViewPager.setLayoutParams(layoutParams);
        mViewPager.setPageMargin(-50);
        main.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return mViewPager.dispatchTouchEvent(event);
            }
        });

        mViewPager.setPageTransformer(true,new GallyPageTransfomer());
        mViewPager.setAdapter(new PageAdapter(mImageViews));
    }

    private void initData() {
        mImageViews = new ArrayList<>();
        ImageView first = new ImageView(MainActivity.this);
//        first.setImageBitmap(ImageUtils.getReverseBitmapById(R.mipmap.first, MainActivity.this));
        first.setImageResource(R.mipmap.first);
        ImageView second = new ImageView(MainActivity.this);
//        second.setImageBitmap(ImageUtils.getReverseBitmapById(R.mipmap.second, MainActivity.this));
        second.setImageResource(R.mipmap.second);
        ImageView third = new ImageView(MainActivity.this);
//        third.setImageBitmap(ImageUtils.getReverseBitmapById(R.mipmap.third, MainActivity.this));
        third.setImageResource(R.mipmap.third);
        ImageView fourth = new ImageView(MainActivity.this);
//        fourth.setImageBitmap(ImageUtils.getReverseBitmapById(R.mipmap.fourth,MainActivity.this));
        fourth.setImageResource(R.mipmap.fourth);


        ImageView fifth = new ImageView(MainActivity.this);
//        fifth.setImageBitmap(ImageUtils.getReverseBitmapById(R.mipmap.fifth, MainActivity.this));
        fifth.setImageResource(R.mipmap.fifth);
        mImageViews.add(first);
        mImageViews.add(second);
        mImageViews.add(third);
        mImageViews.add(fourth);
        mImageViews.add(fifth);
    }
}
