package com.example.yongjie.eventbusdemo.coon;

import com.example.yongjie.eventbusdemo.utils.CallBack;
import com.example.yongjie.eventbusdemo.utils.NetTool;

/**
 * Created by OldFour on 2017/6/7.
 */

public class ConnModel implements IConnModel {


    @Override
    public void getConnBean(String url, final ConnModelListener callBack) {
        NetTool.getInstance().startRequest(url, ConnBean.class, new CallBack<ConnBean>() {
            @Override
            public void onSuccess(ConnBean response) {
                callBack.onSuccess(response);
            }

            @Override
            public void onFail(Throwable throwable) {
                callBack.onFail(throwable);
            }
        });
    }
}
