package com.example.androidmvc.practice.test_activity.presenter;

import com.example.androidmvc.practice.base.presenter.BaseMultiPartMvpPresenter;
import com.example.androidmvc.practice.test_activity.view.ITestMvpActivityView;

/**
 * MVP公共Presenter
 */
public class TestMvpActivityPresenter extends BaseMultiPartMvpPresenter<ITestMvpActivityView> {

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
