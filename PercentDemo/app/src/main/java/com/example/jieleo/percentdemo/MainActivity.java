package com.example.jieleo.percentdemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SeekBar mSeekBar;
    private Button startBtn;
    private int progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSeekBar = (SeekBar) findViewById(R.id.my_seek_bar);
        startBtn = (Button) findViewById(R.id.start_btn);
        startBtn.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mSeekBar.setMax(100);
                while (progress<100){
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                            mSeekBar.setProgress(progress);


                            Log.d("MainActivity", "progress:" + progress);

                        }
                });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    progress+=1;
                }


            }
        }).start();
    }
}
