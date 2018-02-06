package com.benny.imoocdemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Benny on 2017/12/1.
 */

public class PermissionActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginBtn,downloadBtn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_permission);
        initView();
    }

    private void initView() {
        loginBtn=findViewById(R.id.login_btn);
        downloadBtn=findViewById(R.id.file_download_btn);
        loginBtn.setOnClickListener(this);
        downloadBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
                callPhone();
                break;
            case R.id.file_download_btn:
                sdCardPermission();
                break;
        }
    }

    private void callPhone() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            //做权限申请
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);
        }else {
            doCallPhone();
        }
    }


    private void sdCardPermission(){
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
            //未授予权限
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},0);

        }else {
            //处理业务逻辑
        }
    }


    private void doCallPhone() {
        Intent intent =new Intent(Intent.ACTION_CALL);
        Uri data=Uri.parse("tel:"+"10086");
        intent.setData(data);
        startActivity(intent);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                //打电话的权限回调处理
                if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    doCallPhone();
                }else {
                    //提示用户权限未被授予
                    Toast.makeText(this, "打电话权限未授予", Toast.LENGTH_SHORT).show();
                }
                break;
            case 0:
                if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "权限申请通过", Toast.LENGTH_SHORT).show();
                }else {
                    //未授予权限
                    Toast.makeText(this, "未授予写的权限", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
