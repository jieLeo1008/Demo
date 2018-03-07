package com.lc.rongyunimdemo.ui.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.lc.rongyunimdemo.R;
import com.lc.rongyunimdemo.network.GetToken;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

public class ChatActivity extends AppCompatActivity {

    private final String token1 = "kDcUTP6MiUQCHg8yMI48l5TJon7hd+dhi8IkQ/NvjhwJ8EyIkYJtZ0RYZ8QKeH6leCjmeifucdHKqv4jldl4Ow==";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        RongIM.connect(token1, new RongIMClient.ConnectCallback() {
            @Override
            public void onTokenIncorrect() {
                Log.d("ChatActivity", "token不正确");
            }

            @Override
            public void onSuccess(String s) {
                Log.d("ChatActivity", "token验证成功");

            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                Log.d("ChatActivity", "错误");
            }
        });


    }
}
