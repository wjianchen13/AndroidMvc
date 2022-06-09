package com.example.androidmvc.mvp.view;

import com.example.androidmvc.mvp.model.bean.User;

/**
 * Created by liang on 2016/8/22.
 */
public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}