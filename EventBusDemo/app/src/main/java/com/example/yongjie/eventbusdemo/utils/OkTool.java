package com.example.yongjie.eventbusdemo.utils;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by OldFour on 2017/6/7.
 */

public class OkTool implements NetInter{

    private OkHttpClient mOkHttpClient;

    private Gson mGson;

    private Handler mHandler =new Handler(Looper.getMainLooper());

    public OkTool() {
        mGson =new Gson();
        mOkHttpClient=new OkHttpClient.Builder()
                .connectTimeout(3000, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .cache(new Cache(Environment.getExternalStorageDirectory(),1024*1024*10)).build();
    }



    @Override
    public <T> void startRequest(String url, final Class<T> tClass, final CallBack<T> callBack) {
        Request request =new Request.Builder().url(url).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.onFail(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str =response.body().string();
                final T result =mGson.fromJson(str,tClass);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(result);
                    }
                });
            }
        });
    }
}
