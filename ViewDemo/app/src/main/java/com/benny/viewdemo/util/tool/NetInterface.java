package com.benny.viewdemo.util.tool;

/**
 * Created by liuHao on 17/2/10.
 */
public interface NetInterface {

    void startRequest(String url, CallBack<String> callBack);
    <T> void startRequest(String url, Class<T> tClass, CallBack<T> callBack);
    <T>void startRequest(String url, Class<T> tClass, CallBackNew callBack);




}
