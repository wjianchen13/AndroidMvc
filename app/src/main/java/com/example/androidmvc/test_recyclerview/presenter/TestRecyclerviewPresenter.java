package com.example.androidmvc.test_recyclerview.presenter;

import androidx.annotation.NonNull;

import com.example.androidmvc.baserecyclerview.RecyclerViewModleAssist;
import com.example.androidmvc.baserecyclerview.presenter.BaseRecyclerViewPresenter;
import com.example.androidmvc.llistView.bean.TestBean;
import com.example.androidmvc.test_recyclerview.bean.RecyclerViewBean;
import com.example.androidmvc.test_recyclerview.bean.RecyclerViewResultBean;
import com.example.androidmvc.test_recyclerview.view.ITestRecyclerviewView;

import java.util.ArrayList;
import java.util.List;

public class TestRecyclerviewPresenter extends BaseRecyclerViewPresenter<RecyclerViewBean, ITestRecyclerviewView> {

    public TestRecyclerviewPresenter(ITestRecyclerviewView mMvpView) {
        super(mMvpView);
    }

    @Override
    protected void asynLoadData(boolean isRefresh, @NonNull RecyclerViewModleAssist.Condition.Builder builder) {
        builder.pageKey("page_index");

        _asynLoadData(isRefresh, "test", builder.build(), new RecyclerViewModleAssist.OnAsynLoadDataListener<RecyclerViewResultBean>() {
            @Override
            public boolean onData(boolean isRefresh, RecyclerViewResultBean bean) { // bean是为空的，因为上层没有模拟传下来

                getDatas().addAll(getData());


                return super.onData(isRefresh, bean);
            }

        });
    }


    public List<RecyclerViewBean> getData() {
        List<RecyclerViewBean> datas = new ArrayList<>();
        for(int i = 0; i < 10; i ++) {
            RecyclerViewBean bean = new RecyclerViewBean("test: " + i);
            datas.add(bean);
        }
        return datas;
    }


}
