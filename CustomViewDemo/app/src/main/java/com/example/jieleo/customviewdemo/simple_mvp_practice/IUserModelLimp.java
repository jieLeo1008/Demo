package com.example.jieleo.customviewdemo.simple_mvp_practice;

import android.util.Log;
import android.util.SparseArray;

/**
 * Created by OldFour on 2017/6/5.
 */

public class IUserModelLimp implements IUserModel {

    private String username;
    private String userpwd;
    private int sidy;
    private SparseArray mSparseArray=new SparseArray();

    @Override
    public void setSid(int cid) {
        sidy=cid;
    }

    @Override
    public UserBean load(int sid) {
        sidy=sid;
        UserBean ub= (UserBean) mSparseArray.get(sid,new UserBean("Not Found","Not Found"));

        return ub;
    }

    @Override
    public void setUserName(String userName) {

        username=userName;
    }

    @Override
    public void setUserPwd(String userPwd) {
        userpwd=userPwd;
        UserBean userBean=new UserBean(username,userpwd);
        Log.d("IUserModelLimp", "____userName" + username + "_______userPwd" + userPwd + "___________sid" + sidy);
        mSparseArray.append(sidy,userBean);
    }
}
