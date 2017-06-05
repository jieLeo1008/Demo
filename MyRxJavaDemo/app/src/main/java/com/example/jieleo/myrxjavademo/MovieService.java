package com.example.jieleo.myrxjavademo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by OldFour on 2017/5/27.
 */

public interface MovieService {
    @GET("top250")
    Call<MovieBean>  getTopMovie(@Query("start") int start,@Query("count") int count);

    @GET("top250")
    Observable<MovieBean>  getTopMovieR(@Query("start") int start,@Query("count") int count);
}
