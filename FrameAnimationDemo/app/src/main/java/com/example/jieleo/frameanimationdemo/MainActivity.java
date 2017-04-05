package com.example.jieleo.frameanimationdemo;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView mImageView;
    private AnimationDrawable mAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.iv);
        mImageView.setBackgroundResource(R.drawable.animiation);
        mAd = (AnimationDrawable) mImageView.getBackground();
        mAd.start();
    }

    public void myClick(View view){
        mAd.stop();
    }
    public void toSecond(View view){
        startActivity(new Intent(this,Main2Activity.class));
    }
}
