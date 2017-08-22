package com.jieleo.haichangnoticedemo;

/**
 * Created by YongJie on 2017/8/11.
 */

public class Bean {

    private String title;
    private String url;

    public Bean(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public Bean setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Bean setUrl(String url) {
        this.url = url;
        return this;
    }
}
