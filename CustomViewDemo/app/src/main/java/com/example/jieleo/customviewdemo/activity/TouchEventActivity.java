package com.example.jieleo.customviewdemo.activity;


import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


import com.example.jieleo.customviewdemo.R;
import com.example.jieleo.customviewdemo.utils.manager.NetWorkManager;
import com.example.jieleo.customviewdemo.utils.manager.ThreadPoolManager;

import java.util.ArrayList;
import java.util.List;

public class TouchEventActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private boolean ThreadState = true;

    private DownLoadThread mDownLoadThread;


    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event);

        findViewById(R.id.btn_01).setOnClickListener(this);
        findViewById(R.id.btn_01).setOnTouchListener(this);

        findViewById(R.id.to_pai).setOnClickListener(this);



        mDownLoadThread = new DownLoadThread();

//        ThreadPoolManager.getInstance().execute(mDownLoadThread);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_01:
                startActivity(new Intent(this,WheelAddressSelectActivity.class));
                break;
            case R.id.to_pai:
                try{
                startActivity(new Intent().setAction(Intent.ACTION_VIEW).setData(Uri.parse("http:")));

                }catch (Exception e){
                    Log.d("TouchEventActivity", e.toString());

                }
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        ThreadPoolManager.getInstance().remove(mDownLoadThread);

        List<String> list=new ArrayList<>();

        for (String s : list) {

        }


        for (int i = 0; i < 10; i++) {


        }


    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {


        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {


        return false;
    }

    public class DownLoadThread implements Runnable {

        @Override
        public void run() {
            while (ThreadState) {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("TouchEventActivity", "NetWorkManager.getInstance().getConnectType(TouchEventActivity.this):" + NetWorkManager.getInstance().getConnectType(TouchEventActivity.this));

                Log.d("TouchEventActivity", "Runtime.getRuntime().availableProcessors():" + Runtime.getRuntime().availableProcessors());

                Log.d("TouchEventActivity", "android.os.Process.myTid():" + Process.myTid());
            }
        }
    }


}
