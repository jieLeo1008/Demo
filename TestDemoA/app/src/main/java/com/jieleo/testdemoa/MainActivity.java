package com.jieleo.testdemoa;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ToB(View view){
        Intent intent =new Intent("TestDemoB.com", Uri.parse("value://123"));
        intent.putExtra("key","我是A中的值");
        startActivity(intent);
    }
}
