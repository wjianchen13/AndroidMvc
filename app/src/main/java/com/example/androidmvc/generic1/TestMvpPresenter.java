package com.example.androidmvc.generic1;

import com.example.androidmvc.generic1.presenter.CommonMvpPresenter;
import com.example.androidmvc.generic1.view.IBaseMvpView;

/**
 *
 */
public abstract class TestMvpPresenter<TestBean, V extends ITestMvpView> extends CommonMvpPresenter<TestBean, V> {



}
