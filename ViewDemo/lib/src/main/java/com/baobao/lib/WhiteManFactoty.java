package com.baobao.lib;

/**
 * Created by Benny on 2018/4/6.
 */
public class WhiteManFactoty implements ManFactory {

    @Override
    public GoodMan getGoodMan() {
        return new WhiteChi();
    }

    @Override
    public BadMan getBadMan() {
        return new WhiteWolf();
    }
}
