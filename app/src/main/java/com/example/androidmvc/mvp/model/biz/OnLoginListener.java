package com.example.androidmvc.mvp.model.biz;

import com.example.androidmvc.mvp.model.bean.User;

public interface OnLoginListener {
    void loginSuccess(User user);
    void loginFailed();
}