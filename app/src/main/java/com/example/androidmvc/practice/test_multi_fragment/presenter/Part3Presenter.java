package com.example.androidmvc.practice.test_multi_fragment.presenter;

import com.example.androidmvc.practice.base.presenter.BaseFragmentMvpPresenter;
import com.example.androidmvc.practice.test_multi_fragment.view.IPart3View;

public class Part3Presenter extends BaseFragmentMvpPresenter<IPart3View> {

    public Part3Presenter(IPart3View view) {
        super(view);
    }

    public String getTestString() {
        return "TestMvpPresenter";
    }

    public void getPart3Text() {
        getView().onGetText3("part3");
    }

}