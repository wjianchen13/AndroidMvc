package com.example.androidmvc.practice.test_multi_fragment.presenter;

import com.example.androidmvc.practice.base.presenter.BaseFragmentMvpPresenter;
import com.example.androidmvc.practice.test_multi_fragment.view.IPart1View;
import com.example.androidmvc.practice.test_multi_fragment.view.IPart2View;

public class Part2Presenter extends BaseFragmentMvpPresenter<IPart2View> {

    public Part2Presenter(IPart2View view) {
        super(view);
    }

    public String getTestString() {
        return "TestMvpPresenter";
    }

    public void getPart2Text() {
        getView().onGetText2("part2");
    }

}