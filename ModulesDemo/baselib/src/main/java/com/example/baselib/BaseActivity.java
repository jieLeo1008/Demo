package com.example.baselib;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by OldFour on 2017/6/14.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        init();
    }

    public Resources getBaseResources(){
        return getResources();
    }

    public abstract int setLayout();

    public abstract void init();


    public Intent getStartActivityIntent(String activityName){
        Intent intent =new Intent();
        intent.setClassName(this, activityName);
        return intent;
    }
}
