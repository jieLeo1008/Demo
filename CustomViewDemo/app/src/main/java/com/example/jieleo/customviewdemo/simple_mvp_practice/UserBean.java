package com.example.jieleo.customviewdemo.simple_mvp_practice;

/**
 * Created by OldFour on 2017/6/5.
 */

public class UserBean {
    private String userName;
    private String userPwd;

    public UserBean() {
    }

    public UserBean(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public UserBean setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public UserBean setUserPwd(String userPwd) {
        this.userPwd = userPwd;
        return this;
    }
}
