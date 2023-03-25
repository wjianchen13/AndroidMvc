package com.example.androidmvc.llistView.view;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidmvc.R;
import com.example.androidmvc.common.view.BaseMvpActivity;
import com.example.androidmvc.llistView.adapter.BaseAdapter;
import com.example.androidmvc.llistView.bean.TestBean;
import com.example.androidmvc.llistView.presenter.ListPresenter;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import java.util.List;

/**
 * 列表显示数据
 */
public class ListActivity extends BaseMvpActivity<ListPresenter> implements IListView {

    private SmartRefreshLayout mSmartLayout;
    private ClassicsHeader mHeader;
    private RecyclerView mRecyclerView;
    private ClassicsFooter mFooter;

    private BaseAdapter mAdapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mSmartLayout = findViewById(R.id.refreshLayout);
        mHeader = findViewById(R.id.header);
        mRecyclerView = findViewById(R.id.rv_refresh);
        mFooter = findViewById(R.id.footer);
        init();
    }

    @Override
    protected ListPresenter createPresenter() {
        return new ListPresenter(this);
    }

    private void init() {
        mSmartLayout.setEnableLoadMore(false);
        mSmartLayout.setEnableRefresh(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.addItemDecoration(new ListAdapter.GameRankSpace(getActivityExp()));
        mRecyclerView.setAdapter(mAdapter = new BaseAdapter(getPresenter().getDatas()));
        getPresenter().getData();
    }

    @Override
    public void onGetData(List<TestBean> bean) {
        mAdapter.notifyDataSetChanged();
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
}