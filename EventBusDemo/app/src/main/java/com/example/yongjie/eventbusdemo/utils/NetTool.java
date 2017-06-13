package com.example.yongjie.eventbusdemo.utils;

/**
 * Created by OldFour on 2017/6/7.
 */

public class NetTool implements NetInter{
    private static NetTool ourInstance ;

    private NetInter mNetInter;

    public static NetTool getInstance() {
        if (ourInstance==null){
            synchronized (NetTool.class){
                if (ourInstance==null){
                    ourInstance=new NetTool();
                }
            }
        }
        return ourInstance;
    }

    private NetTool() {
        mNetInter=new OkTool();
    }


    @Override
    public <T> void startRequest(String url, Class<T> tClass, CallBack<T> callBack) {
        mNetInter.startRequest(url,tClass,callBack);
    }
}
