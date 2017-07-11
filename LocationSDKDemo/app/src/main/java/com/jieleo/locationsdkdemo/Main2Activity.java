package com.jieleo.locationsdkdemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void send(View view){
        sendBroadcast(new Intent("ha").putExtra("haha","我是广播的内容"));
        finish();
    }
}
