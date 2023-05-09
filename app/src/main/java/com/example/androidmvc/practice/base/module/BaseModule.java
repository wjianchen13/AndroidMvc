package com.example.androidmvc.practice.base.module;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.androidmvc.practice.base.LazyLoader;
import com.example.androidmvc.practice.base.view.BaseMultiPartMvpFragment;
import com.example.androidmvc.practice.base.view.IBaseMvpView;

/**
 * 模块公共父类
 */
public abstract class BaseModule extends LazyLoader implements IBaseMvpView, View.OnClickListener {

    protected Context mContext;
    protected BaseMultiPartMvpFragment mFragment;

    protected View mCurrentLayout;
    protected View mRootLayout;

    public BaseModule(View parent) {
        super();
        this.mRootLayout = parent;
    }

    public BaseModule(BaseMultiPartMvpFragment fragment, View parent) {
        this(parent);
        this.mFragment = fragment;
        mFragment.addModule(this);
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
