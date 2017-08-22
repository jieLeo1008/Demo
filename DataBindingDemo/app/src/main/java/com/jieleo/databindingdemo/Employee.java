package com.jieleo.databindingdemo;

/**
 * Created by YongJie on 2017/8/12.
 */

public class Employee {

    public String first_name;

   public   String last_name;

    public Employee(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public Employee setFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public String getLast_name() {
        return last_name;
    }

    public Employee setLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }
}
