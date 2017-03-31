package com.jieleo.rxjavaplusretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private String baseUrl ="http://post.lexue.com/";
    private String url ="post/pub/post_list?page_size=10&page=1";

    private String newMapUrl ="http://apis.baidu.com/";


    String newBaseUrl = "http://appserver.jnwtv.com:8080/";

    String key1 = "account";
    String value1 = "26690576370";
    String key2 = "episodeNo";
    String value2 = "1";
    String key3 = "mId";
    String value3 = "1193";
    String key4 = "token";
    String value4 = "2016101715493688672507925614387226690576370";
    String key5 = "piId";
    String value5 = "10037";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OkHttpClient okHttpClient=new OkHttpClient.Builder().connectTimeout(5, TimeUnit.SECONDS).retryOnConnectionFailure(true).build();

        Retrofit retrofit=new Retrofit.Builder().baseUrl(newMapUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())//声明用Gson解析
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//声明用RxJava
                .build();
        //初始化接口对象
        MyService myService =retrofit.create(MyService.class);

//        Observable<Bean>  observable =myService.getData(url);
//        observable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Subscriber<Bean>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(Bean bean) {
//                for (Bean.PostsBean postsBean:bean.getPosts()) {
//                    Log.d("MainActivity", "postsBean.getAnonymous():" + postsBean.getText_content());
//                }
//            }
//        });


        /**
         * Post请求
         */
//        Map<String, String> map =new HashMap<>();
//        map.put(key1,value1);
//        map.put(key2,value2);
//        map.put(key3,value3);
//        map.put(key4,value4);
//        map.put(key5,value5);

    //动态申请权限
//        Observable<NewBean>   newBeanObservable=myService.getNewData(map);
//        newBeanObservable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Subscriber<NewBean>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(NewBean newBean) {
//                Log.d("MainActivity", "newBean.getMovieDetail():" + newBean.getMovieDetail().getCoverUrl());
//            }
//        });



        Observable<MapBean>  mapBeanObservable=myService.getMapData("大连");
        mapBeanObservable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Subscriber<MapBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MapBean mapBean) {
                Log.d("MainActivity","  经度："+ mapBean.getX() + " 纬度  " + mapBean.getY());
            }
        });


    }
}
