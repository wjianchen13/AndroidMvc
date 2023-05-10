package com.example.androidmvc.practice.base.presenter;

import com.example.androidmvc.practice.base.view.IBaseMvpView;

/**
 * MVP公共Presenter
 */
public class BaseMultiPartMvpPresenter<V extends IBaseMvpView> extends BaseMvpPresenter<V> {

    private static final String TAG = BaseMultiPartMvpPresenter.class.getSimpleName();

    public BaseMultiPartMvpPresenter(V view) {
        super(view);
    }

}
