package com.benny.viewdemo.ui.java.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.benny.viewdemo.R;
import com.benny.viewdemo.util.tool.NetPostTool;
import com.benny.viewdemo.util.tool.OkPostTool;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class VideoActivity extends BaseActivity {

    @BindView(R.id.btn01)
    Button mBtn01;
    @BindView(R.id.btn02)
    Button mBtn02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);
    }

    @Override
    public void findView() {
        ButterKnife.bind(this);
    }

    @Override
    public void initView() {

    }

    @Override
    public void setOnClick() {

    }

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.btn01,R.id.btn02})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.btn01:
                Intent intent = new Intent();
                intent.setType("Video/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(intent, 100);
                break;
            case R.id.btn02:


                break;
        }


    }

}
