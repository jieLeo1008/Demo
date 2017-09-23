package com.example.jieleo.customviewdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.jieleo.customviewdemo.R;
import com.example.jieleo.customviewdemo.utils.manager.ThreadPoolManager;
import com.hyphenate.chat.ChatClient;
import com.hyphenate.helpdesk.callback.Callback;
import com.hyphenate.helpdesk.easeui.util.IntentBuilder;

public class GetRunningProcessActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_running_process);

        ChatClient.getInstance().login("3FC4CD0E39814C0093A207F6E34B708D87527", "123456", new Callback() {
            @Override
            public void onSuccess() {
                Log.d("GetRunningProcessActivi", "success");
            }

            @Override
            public void onError(int i, String s) {
                Log.d("GetRunningProcessActivi", "onError");
                Log.d("GetRunningProcessActivi", s);
            }

            @Override
            public void onProgress(int i, String s) {
                Log.d("GetRunningProcessActivi", "onProgress");
                Log.d("GetRunningProcessActivi", s);
            }
        });


        findViewById(R.id.start_thread).setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.login:
                Intent intent = new IntentBuilder(GetRunningProcessActivity.this)
                        .setServiceIMNumber("kefuchannelimid_073903") //获取地址：kefu.easemob.com，“管理员模式 > 渠道管理 > 手机APP”页面的关联的“IM服务号”
                        .build();
                startActivity(intent);
                break;
            case R.id.log_out:
                //第一个参数为是否解绑推送的devicetoken
                ChatClient.getInstance().logout(true, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.d("GetRunningProcessActivi", "退出成功");
                    }

                    @Override
                    public void onError(int i, String s) {
                        Log.d("GetRunningProcessActivi", "退出异常");
                    }

                    @Override
                    public void onProgress(int i, String s) {

                        Log.d("GetRunningProcessActivi", "onProgress");
                    }
                });
                break;
            case R.id.start_thread:

                for (int i = 0; i < 10; i++) {
                    ThreadPoolManager.getInstance().execute(new DownloadTask(i));

                }

                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    class DownloadTask implements Runnable{
        private int num;
        public DownloadTask(int num) {
            super();
            this.num = num;
            Log.d("JAVA", "task - "+num + " 等待中...");
        }
        @Override
        public void run() {
            Log.d("JAVA", "task - "+num + " 开始执行了...开始执行了...");
            SystemClock.sleep(5000); //模拟延时执行的时间
            Log.e("JAVA", "task - "+num + " 结束了...");
        }
    }
}
