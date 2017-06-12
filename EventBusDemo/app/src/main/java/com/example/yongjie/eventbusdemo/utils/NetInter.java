package com.example.yongjie.eventbusdemo.utils;

/**
 * Created by OldFour on 2017/6/7.
 */

public interface NetInter {
    <T> void startRequest(String url,Class<T> tClass,CallBack<T> callBack);
}
