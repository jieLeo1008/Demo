package com.jieleo.mysimpledemo.java.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.jieleo.mysimpledemo.R;
import com.jieleo.mysimpledemo.kotlin.MainActivity;

import java.security.Permission;

import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;


public class WelcomeActivity extends AppCompatActivity {


    public static final  int REQUEST_PERMISSION_CODE=100;

    private ImageView mImageView;

    private int[] picList=new int[]{R.mipmap.first,R.mipmap.second,R.mipmap.third};

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {

            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
            finish();
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mImageView = (ImageView) findViewById(R.id.start_iv);

        mImageView.setBackgroundResource(picList[(int) (Math.random() * picList.length)]);


        getPermission();


    }

    private void getPermission() {
        PermissionGen.needPermission(this,REQUEST_PERMISSION_CODE,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE});
    }

    @PermissionSuccess(requestCode = REQUEST_PERMISSION_CODE)
    public void success(){

        mHandler.sendEmptyMessageDelayed(100,2000);

    }

    @PermissionFail(requestCode = REQUEST_PERMISSION_CODE)
    public void failed(){
        Toast.makeText(this, "如需正常运行 请允许权限", Toast.LENGTH_SHORT).show();
    }
}
