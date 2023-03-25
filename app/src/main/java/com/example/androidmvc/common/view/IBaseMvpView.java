package com.example.androidmvc.common.view;

import android.app.Activity;

import com.example.androidmvc.common.presenter.BaseMvpPresenter;

/**
 * 公共接口
 */
public interface IBaseMvpView {

    public BaseMvpPresenter getPresenter();

    Activity getActivity();

    boolean refresh();
}
