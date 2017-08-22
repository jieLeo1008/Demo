package com.jieleo.tileoverlydemo.activity;

import android.Manifest;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.jieleo.tileoverlydemo.R;
import com.jieleo.tileoverlydemo.utils.permission.MPermission;
import com.jieleo.tileoverlydemo.utils.permission.PermissionFailed;
import com.jieleo.tileoverlydemo.utils.permission.PermissionSuccess;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MPermission.needPermission(this,100,new String[]{Manifest.permission.CAMERA});
    }

    @PermissionSuccess(requestCode = 100)
    public void requestPermissionSuccess(){
        Toast.makeText(this, "申请成功", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,FirstLocoActivity.class));
    }

    @PermissionFailed(requestCode = 100)
    public void requestPermissionFailed(){
        Toast.makeText(this, "申请权限失败", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MPermission.onRequestPermissionsResult(this,requestCode,permissions,grantResults);
    }
}
