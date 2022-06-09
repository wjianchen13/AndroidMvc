package com.example.androidmvc.mvc.model;

/**
 * Created by liang on 2016/8/22.
 */
public interface OnLoginListener {
    void loginSuccess(User user);
    void loginFailed();
}