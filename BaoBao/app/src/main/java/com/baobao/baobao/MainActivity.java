package com.baobao.baobao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    TextView mTextView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView=findViewById(R.id.tv);

        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy年MM月dd日 HH:mm:SS");
        String start="2017年12月23日 00:00:00";

        try {
            Date date   =simpleDateFormat.parse(start);

            Long statrL=date.getTime();

            Long now =(new Date().getTime());

            Long a=now-statrL;

            long days=(a/1000)/86400;


            mTextView.setText("我和宝宝在一起已经 "+days+"天了");

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
