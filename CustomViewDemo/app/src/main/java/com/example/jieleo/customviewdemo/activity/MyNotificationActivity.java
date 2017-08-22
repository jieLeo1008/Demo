package com.example.jieleo.customviewdemo.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jieleo.customviewdemo.R;
import com.example.jieleo.customviewdemo.utils.window.WindowUtils;

public class MyNotificationActivity extends AppCompatActivity {


    private Handler mHandler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notification);

        mHandler = new Handler();

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                mHandler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        WindowUtils.showPopupWindow(MyNotificationActivity.this);

                    }
                }, 0);

            }
        });
    }

}
