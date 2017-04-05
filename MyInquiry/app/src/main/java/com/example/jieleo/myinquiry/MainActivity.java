package com.example.jieleo.myinquiry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cheshouye.api.client.WeizhangIntentService;

public class MainActivity extends AppCompatActivity {

    private Intent weizhangIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weizhangIntent=new Intent(this, WeizhangIntentService.class);
        weizhangIntent.putExtra("appId", 2477);
        weizhangIntent.putExtra("appKey","d3414a3c0d4c00c49bf4c88e9a57db7a");
        startService(weizhangIntent);
    }
}
