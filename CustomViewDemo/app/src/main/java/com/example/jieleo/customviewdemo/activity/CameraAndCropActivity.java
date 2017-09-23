package com.example.jieleo.customviewdemo.activity;


import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jieleo.customviewdemo.BaseActivity;
import com.example.jieleo.customviewdemo.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;

public class CameraAndCropActivity extends BaseActivity implements View.OnClickListener {

    private static final int CROP_PHOTP = 20;
    private Button take_camera;

    private ImageView show_IV;

    private Uri imageUri;

    public static final int TAKE_PTOTO = 10;


    @Override
    public int bindLayout() {
        return R.layout.activity_camera_and_crop;
    }

    @Override
    public void initView() {
        take_camera = bindView(R.id.btn_01);

        show_IV = bindView(R.id.iv_01);
    }

    @Override
    public void initData() {

        PermissionGen.needPermission(this,100,new String[]{Manifest.permission.CAMERA});
    }

    @PermissionSuccess(requestCode = 100)
    public void success(){

        Toast.makeText(this, "申请成功", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void bindEvent() {
        take_camera.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_01:

                Toast.makeText(this, "点击了button", Toast.LENGTH_SHORT).show();
                File outputImage = new File(Environment.getExternalStorageDirectory(), new Date() + ".jpg");
                try {
                    if (outputImage.exists()) {

                        outputImage.delete();

                    }
                    outputImage.createNewFile();


                } catch (IOException e) {
                    e.printStackTrace();
                }

                imageUri = Uri.fromFile(outputImage);

                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");

                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);

                startActivityForResult(intent, TAKE_PTOTO);

                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {

            case TAKE_PTOTO:

                if (resultCode == RESULT_OK) {
                    Intent intent = new Intent("com.android.camera.action.CROP");

                    intent.setDataAndType(imageUri, "image/*");

                    intent.putExtra("scale", true);

                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);

                    startActivityForResult(intent, CROP_PHOTP);
                }

                break;
            case CROP_PHOTP:

                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));

                        show_IV.setImageBitmap(bitmap);

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }

                break;
            default:

                break;
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionGen.onRequestPermissionsResult(this,100,permissions,grantResults);
    }
}
