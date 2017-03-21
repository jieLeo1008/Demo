package com.jieleo.rxjavaplusretrofit;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by yuyongjie on 17/3/21.
 */


public interface MyService {
    @GET
//    Call<Bean> getData(@Url String url);
    Observable<Bean>  getData(@Url String url);


    //post请求
    @FormUrlEncoded()
    @POST("jnwtv-client/movie/getmoviedetail")
    Observable<NewBean> getNewData(@FieldMap Map<String,String> map);


    @Headers("apikey : 51d179c994a4cb85e156e89ffb6cc0f4")
    @GET("xiaogg/citylocation/citylocation")
    Observable<MapBean>  getMapData(@Query("city") String city);
}
