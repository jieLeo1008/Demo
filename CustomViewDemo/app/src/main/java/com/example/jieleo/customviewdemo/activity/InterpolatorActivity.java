package com.example.jieleo.customviewdemo.activity;

import android.graphics.Interpolator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.example.jieleo.customviewdemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class InterpolatorActivity extends AppCompatActivity {


    @InjectView(R.id.iv_01)
    ImageView mIv01;
    @InjectView(R.id.rv_01)
    RecyclerView mRv01;


    private List<String> mList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolator);
        ButterKnife.inject(this);

    }




}
