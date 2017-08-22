package com.example.jieleo.customviewdemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jieleo.customviewdemo.R;
import com.example.jieleo.customviewdemo.service.SyncService;

import java.util.Random;

public class ServerActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                startService(new Intent(this, SyncService.class));
                break;
            case R.id.stop:
                stopService(new Intent(this,SyncService.class));
                break;
            case R.id.send:

               int a= (int) (Math.random()*1000000);

                sendBroadcast(new Intent("order").putExtra("hh",a));
                break;
        }
    }
}
