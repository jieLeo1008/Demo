package com.example.jieleo.aidldemoa;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 可以跨进程传值
     * Intent
     * EventBus
     * BroadCastReceiver
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.jump_btn).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        /**
         * Intent在两个App中传值
         * 第一个参数是我们要跳转的Activity名字
         * 第二个参数是一个地址
         */
        Intent intent=new Intent("AIDLDemoB.com",Uri.parse("value://12345678"));
        intent.putExtra("key","我是DemoA的值");
        startActivity(intent);
    }
}
