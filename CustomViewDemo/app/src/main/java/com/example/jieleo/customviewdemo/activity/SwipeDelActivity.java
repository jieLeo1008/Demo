package com.example.jieleo.customviewdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jieleo.customviewdemo.R;
import com.example.jieleo.customviewdemo.adapter.SwipeDelAdapter;

public class SwipeDelActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_del);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_01);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        SwipeDelAdapter adapter =new SwipeDelAdapter(this);

        mRecyclerView.setAdapter(adapter);
    }
}
