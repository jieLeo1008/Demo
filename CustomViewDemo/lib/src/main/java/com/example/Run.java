package com.example;

import java.lang.reflect.Field;

/**
 * Created by OldFour on 2017/6/5.
 */

public class Run {
    public static void main(String[] args){
        Class cache = Integer.class.getDeclaredClasses()[0];
        Field myCache = null;
        try {
            myCache = cache.getDeclaredField("cache");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        myCache.setAccessible(true);

        Integer[] newCache = new Integer[0];
        try {
            newCache = (Integer[]) myCache.get(cache);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        newCache[132] = newCache[133];

        int a = 2;
        int b = a + a;
        System.out.printf("%d + %d = %d", a, a, b);
    }
}
