package com.jieleo.databindingdemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jieleo.databindingdemo.databinding.ActivityListBinding;

public class ListActivity extends AppCompatActivity {


    private ActivityListBinding mListBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mListBinding= DataBindingUtil.setContentView(this,R.layout.activity_list);



    }
}
