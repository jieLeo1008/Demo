package com.example.jieleo.customviewdemo.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.example.jieleo.customviewdemo.R;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CatulatorBitmapActivity extends AppCompatActivity {

    @InjectView(R.id.iv_01)
    ImageView mIv01;

    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catulator_bitmap);
        ButterKnife.inject(this);
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/ccccc.jpg");
        Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/ccccc.jpg");
//        mIv01.setImageBitmap(bitmap);
        byte[] bytes = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fileInputStream.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fileInputStream.close();
            bos.close();
            bytes = bos.toByteArray();
//            Log.d("CatulatorBitmapActivity", ToHexString(bytes));

            Log.d("CatulatorBitmapActivity", "++++++++++++++++++");
            Log.d("CatulatorBitmapActivity", new String(bytes, "iso8859-1"));
            str = new String(bytes, "UTF-8");


            getFile(toByte(str),Environment.getExternalStorageDirectory().getAbsolutePath()+"/Download/","eeee.jpg");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String ToHexString(byte[] bytes) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] chars = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int b = bytes[i];//十六进制转化为十进制 0x34->52
            chars[i * 2] = hexDigits[b >> 4];
            chars[i * 2 + 1] = hexDigits[b & 0xF];
        }
        return new String(chars);
    }

    private byte[] toByte(String str) {
        byte[] bytes=str.getBytes();
        Log.d("CatulatorBitmapActivity", "bytes.length:" + bytes.length);

        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,5,10);
        mIv01.setImageBitmap(bitmap);
        return bytes;
    }

    public static void getFile(byte[] bfile, String filePath,String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if(!dir.exists()&&dir.isDirectory()){//判断文件目录是否存在
                dir.mkdirs();
            }
            file = new File(filePath+"\\"+fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }



}
