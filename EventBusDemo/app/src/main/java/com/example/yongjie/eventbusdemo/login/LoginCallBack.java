package com.example.yongjie.eventbusdemo.login;

/**
 * Created by yongjie on 2017/6/6.
 */

public interface LoginCallBack {
    void onSuccess();
    void onFailed(int code);
}
