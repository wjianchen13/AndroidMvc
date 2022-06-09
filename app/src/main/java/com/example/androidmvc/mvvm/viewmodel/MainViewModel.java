package com.example.androidmvc.mvvm.viewmodel;

import android.content.Context;

import com.example.androidmvc.mvvm.model.User;


/**
 * Created by liang on 2016/8/23.
 */
public class MainViewModel {
    private Context context;
    private User user;

    public MainViewModel(Context context, User user) {
        this.context = context;
        this.user = user;
    }

    public String getUsername(){
        return user.username;
    }
    public String getPassword(){
        return user.password;
    }
}