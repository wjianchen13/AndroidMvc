package com.example.androidmvc.test1.presenter;

import com.example.androidmvc.practice.base.presenter.BaseMultiPartMvpPresenter;
import com.example.androidmvc.practice.test_multi_fragment.view.IPart3View;
import com.example.androidmvc.test1.view.ITestView3;

public class TestPresenter3 extends TestBasePresenter<ITestView3> {

    public TestPresenter3(ITestView3 view) {
        super(view);
    }

    public String getTestString() {
        return "TestMvpPresenter";
    }

    public void getPart3Text() {
        getView().onGetText3("part3");
    }

}