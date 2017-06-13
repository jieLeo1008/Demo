package com.example.jieleo.myrxjavademo;

import java.util.List;

/**
 * Created by OldFour on 2017/6/8.
 */

public class TestBean {
    private String name;
    private int price;
    private List<House> mList;

    public TestBean(String name, int price, List<House> list) {
        this.name = name;
        this.price = price;
        mList = list;
    }

    public String getName() {
        return name;
    }

    public TestBean setName(String name) {
        this.name = name;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public TestBean setPrice(int price) {
        this.price = price;
        return this;
    }

    public List<House> getList() {
        return mList;
    }

    public TestBean setList(List<House> list) {
        mList = list;
        return this;
    }

     public static class House{
        private String name;
        private int price;

        public House(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public House setName(String name) {
            this.name = name;
            return this;
        }

        public int getPrice() {
            return price;
        }

        public House setPrice(int price) {
            this.price = price;
            return this;
        }
    }
}
