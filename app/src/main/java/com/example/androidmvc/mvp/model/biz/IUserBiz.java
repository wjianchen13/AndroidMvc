package com.example.androidmvc.mvp.model.biz;


/**
 * Created by liang on 2016/8/22.
 */
public interface IUserBiz{
    public void login(String username,String password, OnLoginListener onLoginListener);
}