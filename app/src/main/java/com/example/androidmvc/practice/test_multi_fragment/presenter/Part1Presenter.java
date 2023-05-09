package com.example.androidmvc.practice.test_multi_fragment.presenter;

import com.example.androidmvc.practice.base.presenter.BaseFragmentMvpPresenter;
import com.example.androidmvc.practice.test_multi_fragment.view.IPart1View;

public class Part1Presenter extends BaseFragmentMvpPresenter<IPart1View> {

    public Part1Presenter(IPart1View view) {
        super(view);
    }

    public String getTestString() {
        return "TestMvpPresenter";
    }

    public void getPart1Text() {
        getView().onGetText("part1");
    }

}