package com.hyphenate.easeui.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.hyphenate.easeui.R;
import com.hyphenate.easeui.utils.SPUtil;

public class Test1Activity extends AppCompatActivity {

    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        mTextView = (TextView) findViewById(R.id.tv_01);
        mTextView.setText(SPUtil.get(this,"USER_NAME","").toString());
    }
}
