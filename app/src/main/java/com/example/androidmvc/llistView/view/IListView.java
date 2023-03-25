package com.example.androidmvc.llistView.view;

import com.example.androidmvc.common.view.IBaseMvpView;
import com.example.androidmvc.llistView.bean.TestBean;

import java.util.List;

/**
 * 列表接口
 */
public interface IListView extends IBaseMvpView {

    void onGetData(List<TestBean> beans);
}
