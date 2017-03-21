package com.example;

/**
 * Created by yuyongjie on 17/3/20.
 */


public interface Subject {
    /**
     * 注册订阅的功能
     * @param observer   观察者
     */
    void regester(Observer observer);


    /**
     * 取消订阅的功能
     * @param observer  观察者
     */
    void  unregister(Observer observer);

    /**
     * 实时刷新的功能
     */
    void myNotify();
}
