package com.jieleo.rxjavademo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private String url="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490600695&di=a3936bf8fe65a5176091d0292251193f&imgtype=jpg&er=1&src=http%3A%2F%2Fa.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F9358d109b3de9c82d94b518a6e81800a19d8438c.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView imageView= (ImageView) findViewById(R.id.image);

        getBitMap(url).
                //声明Observer在子线程中运行
                subscribeOn(Schedulers.io())
                //返回结果回到主线程
                .observeOn(AndroidSchedulers.mainThread()).subscribe(bitmap -> {
                    imageView.setImageBitmap(bitmap);
                });

    }

    public Observable<Bitmap>  getBitMap(String url){
        return Observable.just(url).map(new Func1<String, Bitmap>() {
            @Override
            public Bitmap call(String s) {
                Bitmap bitmap=null;
                try {
                    URL url1=new URL(url);
                    try {
                        HttpURLConnection httpURLConnection= (HttpURLConnection) url1.openConnection();
                        InputStream is =httpURLConnection.getInputStream();
                        bitmap= BitmapFactory.decodeStream(is);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                return bitmap;
            }
        });
    }

}
