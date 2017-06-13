package com.example.yongjie.eventbusdemo.coon;

/**
 * Created by OldFour on 2017/6/7.
 */

public interface ConnView {
    void getConnDataSuccess(ConnBean  connBean);
    void getConnDataFail(Throwable throwable);

    void progressShow();
    void progressDismiss();
}
