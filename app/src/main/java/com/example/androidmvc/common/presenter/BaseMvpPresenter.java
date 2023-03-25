package com.example.androidmvc.common.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.CallSuper;

import com.example.androidmvc.common.view.IBaseMvpView;

/**
 * <p>MVP模式Present 基类 ,跟Activity，Fragment等生命周期绑定</p>
 *
 * @author jiahui
 * @date 2017/12/7
 */
public abstract class BaseMvpPresenter<V extends IBaseMvpView>  {

    protected V mMvpView;

    public BaseMvpPresenter(V mMvpView) {
        this.mMvpView = mMvpView;
    }


    @CallSuper
    public boolean queueIdle(Bundle savedInstanceState, Intent intent, LayoutInflater inflater) {
        return false;
    }

    /**
     * 获取V层的接口View
     *
     * @return 当前的接口View
     */
    public V getView() {
        return mMvpView;
    }

    /**
     * 在Presenter被意外销毁时调用，它的调用时机和Activity，Fragment，View中的onSaveInstanceState()方法调用时机相同
     *
     * @param outState 保存消息的Bundle
     */
    public void onSaveInstanceState(Bundle outState) {
//        Log.e(TAG, "Presenter onSaveInstanceState...");
    }


}
