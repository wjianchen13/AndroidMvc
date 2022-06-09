package com.example.androidmvc.mvp.presenter;

import android.os.Handler;

import com.example.androidmvc.mvp.model.bean.User;
import com.example.androidmvc.mvp.model.biz.IUserBiz;
import com.example.androidmvc.mvp.model.biz.OnLoginListener;
import com.example.androidmvc.mvp.model.biz.UserBiz;
import com.example.androidmvc.mvp.view.IUserLoginView;

public class UserLoginPresenter {
    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;

        //给userBiz一个子类的空间，此时方法已经被重写,登陆逻辑已被判断
        this.userBiz = new UserBiz();
    }

    public void login() {
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });

            }

            @Override
            public void loginFailed() {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });

            }
        });
    }

    public void clear() {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }


}