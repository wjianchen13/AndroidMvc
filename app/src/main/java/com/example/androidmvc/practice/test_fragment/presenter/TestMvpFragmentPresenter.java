package com.example.androidmvc.practice.test_fragment.presenter;

import com.example.androidmvc.practice.base.presenter.BaseFragmentMvpPresenter;
import com.example.androidmvc.practice.test_fragment.view.ITestMvpFragmentView;

public class TestMvpFragmentPresenter extends BaseFragmentMvpPresenter<ITestMvpFragmentView> {

    public TestMvpFragmentPresenter(ITestMvpFragmentView view) {
        super(view);
    }

    public String getTestString() {
        return "TestMvpPresenter";
    }

    public void onTip() {
        getView().test();
    }

}