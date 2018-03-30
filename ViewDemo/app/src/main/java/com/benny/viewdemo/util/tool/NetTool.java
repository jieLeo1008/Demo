package com.benny.viewdemo.util.tool;


public class NetTool implements NetInterface{
    private static NetTool ourInstance ;
    private NetInterface mInterface;
    public static NetTool getInstance() {

        //双重校验锁单例模式
        if (ourInstance==null){
            synchronized (NetTool.class){
                if (ourInstance==null){
                    ourInstance = new NetTool();
                }
            }
        }
        return ourInstance;
    }

    private NetTool() {
        mInterface = new OKTool();
    }

    @Override
    public void startRequest(String url, CallBack<String> callBack) {
        mInterface.startRequest(url,callBack);
    }

    @Override
    public <T> void startRequest(String url, Class<T> tClass, CallBack<T> callBack) {
        mInterface.startRequest(url,tClass,callBack);
    }

    @Override
    public <T> void startRequest(String url, Class<T> tClass, CallBackNew callBack) {
        mInterface.startRequest(url, tClass, callBack);
    }

}
