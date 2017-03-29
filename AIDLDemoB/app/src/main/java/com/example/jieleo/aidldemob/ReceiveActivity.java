package com.example.jieleo.aidldemob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveActivity extends AppCompatActivity {
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
        Intent intent=getIntent();
        String data=intent.getStringExtra("key");
        if (data!=null){
        mTextView= (TextView) findViewById(R.id.tv);
        mTextView.setText(data);
        }
    }
}
