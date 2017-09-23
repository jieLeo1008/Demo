package com.jieleo.mysimpledemo.java.activity;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.jieleo.mysimpledemo.R;
import com.jieleo.mysimpledemo.java.view.MyWebView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class ExtractQRCodeActivity extends BaseActivity implements View.OnLongClickListener, MyWebView.LongClickCallBack {


    private ImageView mImageView;

    private MyWebView mWebView;


    @Override
    public int bindLayout() {
        return R.layout.activity_extract_qrcode;
    }

    @Override
    public void initView() {

        NEED_FULLSCREEN = false;

        mImageView = bindView(R.id.scan_iv);

        mWebView=new MyWebView(this,this);

        mWebView.loadUrl("http://192.168.2.1:8080/test.html");

        mWebView.setFocusable(true);

        mWebView.setFocusableInTouchMode(true);

        ViewGroup.LayoutParams  layoutParams =new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        addContentView(mWebView,layoutParams);

    }

    @Override
    public void initDate() {
        mImageView.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.qrcode));



    }

    @Override
    public void bindEvent() {
        mImageView.setOnLongClickListener(this);
    }


    private Result isAQRCode(ImageView imageView) {

        Bitmap obmp = convertViewToBitmap(imageView);

        int width = obmp.getWidth();
        int height = obmp.getHeight();
        int[] data = new int[width * height];

        obmp.getPixels(data, 0, width, 0, 0, width, height);

        RGBLuminanceSource source = new RGBLuminanceSource(width, height, data);

        BinaryBitmap bitmap1 = new BinaryBitmap(new HybridBinarizer(source));

        QRCodeReader reader = new QRCodeReader();

        Result result = null;

        try {

            result = reader.decode(bitmap1);

        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (ChecksumException e) {
            e.printStackTrace();
        } catch (FormatException e) {
            e.printStackTrace();
        }
        return result;

    }

    private Result isAQRCode(Bitmap bitmap){

        if (bitmap==null){
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] data = new int[width * height];

        bitmap.getPixels(data, 0, width, 0, 0, width, height);

        RGBLuminanceSource source = new RGBLuminanceSource(width, height, data);

        BinaryBitmap bitmap1 = new BinaryBitmap(new HybridBinarizer(source));

        QRCodeReader reader = new QRCodeReader();

        Result result = null;

        try {

            result = reader.decode(bitmap1);

        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (ChecksumException e) {
            e.printStackTrace();
        } catch (FormatException e) {
            e.printStackTrace();
        }
        return result;
    }


    public Bitmap convertViewToBitmap(View view) {

        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));

//        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());

        view.buildDrawingCache();

        Bitmap bitmap = view.getDrawingCache();

        return bitmap;
    }

    @Override
    public boolean onLongClick(View view) {

        switch (view.getId()) {
            case R.id.scan_iv:

                AlertDialog alertDialog = new AlertDialog.Builder(this)
                        .setMessage("识别二维码")
                        .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Log.d("ExtractQRCodeActivity", "isAQRCode(mImageView):" + isAQRCode(mImageView).getText());
                            }
                        }).setNeutralButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }).create();


                alertDialog.show();

                break;
        }


        return false;
    }


    @Override
    public void onLongClickCallBack(final String imgUrl) {
        Log.d("ExtractQRCodeActivity", imgUrl);
            String url =imgUrl;

        new Thread(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap=getBitmap(imgUrl);
                if (isAQRCode(bitmap)==null){
                    Log.d("ExtractQRCodeActivity", "没有二维码");
                }else {
                    String url =isAQRCode(bitmap).getText();
                    Log.d("ExtractQRCodeActivity", url);

                    startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url)));



                }
            }
        }).start();

//        Bitmap bitmap=getBitmap(url);
//        Log.d("ExtractQRCodeActivity", "bitmap:" + bitmap);
//        if (isAQRCode(bitmap)==null) {
//            Toast.makeText(this, "没有二维码", Toast.LENGTH_SHORT).show();
//        }
//        }else {
//            Log.d("ExtractQRCodeActivity", isAQRCode(bitmap).getText());
//        }

    }

    /**
     * 根据地址获取网络图片
     * @param sUrl 图片地址
     * @return
     * @throws IOException
     */
    public  Bitmap getBitmap(String sUrl){
        Log.d("ExtractQRCodeActivity", sUrl);
        try {
            URL url = new URL(sUrl);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            if(conn.getResponseCode() == 200){
                InputStream inputStream = conn.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                Log.d("ExtractQRCodeActivity", "返回Bitmap");
                return bitmap;
            }
            Log.d("ExtractQRCodeActivity", "返回Null");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }



}
