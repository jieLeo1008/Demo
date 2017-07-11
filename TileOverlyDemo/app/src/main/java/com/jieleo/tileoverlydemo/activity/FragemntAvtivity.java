package com.jieleo.tileoverlydemo.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jieleo.tileoverlydemo.R;
import com.jieleo.tileoverlydemo.adapter.FragmentAdapter;

public class FragemntAvtivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private FragmentAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragemnt_avtivity);
        mViewPager = (ViewPager) findViewById(R.id.vp_01);
        mAdapter=new FragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
//        mViewPager.setOffscreenPageLimit();

    }
}
