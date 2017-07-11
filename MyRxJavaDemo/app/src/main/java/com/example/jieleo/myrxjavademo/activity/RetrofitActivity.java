package com.example.jieleo.myrxjavademo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.jieleo.myrxjavademo.MovieBean;
import com.example.jieleo.myrxjavademo.MovieService;
import com.example.jieleo.myrxjavademo.R;
import com.example.jieleo.myrxjavademo.RetrofitTool;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RetrofitActivity extends AppCompatActivity {

    private MovieService mMovieService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        mMovieService= RetrofitTool.getInstance().
                mRetrofit
                .create(MovieService.class);

        mMovieService.getTopMovieR(0,10).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MovieBean>() {
                    @Override
                    public void onCompleted() {
                        Log.d("RetrofitActivity", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("RetrofitActivity", e.toString());
                    }

                    @Override
                    public void onNext(MovieBean movieBean) {
                        Log.d("RetrofitActivity", movieBean.getTitle());
                    }
                });

    }
}
