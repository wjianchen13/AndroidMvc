package com.example.androidmvc.generic1.presenter;

import com.example.androidmvc.generic1.manager.ModelManager;
import com.example.androidmvc.generic1.view.ICommonMvpView;

/**
 * 模拟需要知道数据类型
 */
public abstract class CommonMvpPresenter<D, V extends ICommonMvpView> extends BaseMvpPresenter<V>{

    private ModelManager<D> modelManager;

}
