package com.example.jieleo.customviewdemo.simple_mvp_practice;

/**
 * Created by OldFour on 2017/6/5.
 */

public interface IUserView {

    int getID();

    void setUserName(String userName);
    void setUserPwd(String userPwd);

    String getUserName();
    String getUserPwd();

}
