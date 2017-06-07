package com.example.yongjie.eventbusdemo.login;

/**
 * Created by yongjie on 2017/6/6.
 */

public interface LoginView {
    void  onSuccess();
    void  onFailed();
    void showPb();
    void hintPb();
}
