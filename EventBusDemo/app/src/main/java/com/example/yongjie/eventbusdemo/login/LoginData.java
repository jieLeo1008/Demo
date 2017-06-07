package com.example.yongjie.eventbusdemo.login;

/**
 * Created by yongjie on 2017/6/6.
 */

public interface LoginData {
    void doLogin(String name,String password,LoginCallBack callBack);
}
