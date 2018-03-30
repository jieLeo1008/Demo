package com.lc.duoweidu.project;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.File;

public class ImageActivity extends AppCompatActivity {

    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        mImageView =findViewById(R.id.iv01);

        String path=getIntent().getStringExtra("path");


        Bitmap bitmap = BitmapFactory.decodeFile(path);

        mImageView.setImageBitmap(bitmap);

    }
}
