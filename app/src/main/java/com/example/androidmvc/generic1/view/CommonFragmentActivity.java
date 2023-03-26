package com.example.androidmvc.generic1.view;

import android.os.Bundle;

import com.example.androidmvc.generic1.ITestMvpView;
import com.example.androidmvc.generic1.manager.ModelManager;
import com.example.androidmvc.generic1.presenter.CommonMvpPresenter;

/**
 * 测试项目中显示fragment的情况
 * 模拟需要知道数据类型
 */
public class CommonFragmentActivity<D, V extends ITestMvpView, P extends CommonMvpPresenter<D, V>>  extends BaseFragmentActivity<V, P> {

    private ModelManager<D> modelManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}