package com.example.androidmvc.practice.base.presenter;

import android.content.Context;

import com.example.androidmvc.practice.base.view.IBaseMvpView;

/**
 * MVP公共Presenter
 */
public class BaseMvpPresenter<V extends IBaseMvpView>  {

    protected V mView;

    public BaseMvpPresenter(V view) {
        this.mView = view;
    }

    public void showToast(String str) {
        if(mView != null)
            mView.showToast(str);
    }

    public Context getContext() {
        return mView != null ? mView.getContext() : null;
    }

    public V getView() {
        return mView;
    }

    public void onStart() {

    }

    public void onRestart() {

    }

    public void onPostResume() {

    }

    public void onResume() {

    }

    public void onPause() {

    }

    public void onStop() {

    }

    public void onDestroy() {

    }

}
