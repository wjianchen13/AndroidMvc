package com.example.androidmvc.practice.test_activity.presenter;

import com.example.androidmvc.practice.base.presenter.BaseMvpPresenter;
import com.example.androidmvc.practice.test_activity.view.ITestMvpView;

/**
 * MVP公共Presenter
 */
public class TestMvpPresenter extends BaseMvpPresenter<ITestMvpView> {

    public TestMvpPresenter(ITestMvpView view) {
        super(view);
    }

    public String getTestString() {
        return "TestMvpPresenter";
    }

    public void onTip() {
        getView().test();
    }

}
