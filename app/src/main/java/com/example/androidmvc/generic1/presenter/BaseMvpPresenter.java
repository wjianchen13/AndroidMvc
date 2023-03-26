package com.example.androidmvc.generic1.presenter;

import com.example.androidmvc.generic1.view.IBaseMvpView;

/**
 * <p>MVP模式Present 基类 ,跟Activity，Fragment等生命周期绑定</p>
 *
 * @author jiahui
 * @date 2017/12/7
 */
public abstract class BaseMvpPresenter<V extends IBaseMvpView> {

    protected V mMvpView;

    /**
     * 绑定View
     */
    public void attachMvpView(V mvpView) {
        this.mMvpView = mvpView;
//        Log.e(TAG, "Presenter attachMvpView...");
    }

    /**
     * 解除绑定的View
     */
    public void detachMvpView() {
        mMvpView = null;
//        Log.e(TAG, "Presenter detachMvpView...");
    }

    public V getMvpView() {
        return mMvpView;
    }

}
