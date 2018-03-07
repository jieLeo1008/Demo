package com.benny.viewdemo.model;

/**
 * Created by Benny on 2018/3/6.
 */

public class ZakerModel {

    private String name;

    private String img;

    public ZakerModel(String name, String img) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
