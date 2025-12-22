package com.example.androidmvc.test1.module;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.androidmvc.practice.base.LazyLoader;
import com.example.androidmvc.practice.base.module.Constants;
import com.example.androidmvc.practice.base.presenter.BaseMultiPartMvpPresenter;
import com.example.androidmvc.practice.base.view.IBaseMvpView;
import com.example.androidmvc.practice.base.view.IBaseTargetView;
import com.example.androidmvc.test1.presenter.TestBasePresenter;
import com.example.androidmvc.test1.view.ITargetView;

/**
 * 模块公共父类
 *
 */
public abstract class BaseModule<V extends ITargetView, P extends TestBasePresenter> extends LazyLoader implements IBaseMvpView, View.OnClickListener {

    protected Context mContext;
    protected V mTarget;
    protected P mPresenter;

    protected View mCurrentLayout;
    protected View mRootLayout;

    public BaseModule(View parent) {
        super();
        this.mRootLayout = parent;
    }

    public BaseModule(V target, P presenter, View parent) {
        this(parent);
        this.mTarget = target;
        this.mTarget.addModule(this);
        this.mPresenter = presenter;
    }

    @Override
    public void showToast(String str) {
        if(context() != null)
            Toast.makeText(context(), str, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void lazyInitView() {

    }

    public boolean isOnShowing() {
        if (mCurrentLayout == null)
            return false;
        return mCurrentLayout.getVisibility() == View.VISIBLE;
    }

    public Context getContext() {
        return null;
    }

    public Context getApplicationContext() {
        return null;
    }

    public void setVisible(@Constants.AnimEnum int animEnum) {
        if (animEnum == Constants.MODULE_VISIABLE)
            init();
        if (!isLazyInit() && animEnum == Constants.MODULE_IN_VISIABLE)
            return;

        if (mRootLayout != null)
            mRootLayout.clearAnimation();

        switch (animEnum) {
            case Constants.MODULE_VISIABLE:       // 显示

                break;
            case Constants.MODULE_IN_VISIABLE:    // 隐藏

                break;
        }
    }

    /**********************************************************************************************
     * Activity生命周期
     **********************************************************************************************/
    public void onCreate(Bundle savedInstanceState) {

    }

    public void onStart() {
    }

    public void onRestart() {
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onStop() {
    }

    public void onDestroy() {
    }

    /**********************************************************************************************
     * Fragment 生命周期
     **********************************************************************************************/
    public void onAttach(@NonNull Context context) {

    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }

    public void onDestroyView() {

    }

    public void onDetach() {

    }

    @Override
    public void onClick(View v) {

    }

    private Context context() {
        return mContext;
    }
}
