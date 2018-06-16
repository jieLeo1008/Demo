package com.baobao.lib;

/**
 * Created by Benny on 2018/4/6.
 */
public class BlackManFactory implements ManFactory {
    @Override
    public GoodMan getGoodMan() {
        return new Person();
    }

    @Override
    public BadMan getBadMan() {
        return new WolfMan();
    }
}
