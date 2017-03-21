package com.example;

/**
 * Created by yuyongjie on 17/3/20.
 */


public class Person implements Observer,Behavior {
    private String data;

    public Person(Company company) {
        //初始化person的时候直接让他订阅报纸
        company.regester(this);
    }

    @Override
    public void read() {
            System.out.println(data);
    }

    @Override
    public void Updata(String data) {
        this.data=data;
        read();
    }
}
