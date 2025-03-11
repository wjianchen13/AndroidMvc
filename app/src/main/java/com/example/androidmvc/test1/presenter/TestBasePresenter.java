package com.example.androidmvc.test1.presenter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.androidmvc.practice.base.view.IBaseMvpView;
import com.example.androidmvc.test1.view.ITestBaseView;
import com.example.androidmvc.test1.view.ITestView;
import com.example.androidmvc.utils.Utils;

/**
 * MVP公共Presenter
 */
public class TestBasePresenter<V extends ITestBaseView>  {

    private static final String TAG = TestBasePresenter.class.getSimpleName();

    protected V mView;

    public TestBasePresenter(V view) {
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

    public void onAttach(@NonNull Context context) {
        Utils.i(TAG, "onAttach");
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Utils.i(TAG, "onAttach");
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Utils.i(TAG, "onAttach");
    }

    public void onDestroyView() {
        Utils.i(TAG, "onAttach");
    }

    public void onDetach() {
        Utils.i(TAG, "onAttach");
    }

}
