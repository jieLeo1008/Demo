package com.example.jieleo.myrxjavademo;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by OldFour on 2017/5/27.
 */

public class RetrofitTool {
    public static RetrofitTool ourInstance ;

    public static Retrofit mRetrofit;

    public static RetrofitTool getInstance() {
        if (ourInstance==null){
            synchronized (RetrofitTool.class){
                if (ourInstance==null){
                    ourInstance=new RetrofitTool();
                }

            }
        }
        return ourInstance;
    }

    private RetrofitTool() {
        mRetrofit=new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }


}
