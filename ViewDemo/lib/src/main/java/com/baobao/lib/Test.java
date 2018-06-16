package com.baobao.lib;

/**
 * Created by Benny on 2018/4/6.
 */
public class Test {

    public static void main(String... args){
        ManFactory manFactory =new WhiteManFactoty();
        BadMan badMan =manFactory.getBadMan();
        badMan.makeBadMan();
    }
}
