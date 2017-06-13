package com.sishuai.permissiondemo;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Camera;

import android.icu.util.Calendar;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.sishuai.permissiondemo.permisson.MPermission;
import com.sishuai.permissiondemo.permisson.PermissionFailed;
import com.sishuai.permissiondemo.permisson.PermissionSuccess;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.iv_01);
    }

    public void onMyClick(View v) {
        MPermission.needPermission(this, 200, new String[]{Manifest.permission.CAMERA});


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
    public void requestPermissionSuccess() {
        openCamera();
    }

    @PermissionFailed(requestCode = 200)
    public void requestPermissionFailed() {
        Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();
    }

    //请求吗 请求权限 对应信息
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //将系统返回的授权结果交给封装类进行处理
        MPermission.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
//        if (requestCode == 100){
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                Toast.makeText(this, "授权成功", Toast.LENGTH_SHORT).show();
//                openCamera();
//            }
//        }
    }

    private void openCamera() {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("MainActivity", "requestCode:" + requestCode);
        if (resultCode == Activity.RESULT_OK) {
            String sdStatus = Environment.getExternalStorageState();
            if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) {
                Toast.makeText(this, "SdCard is not available", Toast.LENGTH_SHORT).show();
            }
            String name = new DateFormat().format("yyyyMMdd_hhmmss", java.util.Calendar.getInstance(Locale.CHINA)) + ".jpg";
            Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");
            FileOutputStream fois = null;
            File file = new File("/sdcard/myImage");
            file.mkdirs();
            String fileName = "/sdcard/myImage/" + name;
            try {
                fois = new FileOutputStream(fileName);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fois);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    fois.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            mImageView.setImageBitmap(bitmap);
        }
    }
}
