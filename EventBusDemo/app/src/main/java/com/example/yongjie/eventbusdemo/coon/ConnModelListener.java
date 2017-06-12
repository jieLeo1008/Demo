package com.example.yongjie.eventbusdemo.coon;

/**
 * Created by OldFour on 2017/6/7.
 */

public interface ConnModelListener<T> {
    void onSuccess(ConnBean  connBean);
    void onFail(Throwable throwable);
}
