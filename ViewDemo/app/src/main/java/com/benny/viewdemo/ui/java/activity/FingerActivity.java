package com.benny.viewdemo.ui.java.activity;

import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.benny.viewdemo.R;

public class FingerActivity extends BaseActivity {

    private FingerprintManager mFingerprintManager ;
    private KeyguardManager mKeyguardManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger);




    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void findView() {

        mFingerprintManager= (FingerprintManager) getSystemService(Context.FINGERPRINT_SERVICE);

        mKeyguardManager= (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);



    }

    @Override
    public void initView() {

        findViewById(R.id.btn01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void setOnClick() {

    }

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void initData() {

    }



    @TargetApi(Build.VERSION_CODES.M)
    public boolean isFinger() {
        if (!mFingerprintManager.isHardwareDetected()) {
            Toast.makeText(this, "没有指纹识别模块", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!mKeyguardManager.isKeyguardSecure()) {
            Toast.makeText(this, "没有开启锁屏密码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!mFingerprintManager.hasEnrolledFingerprints()) {
            Toast.makeText(this, "没有录入指纹", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}
