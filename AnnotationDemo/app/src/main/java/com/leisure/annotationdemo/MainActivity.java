package com.leisure.annotationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


@MyContentView(R.layout.activity_main)

public class MainActivity extends AppCompatActivity {
    @MyFindViewById(R.id.tv)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewTool.inject(this);
    }

    @MyClick(R.id.tv)
    public void click(View view){
        switch (view.getId()) {
            case R.id.tv:
                Toast.makeText(MainActivity.this, "aaaa", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ViewTool.unInject();
    }
}
