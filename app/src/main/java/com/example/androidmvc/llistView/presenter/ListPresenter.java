package com.example.androidmvc.llistView.presenter;

import com.example.androidmvc.common.presenter.BaseMvpPresenter;
import com.example.androidmvc.llistView.bean.TestBean;
import com.example.androidmvc.llistView.view.IListView;

import java.util.ArrayList;
import java.util.List;

public class ListPresenter extends BaseMvpPresenter<IListView> {

    public List<TestBean> mDatas;

    public ListPresenter(IListView mMvpView) {
        super(mMvpView);
        mDatas = new ArrayList<>();
    }

    public void getData() {
        for(int i = 0; i < 10; i ++) {
            TestBean bean = new TestBean("test: " + i);
            mDatas.add(bean);
        }
        getView().onGetData(mDatas);
    }

    public List<TestBean> getDatas() {
        return mDatas;
    }
}
