package com.jieleo.mysimpledemo.java.activity;

import android.support.design.widget.CollapsingToolbarLayout;

import com.jieleo.mysimpledemo.R;

/**
 * Created by Benny on 2017/11/3.
 */

public class CollapsingToolbarLayoutActivity extends BaseActivity {

    private CollapsingToolbarLayout mToolbarLayout;

    @Override
    public int bindLayout() {
        return R.layout.activity_collapsing_toolbar_layout;
    }

    @Override
    public void initView() {
        mToolbarLayout=bindView(R.id.toolbar_layout);
    }

    @Override
    public void initDate() {
        mToolbarLayout.setTitleEnabled(true);
    }

    @Override
    public void bindEvent() {

    }
}
