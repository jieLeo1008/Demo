package com.example.jieleo.toucheventdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private float x1;
    private float y1;
    private float x2;
    private float y2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()==MotionEvent.ACTION_DOWN){
            x1=event.getX();
            y1=event.getY();
        }
        if (event.getAction()==MotionEvent.ACTION_UP){
            x2=event.getX();
            y2=event.getY();
            if (y2-y1>50){
                Toast.makeText(this, "向下滑", Toast.LENGTH_SHORT).show();
            }else if (y1-y2>50){
                Toast.makeText(this, "向上滑", Toast.LENGTH_SHORT).show();
            }else if (x2-x1>50){
                Toast.makeText(this, "向右滑", Toast.LENGTH_SHORT).show();
            }else if (x1-x2>50){
                Toast.makeText(this, "向左滑", Toast.LENGTH_SHORT).show();
            }
        }
        return super.onTouchEvent(event);
    }
}
