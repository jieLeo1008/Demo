package com.example;

import java.util.Properties;

/**
 * Created by YongJie on 2017/8/24.
 */

public class MainCs {

    public static void main(String[] args){


        Properties properties =System.getProperties();

        System.setProperty("myKey","MyValue");

        String value=System.getProperty("os.name");

        System.out.println("value="+value);

        String v=System.getProperty("haha");

        System.out.println("v="+v);


        for (Object o : properties.keySet()) {
            String myValue= (String) properties.get(o);

            System.out.println(o+"::"+myValue);
        }
    }
}
