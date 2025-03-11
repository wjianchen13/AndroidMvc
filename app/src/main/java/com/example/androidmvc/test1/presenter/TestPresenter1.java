package com.example.androidmvc.test1.presenter;

import com.example.androidmvc.practice.base.presenter.BaseMultiPartMvpPresenter;
import com.example.androidmvc.practice.test_multi_fragment.view.IPart1View;
import com.example.androidmvc.test1.view.ITestView1;

public class TestPresenter1 extends TestBasePresenter<ITestView1> {

    public TestPresenter1(ITestView1 view) {
        super(view);
    }

    public String getTestString() {
        return "TestMvpPresenter";
    }

    public void getPart1Text() {
        getView().onGetText("part1");
    }

}