package com.example.jieleo.customviewdemo.tool;

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
 * Created by OldFour on 2017/5/22.
 */

public class OkTool  implements NetInter{

    private OkHttpClient mOkHttpClient;
    private Gson mGson;
    private Handler mHandler =new Handler(Looper.getMainLooper());

    public OkTool() {
        mGson=new Gson();
        mOkHttpClient=new OkHttpClient.Builder().retryOnConnectionFailure(true).connectTimeout(5, TimeUnit.SECONDS).cache(new Cache(Environment.getExternalStorageDirectory(),10*1024*1024)).build();
    }


    @Override
    public <T> void getDataFromUrl(String url, final Class<T> tClass, final CallBack<T> callBack) {
        final Request request=new Request.Builder().url(url).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.onError(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str=response.body().string();
                final T result=mGson.fromJson(str,tClass);
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
