package com.example.androidmvc.practice.base.presenter;

import android.os.Bundle;

import com.example.androidmvc.practice.base.view.IBaseMvpView;
import com.example.androidmvc.utils.Utils;

/**
 * MVP公共Presenter
 */
public class BaseActivityMvpPresenter<V extends IBaseMvpView> extends BaseMvpPresenter<V> {

    private static final String TAG = BaseActivityMvpPresenter.class.getSimpleName();

    public BaseActivityMvpPresenter(V view) {
        super(view);
    }

    public void onCreate(Bundle savedInstanceState) {
        Utils.i(TAG, "onCreate");
    }

    public void onStart() {
        Utils.i(TAG, "onStart");
    }

    public void onRestart() {
        Utils.i(TAG, "onRestart");
    }

    public void onPostResume() {
        Utils.i(TAG, "onPostResume");
    }

    public void onResume() {
        Utils.i(TAG, "onResume");
    }

    public void onPause() {
        Utils.i(TAG, "onPause");
    }

    public void onStop() {
        Utils.i(TAG, "onStop");
    }

    public void onDestroy() {
        Utils.i(TAG, "onDestroy");
    }

}
