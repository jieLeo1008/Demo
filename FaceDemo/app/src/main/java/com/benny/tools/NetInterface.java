package com.benny.tools;

/**
 * Created by liuHao on 17/2/10.
 */
public interface NetInterface {

    void startRequest(String url, CallBack<String> callBack);
    <T> void startRequest(String url, Class<T> tClass, CallBack<T> callBack);
    <T>void startRequest(String url, Class<T> tClass, CallBackNew<T> callBack);




}
