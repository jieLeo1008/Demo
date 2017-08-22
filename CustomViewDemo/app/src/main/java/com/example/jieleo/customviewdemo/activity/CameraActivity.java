package com.example.jieleo.customviewdemo.activity;

import android.Manifest;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jieleo.customviewdemo.R;
import com.example.jieleo.customviewdemo.tool.NetPostTool;

import java.io.File;

import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;
import okhttp3.FormBody;

public class CameraActivity extends AppCompatActivity implements View.OnClickListener{

    private File mFile;

    public static int REQUEST_CAMERA=100;

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        mImageView = (ImageView) findViewById(R.id.iv_01);

        try {
        mImageView.setOnClickListener(this);

        }catch (Exception e){
            Log.d("CameraActivity", e.toString());
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.use_camera:

                PermissionGen.needPermission(this,100,new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE});

                break;
            case R.id.start_request:

                startRequest();

                break;
        }
    }

    private void startRequest() {
//        FormBody formBody=new FormBody.Builder()
//                .add("title","哈哈哈哈哈哈呀呀呀呀")



//        NetPostTool.getInstance().startPostRequest("",);




    }

    @PermissionSuccess(requestCode = 100)
    public void success(){
            useCamera();
    }

    @PermissionFail(requestCode = 100)
    public void failed(){
        Toast.makeText(this, "申请失败", Toast.LENGTH_SHORT).show();
    }


    private void useCamera(){
        Intent intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        mFile=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/test/"+System.currentTimeMillis()+".jpg");

        mFile.getParentFile().mkdirs();
        //改变Uri
        Uri uri = FileProvider.getUriForFile(this,"com.example.jieleo.customviewdemo.fileprovdier",mFile);
        //添加权限
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        intent.putExtra(MediaStore.EXTRA_OUTPUT,uri);

        startActivityForResult(intent,REQUEST_CAMERA);

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionGen.onRequestPermissionsResult(this,requestCode,permissions,grantResults);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CAMERA && resultCode == RESULT_OK) {

//            Log.e("TAG", "---------" + FileProvider.getUriForFile(this, "com.xykj.customview.fileprovider", file));
//            mImageView.setImageBitmap(BitmapFactory.decodeFile(mFile.getAbsolutePath()));

            try {
            mImageView.setImageURI(Uri.fromFile(mFile));

            }catch (Exception e){
                Log.d("CameraActivity", e.toString());
            }

            //在手机相册中显示刚拍摄的图片
            Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            Uri contentUri = Uri.fromFile(mFile);
            mediaScanIntent.setData(contentUri);
            sendBroadcast(mediaScanIntent);
        }
    }
}
