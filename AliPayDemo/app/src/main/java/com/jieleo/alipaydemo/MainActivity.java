package com.jieleo.alipaydemo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alipay.sdk.app.PayTask;

public class MainActivity extends AppCompatActivity {

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            Result result = new Result((String) msg.obj);
            Toast.makeText(DemoActivity.this, result.getResult(),
                    Toast.LENGTH_LONG).show();
        };
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String orderInfo = "买大米";   // 订单信息

        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(DemoActivity.this);
                String result = alipay.payV2(orderInfo,true);

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();

    }



}
