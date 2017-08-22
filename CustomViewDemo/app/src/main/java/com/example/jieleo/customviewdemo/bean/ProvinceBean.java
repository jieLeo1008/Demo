package com.example.jieleo.customviewdemo.bean;


import com.mic.adressselectorlib.CityInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YongJie on 2017/7/19.
 */

public class ProvinceBean {

    /**
     * code : 200
     * message : 成功
     * data : [{"area_id":84,"area_name":"太原市"},{"area_id":85,"area_name":"大同市"},{"area_id":86,"area_name":"阳泉市"},{"area_id":87,"area_name":"长治市"},{"area_id":88,"area_name":"晋城市"},{"area_id":89,"area_name":"朔州市"},{"area_id":90,"area_name":"晋中市"},{"area_id":91,"area_name":"运城市"},{"area_id":92,"area_name":"忻州市"},{"area_id":93,"area_name":"临汾市"},{"area_id":94,"area_name":"吕梁市"}]
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

    public ProvinceBean setData(ArrayList<DataBean> data) {
        this.data = data;
        return this;
    }

    public static class DataBean implements CityInterface {
        /**
         * area_id : 84
         * area_name : 太原市
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
