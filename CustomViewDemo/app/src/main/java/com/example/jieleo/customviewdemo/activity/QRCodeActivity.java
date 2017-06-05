package com.example.jieleo.customviewdemo.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.jieleo.customviewdemo.R;
import com.github.sumimakito.awesomeqr.AwesomeQRCode;

public class QRCodeActivity extends AppCompatActivity {

    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        mImageView = (ImageView) findViewById(R.id.iv_01);
        new AwesomeQRCode.Renderer().contents("www.baidu.com").size(800).background(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher_round))
                .renderAsync(new AwesomeQRCode.Callback() {
                    @Override
                    public void onRendered(AwesomeQRCode.Renderer renderer, Bitmap bitmap) {
                        mImageView.setImageBitmap(bitmap);
                    }

                    @Override
                    public void onError(AwesomeQRCode.Renderer renderer, Exception e) {

                    }
                });
    }
}
