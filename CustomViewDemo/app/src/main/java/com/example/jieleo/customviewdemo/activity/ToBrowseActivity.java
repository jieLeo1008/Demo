package com.example.jieleo.customviewdemo.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.jieleo.customviewdemo.R;

public class ToBrowseActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_browse);


        findViewById(R.id.btn_01).setOnClickListener(this);




    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d("ToBrowseActivity", "Lalalal");
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
//        Uri content_url = Uri.parse("https://app.pi-group.biz/appdownload/us/pi.html?ts=167&amp;from=singlemessage\n");
        Uri content_url = Uri.parse("http://www.baidu.com");
        intent.setData(content_url);
        startActivity(intent);
    }
}
