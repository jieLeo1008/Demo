package com.example.jieleo.customviewdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.example.jieleo.customviewdemo.R;

public class VLayoutActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private VirtualLayoutManager mVirtualLayoutManager;

    private RecyclerView.RecycledViewPool mViewPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vlayout);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_01);

        mVirtualLayoutManager=new VirtualLayoutManager(this);

        mViewPool=new RecyclerView.RecycledViewPool();

        mRecyclerView.setRecycledViewPool(mViewPool);

        mRecyclerView.setLayoutManager(mVirtualLayoutManager);

        mViewPool.setMaxRecycledViews(0,10);



    }
}
