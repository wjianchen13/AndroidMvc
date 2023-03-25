package com.example.androidmvc.test_recyclerview.view;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.androidmvc.R;
import com.example.androidmvc.baserecyclerview.view.BaseMVVMRecyclerViewActivity;
import com.example.androidmvc.llistView.bean.TestBean;
import com.example.androidmvc.test_recyclerview.adapter.TestRecyclerviewAdapter;
import com.example.androidmvc.test_recyclerview.bean.RecyclerViewBean;
import com.example.androidmvc.test_recyclerview.bean.RecyclerViewResultBean;
import com.example.androidmvc.test_recyclerview.presenter.TestRecyclerviewPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * 列表显示数据
 */
public class TestRecyclerviewActivity extends BaseMVVMRecyclerViewActivity<RecyclerViewBean, TestRecyclerviewPresenter>
        implements ITestRecyclerviewView {

    private TestRecyclerviewAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
    }

    @Override
    protected void initContentView() {
        super.initContentView();
        setContentView(R.layout.activity_list);
    }

    @Override
    protected TestRecyclerviewPresenter createPresenter() {
        return new TestRecyclerviewPresenter(this);
    }

    private void init() {
        getRecyclerView().setLayoutManager(setBaseLayoutManager(new LinearLayoutManager(this)));
        mAdapter = new TestRecyclerviewAdapter(getDatas());
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

            }
        });
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
        getRecyclerView().setAdapter(setBaseAdapter(mAdapter));
        getSmartRefreshLayout().setEnableLoadMore(true);
        getSmartRefreshLayout().setEnableRefresh(true);
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_activity) {

        } else if(view.getId() == R.id.btn_fragment) {

        }
    }

    @Override
    public boolean refresh() {
        return false;
    }

    @Override
    public boolean requireLogin() {
        return false;
    }

    @Override
    public void onLoadDataFinish(boolean isRefresh, List datas, boolean dataChanged, int pageCount) {
        super.onLoadDataFinish(isRefresh, datas, dataChanged, pageCount);
    }

    @Override
    public boolean isLoadmoreEnable() {
        return false;
    }

    @Override
    public boolean isRefreshEnable() {
        return false;
    }

}