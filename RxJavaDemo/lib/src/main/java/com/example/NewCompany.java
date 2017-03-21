package com.example;

import java.util.Observable;

/**
 * Created by yuyongjie on 17/3/20.
 */


public class NewCompany extends Observable{
    private String data;


    public void setData(String data) {
        this.data = data;
        setChanged();
        notifyObservers();
    }


    public String getData() {
        return data;
    }
}
