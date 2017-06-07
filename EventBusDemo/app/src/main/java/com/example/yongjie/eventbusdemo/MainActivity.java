package com.example.yongjie.eventbusdemo;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.yongjie.eventbusdemo.login.LoginActivity;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView,tv_02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.event_bus_tv);
        tv_02 = (TextView) findViewById(R.id.tv_02);
        tv_02.setTextSize(50f);
        tv_02.setText("You Are The Best");
    }


    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        AssetManager manager =getAssets();
        Typeface typeface =Typeface.createFromAsset(manager,"front/rm_albion.ttf");
        tv_02.setTypeface(typeface);
    }


    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    public void toSecond(View view){
        startActivity(new Intent(this,LoginActivity.class));
    }


    @Subscribe
    public void getMessage(EventMsg eventMsg){
        mTextView.setText(eventMsg.getMsg());
    }
}
