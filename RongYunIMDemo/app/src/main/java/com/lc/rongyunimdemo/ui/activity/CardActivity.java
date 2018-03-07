package com.lc.rongyunimdemo.ui.activity;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.lc.rongyunimdemo.R;

public class CardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
         new Thread(new Runnable() {
             @Override
             public void run() {
                 try {
                     Thread.sleep(3*1000);
//                     if (Looper.myLooper()!=null){
//                         Looper.prepare();
//                     }
                     new Handler(Looper.getMainLooper()).post(new Runnable() {
                         @Override
                         public void run() {

                     Toast.makeText(CardActivity.this, "test", Toast.LENGTH_SHORT).show();
                         }
                     });
//                     Looper.loop();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         }).start();

    }





}
