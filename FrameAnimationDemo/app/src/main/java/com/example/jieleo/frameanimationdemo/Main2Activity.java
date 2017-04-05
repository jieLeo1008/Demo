package com.example.jieleo.frameanimationdemo;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mImageView= (ImageView) findViewById(R.id.image);
        AnimationDrawable ad =new AnimationDrawable();
        for (int i=1;i<5;i++){
            int id=getResources().getIdentifier("image"+i,"drawable",getPackageName());
            Drawable drawable=getResources().getDrawable(id);
            ad.addFrame(drawable,120);
        }
        mImageView.setBackgroundDrawable(ad);
        ad.setOneShot(false);
        AnimationDrawable animationDrawable= (AnimationDrawable) mImageView.getBackground();
        animationDrawable.start();
    }
}
