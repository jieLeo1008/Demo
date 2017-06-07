package com.example.yongjie.eventbusdemo.login;

import android.os.Handler;

/**
 * Created by yongjie on 2017/6/6.
 */

public class LoginPresenter {

    private LoginModel mLoginModel;
    private LoginView mLoginView;
    private Handler mHandler = new Handler();

    public LoginPresenter(LoginView loginView) {
        mLoginView = loginView;
        mLoginModel = new LoginModel();
    }

    /**
     * @param name
     * @param password
     */
    public void makeLogin(String name, String password) {
        mLoginView.showPb();
        mLoginModel.doLogin(name, password, new LoginCallBack() {
            @Override
            public void onSuccess() {
                mHandler.post(new Runnable() {//需要切回主线程
                    @Override
                    public void run() {
                        mLoginView.onSuccess();
                        mLoginView.hintPb();
                    }
                });

            }

            @Override
            public void onFailed(int code) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mLoginView.onFailed();
                        mLoginView.hintPb();
                    }
                });
            }
        });
    }


}
