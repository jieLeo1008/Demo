package com.example.jieleo.baseviewholderdemo;

/**
 * Created by jie on 2017/2/12.
 */

public interface CallBack<T> {
    void onSuccess(T response);

    void  onError(Throwable e);

}
