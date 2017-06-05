package com.example.jieleo.customviewdemo.simple_mvp_practice;

/**
 * Created by OldFour on 2017/6/5.
 */

public class UserPresenter {
    private IUserModel mIUserModel;
    private IUserView mIUserView;

    public UserPresenter(IUserView IUserView) {
        mIUserView = IUserView;
        mIUserModel =new IUserModelLimp();
    }

    public void saveuser(int sid,String userName,String userPwd){
        mIUserModel.setSid(sid);
        mIUserModel.setUserName(userName);
        mIUserModel.setUserPwd(userPwd);
    }

    public  void loadUser(int sid){
        UserBean userBean=mIUserModel.load(sid);
        mIUserView.setUserName(userBean.getUserName());
        mIUserView.setUserPwd(userBean.getUserPwd());
    }
}
