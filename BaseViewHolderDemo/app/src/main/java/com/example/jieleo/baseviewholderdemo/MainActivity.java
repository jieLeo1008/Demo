package com.example.jieleo.baseviewholderdemo;

import android.icu.util.TimeUnit;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {


    String URL="http://api.liwushuo.com/v2/columns?limit=20&offset=0";

//    private OkHttpClient mOkHttpClient;

//    private Request mRequest;

//    private Gson mGson;

    private Bean mBean;

    private RecyclerView mRecyclerView;

    private RecyclerViewAdapter mAdapter;

//    private Handler mHandler=new Handler(getMainLooper());

//    private Handler mHandler=new Handler(getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
//        mGson=new Gson();
        mAdapter=new RecyclerViewAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        NetTool.getInstance().startRequest(URL, Bean.class, new CallBack<Bean>() {
            @Override
            public void onSuccess(Bean response) {
                mAdapter.setBean(response);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
//        mOkHttpClient=new OkHttpClient.Builder().connectTimeout(5, java.util.concurrent.TimeUnit.SECONDS)
//                .retryOnConnectionFailure(true)
//                .build();
//        mRequest=new Request.Builder().url(URL).build();
//
//        mOkHttpClient.newCall(mRequest).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(final Call call, Response response) throws IOException {
//                final String string=response.body().string();
//                mBean=mGson.fromJson(string,Bean.class);
//                Log.d("MainActivity", mBean.getData().getColumns().get(0).getAuthor());
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        mAdapter.setBean(mBean);
//                    }
//                });
//            }
//        });
    }


    @Override
    protected void onStart() {
        super.onStart();


    }
}
