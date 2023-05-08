package com.example.androidmvc.practice.test_activity.presenter;

import com.example.androidmvc.practice.base.presenter.BaseActivityMvpPresenter;
import com.example.androidmvc.practice.test_activity.view.ITestMvpActivityView;

/**
 * MVP公共Presenter
 */
public class TestMvpActivityPresenter extends BaseActivityMvpPresenter<ITestMvpActivityView> {

    public TestMvpActivityPresenter(ITestMvpActivityView view) {
        super(view);
    }

    public String getTestString() {
        return "TestMvpPresenter";
    }

    public void onTip() {
        getView().test();
    }

}
