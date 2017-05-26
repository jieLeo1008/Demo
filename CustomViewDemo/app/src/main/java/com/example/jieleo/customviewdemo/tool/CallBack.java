package com.example.jieleo.customviewdemo.tool;

/**
 * Created by OldFour on 2017/5/22.
 */

public interface CallBack<T> {
    void onSuccess(T response);
    void onError(Throwable throwable);
}
