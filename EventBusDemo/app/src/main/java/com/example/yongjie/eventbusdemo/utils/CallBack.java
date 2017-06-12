package com.example.yongjie.eventbusdemo.utils;

/**
 * Created by OldFour on 2017/6/7.
 */

public interface CallBack<T> {
    void onSuccess(T response);
    void onFail(Throwable throwable);
}
