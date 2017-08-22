package com.example.jieleo.customviewdemo.bean;


import com.mic.adressselectorlib.CityInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YongJie on 2017/7/19.
 */

public class CityBean {


    /**
     * code : 200
     * message : 成功
     * data : [{"area_id":1,"area_name":"北京"},{"area_id":2,"area_name":"天津"},{"area_id":3,"area_name":"河北省"},{"area_id":4,"area_name":"山西省"},{"area_id":5,"area_name":"内蒙古自治区"},{"area_id":6,"area_name":"辽宁省"},{"area_id":7,"area_name":"吉林省"},{"area_id":8,"area_name":"黑龙江省"},{"area_id":9,"area_name":"上海"},{"area_id":10,"area_name":"江苏省"},{"area_id":11,"area_name":"浙江省"},{"area_id":12,"area_name":"安徽省"},{"area_id":13,"area_name":"福建省"},{"area_id":14,"area_name":"江西省"},{"area_id":15,"area_name":"山东省"},{"area_id":16,"area_name":"河南省"},{"area_id":17,"area_name":"湖北省"},{"area_id":18,"area_name":"湖南省"},{"area_id":19,"area_name":"广东省"},{"area_id":20,"area_name":"广西壮族自治区"},{"area_id":21,"area_name":"海南省"},{"area_id":22,"area_name":"重庆"},{"area_id":23,"area_name":"四川省"},{"area_id":24,"area_name":"贵州省"},{"area_id":25,"area_name":"云南省"},{"area_id":26,"area_name":"西藏自治区"},{"area_id":27,"area_name":"陕西省"},{"area_id":28,"area_name":"甘肃省"},{"area_id":29,"area_name":"青海省"},{"area_id":30,"area_name":"宁夏回族自治区"},{"area_id":31,"area_name":"新疆维吾尔自治区"},{"area_id":32,"area_name":"台湾省"},{"area_id":33,"area_name":"香港特别行政区"},{"area_id":34,"area_name":"澳门特别行政区"},{"area_id":35,"area_name":"海外"}]
     */

    private int code;
    private String message;
    private ArrayList<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<DataBean> getData() {
        return data;
    }

    public CityBean setData(ArrayList<DataBean> data) {
        this.data = data;
        return this;
    }

    public static class DataBean implements CityInterface {
        /**
         * area_id : 1
         * area_name : 北京
         */

        private int area_id;
        private String area_name;

        public int getArea_id() {
            return area_id;
        }

        public void setArea_id(int area_id) {
            this.area_id = area_id;
        }

        public String getArea_name() {
            return area_name;
        }

        public void setArea_name(String area_name) {
            this.area_name = area_name;
        }

        @Override
        public String getCityName() {
            return area_name;
        }

        @Override
        public int getAreaId() {
            return area_id;
        }
    }
}
