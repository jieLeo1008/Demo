package com.example.jieleo.testramdemo;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {
    private Uri contentUri;
    private File mFile;
    private Bitmap mBitmap;
    private ImageView mImageView;
    private int SCREEN_WIDTH,SCREEN_HEIGHT;
    private int shiftpx=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mImageView = (ImageView) findViewById(R.id.image);
        DisplayMetrics dm =new DisplayMetrics();
        dm=this.getResources().getDisplayMetrics();
        SCREEN_WIDTH=dm.widthPixels;
        SCREEN_HEIGHT=dm.heightPixels;
    }

    /**
     * 显示图片
     * @param view
     */
    public void showPic(View view) {
        getPic();
    }

    /**
     * 采样率压缩
     * @param view
     */
    public void changeOptions(View view){
        changePicOpti();
    }

    /**
     * 改变Config
     * @param view
     */
    public void changeRGB(View view){
        changeRGB();
    }

    /**
     * 部分加载
     * @param view
     */
    public void partLoad(View view){
        partLoadPic();
    }

    public void movePic(View view){
        shiftpx+=10;
        partLoadPic();
    }

    private void getPic() {
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent, 1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            String path = getRealPathFromURI(data.getData());
            mFile = new File(path);
            if (mFile == null) {
                return;
            }
            if (mFile.length() == 0) {
                mFile.delete();
                return;
            }
            Log.d("SecondActivity", "file" + mFile.getName() + "length" + mFile.length());

            FileInputStream fileInputStream = new FileInputStream(mFile);
            mBitmap = BitmapFactory.decodeStream(fileInputStream);
            Log.d("SecondActivity", "mBitmap.getByteCount():" + mBitmap.getByteCount()/1024/1024);
            mImageView.setImageBitmap(mBitmap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.d("SecondActivity", "error" + e.toString());
        }
    }

    /**
     * 根据Uri获取File文件路径
     *
     * @param contentUri
     * @return
     */
    private String getRealPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = this.getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }

    private void changePicOpti() {
        if (mFile == null) {
            return;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(mFile),null,options);
            int width=options.outWidth,height=options.outHeight;
            int scale=width/SCREEN_WIDTH;
            BitmapFactory.Options options1=new BitmapFactory.Options();
            options1.inSampleSize=2;
            Log.d("SecondActivity", "scale:" + scale);
            mBitmap=BitmapFactory.decodeStream(new FileInputStream(mFile),null,options1);
            Log.d("SecondActivity", "mBitmap.getByteCount():" + mBitmap.getByteCount()/1024/1024);
            mImageView.setImageBitmap(mBitmap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * RGB565法压缩
     */
    private void changeRGB(){
        if (mFile==null){
            return;
        }
        BitmapFactory.Options options2=new BitmapFactory.Options();
        options2.inPreferredConfig= Bitmap.Config.RGB_565;
        try {
            mBitmap=BitmapFactory.decodeStream(new FileInputStream(mFile),null,options2);
            Log.d("SecondActivity", "mBitmap.getByteCount():" + mBitmap.getByteCount()/1024/1024);
            mImageView.setImageBitmap(mBitmap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 部分加载
     */
    private void partLoadPic(){
        if (mFile==null){
            return;
        }
        try {
            FileInputStream fileInputStream=new FileInputStream(mFile);
            //设置图片的宽高
            BitmapFactory.Options options3=new BitmapFactory.Options();
            options3.inJustDecodeBounds=true;
            BitmapFactory.decodeStream(fileInputStream,null,options3);
            int width=options3.outWidth;
            int height=options3.outHeight;

            //设置图片的中心区域
            fileInputStream=new FileInputStream(mFile);
            BitmapRegionDecoder bitmapRegionDecoder=BitmapRegionDecoder.newInstance(fileInputStream,false);
            BitmapFactory.Options options4=new BitmapFactory.Options();
            mBitmap=bitmapRegionDecoder.decodeRegion(new Rect(width/2-SCREEN_WIDTH/2+shiftpx,height/2-SCREEN_HEIGHT/2,width/2+SCREEN_WIDTH/2+shiftpx,height/2+SCREEN_HEIGHT/2),options4);
            Log.d("SecondActivity", "mBitmap.getByteCount():" + mBitmap.getByteCount()/1024/1024);
            mImageView.setImageBitmap(mBitmap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
