package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuyongjie on 17/3/20.
 */


public class Company implements Subject {
    //所有订阅了报纸的人都在这个集合里
    private List<Observer> mList;

    private String data;


    public void setData(String data) {
        this.data = data;
        myNotify();
    }


    public Company() {
        mList=new ArrayList<>();
    }

    @Override
    public void regester(Observer observer) {
            mList.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        //indexOf   从集合中找到某个集合的位置
        int index = mList.indexOf(observer);
        if (index > 0) {
            //移除对应位置的对象
            mList.remove(index);
        }
    }

    @Override
    public void myNotify() {
        //遍历整个集合告诉每一个观察者都要更新数据了
        for (int i = 0; i < mList.size(); i++) {
            mList.get(i).Updata(data);
        }
    }
}
