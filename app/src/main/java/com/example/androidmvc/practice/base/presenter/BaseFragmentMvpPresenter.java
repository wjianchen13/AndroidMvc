package com.example.androidmvc.practice.base.presenter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.androidmvc.practice.base.view.IBaseMvpView;
import com.example.androidmvc.utils.Utils;

import java.util.List;


/**
 * MVP公共Presenter
 */
public class BaseFragmentMvpPresenter<V extends IBaseMvpView> extends BaseMvpPresenter<V> {

    private static final String TAG = BaseFragmentMvpPresenter.class.getSimpleName();

    public BaseFragmentMvpPresenter(V view) {
        super(view);
    }

    public void onAttach(@NonNull Context context) {
        Utils.i(TAG, "onAttach");
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        Utils.i(TAG, "onAttach");
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Utils.i(TAG, "onAttach");
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Utils.i(TAG, "onAttach");
    }

    public void onStart() {
        Utils.i(TAG, "onAttach");
    }

    public void onResume() {
        Utils.i(TAG, "onAttach");
    }

    public void onPause() {
        Utils.i(TAG, "onAttach");
    }

    public void onStop() {
        Utils.i(TAG, "onAttach");
    }

    public void onDestroyView() {
        Utils.i(TAG, "onAttach");
    }

    public void onDestroy() {
        Utils.i(TAG, "onAttach");
    }

    public void onDetach() {
        Utils.i(TAG, "onAttach");
    }

}
