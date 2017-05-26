package com.example.jieleo.customviewdemo.tool;

/**
 * Created by OldFour on 2017/5/22.
 */

public interface NetInter {
    <T> void getDataFromUrl(String url,Class<T> tClass,CallBack<T> callBack);
}
