package com.example.yongjie.eventbusdemo.login;

/**
 * Created by yongjie on 2017/6/6.
 */

public class LoginModel implements LoginData{

    @Override
    public void doLogin(final String name, final String password, final LoginCallBack callBack) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000); if (name.equals("admin")&&password.equals("admin")){
                        callBack.onSuccess();
                    }else {
                        callBack.onFailed(1);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
