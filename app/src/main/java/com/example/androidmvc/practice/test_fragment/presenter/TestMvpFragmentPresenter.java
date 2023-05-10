package com.example.androidmvc.practice.test_fragment.presenter;

import com.example.androidmvc.practice.base.presenter.BaseMultiPartMvpPresenter;
import com.example.androidmvc.practice.test_fragment.view.ITestMvpFragmentView;

public class TestMvpFragmentPresenter extends BaseMultiPartMvpPresenter<ITestMvpFragmentView> {

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