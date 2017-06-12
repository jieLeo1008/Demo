package com.example.yongjie.eventbusdemo.coon;

/**
 * Created by OldFour on 2017/6/7.
 */

public class ConnPresenter {

    private IConnModel mConnModel;

    private ConnView mConnView;

    public ConnPresenter(ConnView connView) {
        mConnView = connView;
        mConnModel = new ConnModel();
    }


    public void getConnData(String url) {
        mConnView.progressShow();
        mConnModel.getConnBean(url, new ConnModelListener() {
            @Override
            public void onSuccess(ConnBean connBean) {
                mConnView.getConnDataSuccess(connBean);
                mConnView.progressDismiss();
            }

            @Override
            public void onFail(Throwable throwable) {
                mConnView.getConnDataFail(throwable);
            }
        });
    }
}
