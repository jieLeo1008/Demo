package com.example.jieleo.customviewdemo.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.appcompat.BuildConfig;
import android.view.View;
import android.widget.TextView;

import com.example.jieleo.customviewdemo.R;

public class PermissionCheckActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_check);

        findViewById(R.id.btn_01).setOnClickListener(this);
        findViewById(R.id.btn_02).setOnClickListener(this);
        findViewById(R.id.btn_03).setOnClickListener(this);

        findViewById(R.id.btn_04).setOnClickListener(view -> mTextView.setText("hhh"));

        mTextView = (TextView) findViewById(R.id.tv_001);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_01:

                mTextView.setText(Build.MANUFACTURER);

                break;
            case R.id.btn_02:
                Intent intent = new Intent();
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("packageName", BuildConfig.APPLICATION_ID);
                ComponentName comp = new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
                intent.setComponent(comp);
                startActivity(intent);

                break;
            case R.id.btn_03:
                Intent intent1 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                intent1.addCategory(Intent.CATEGORY_DEFAULT);
                intent1.putExtra("packageName", BuildConfig.APPLICATION_ID);
                startActivity(intent1);

                break;
        }
    }
}
