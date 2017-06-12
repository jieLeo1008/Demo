package com.sishuai.permissiondemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.sishuai.permissiondemo.permisson.MPermission;
import com.sishuai.permissiondemo.permisson.PermissionFailed;
import com.sishuai.permissiondemo.permisson.PermissionSuccess;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onMyClick(View v){
        MPermission.needPermission(this,200,new String[]{Manifest.permission.CAMERA});




        //动态申请相机权限
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
//                != PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},100);
//        }else {
//            openCamera();
//        }
//        openCamera();
    }
    @PermissionSuccess(requestCode = 200)
    public void requestPermissionSuccess(){
        openCamera();
    }
    @PermissionFailed(requestCode = 200)
    public void requestPermissionFailed(){
        Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();
    }
    //请求吗 请求权限 对应信息
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //将系统返回的授权结果交给封装类进行处理
        MPermission.onRequestPermissionsResult(this,requestCode,permissions,grantResults);
//        if (requestCode == 100){
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                Toast.makeText(this, "授权成功", Toast.LENGTH_SHORT).show();
//                openCamera();
//            }
//        }
    }

    private void openCamera() {
        android.hardware.Camera camera = android.hardware.Camera.open();

        Log.d("MainActivity", "camera:" + camera);
    }
}
