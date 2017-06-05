package com.example.jieleo.customviewdemo.simple_mvp_practice;

/**
 * Created by OldFour on 2017/6/5.
 */

public interface IUserModel {
    void setSid(int cid);
    UserBean load(int sid);
    void setUserName(String userName);
    void setUserPwd(String userPwd);
}
