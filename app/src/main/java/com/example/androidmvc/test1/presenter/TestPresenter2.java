package com.example.androidmvc.test1.presenter;

import com.example.androidmvc.practice.base.presenter.BaseMultiPartMvpPresenter;
import com.example.androidmvc.practice.test_multi_fragment.view.IPart2View;
import com.example.androidmvc.test1.view.ITestView1;
import com.example.androidmvc.test1.view.ITestView2;

public class TestPresenter2 extends TestBasePresenter<ITestView2> {

    public TestPresenter2(ITestView2 view) {
        super(view);
    }

    public String getTestString() {
        return "TestMvpPresenter";
    }

    public void getPart2Text() {
        getView().onGetText2("part2");
    }

}