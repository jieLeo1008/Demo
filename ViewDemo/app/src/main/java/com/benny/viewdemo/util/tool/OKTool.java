package com.benny.viewdemo.util.tool;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.jieleo.xmly_plus.model.bean.model_search_.SearchBean;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by liuHao on 17/2/10.
 */
public class OKTool implements NetInterface{
    private OkHttpClient okHttpClient;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Gson gson;
    public OKTool() {
        //初始化Gson对象
        gson = new Gson();

        //初始化对象
        okHttpClient = new  OkHttpClient.Builder().retryOnConnectionFailure(true).
                connectTimeout(5, TimeUnit.SECONDS).
//               缓存到SD卡
                cache(new Cache(Environment.getExternalStorageDirectory(),10*1024*1024)).build();

    }

    @Override
    public void startRequest(String url, final CallBack<String> callBack) {
        Request request = new  Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                    final String str = response.body().string();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onSuccess(str);
                        }
                    });
            }
        });
    }

    @Override
    public <T> void startRequest(String url, final Class<T> tClass, final CallBack<T> callBack) {
            Request request = new Request.Builder().url(url).build();
            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, final IOException e) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onError(e);
                        }
                    });

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String str = response.body().string();
                    final T result = gson.fromJson(str,tClass);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onSuccess(result);
                        }
                    });
                }
            });
    }

    @Override
    public <T> void startRequest(String url, Class<T> tClass, final CallBackNew callBack) {
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError(e);
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                final SearchBean[] result = gson.fromJson(str,SearchBean[].class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(result);
                    }
                });
            }
        });
    }
}
