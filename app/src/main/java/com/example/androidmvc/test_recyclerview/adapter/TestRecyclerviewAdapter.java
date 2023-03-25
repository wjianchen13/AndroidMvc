package com.example.androidmvc.test_recyclerview.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.androidmvc.R;
import com.example.androidmvc.test_recyclerview.bean.RecyclerViewBean;

import java.util.List;

/**
 * 首页我的
 */
public class TestRecyclerviewAdapter extends BaseQuickAdapter<RecyclerViewBean, BaseViewHolder> {

    public TestRecyclerviewAdapter(List<RecyclerViewBean> data) {
        super(R.layout.item_list_test, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, RecyclerViewBean item) {
        if (item != null) {
            holder.setText(R.id.tv_test, item.getName());
        }
    }
}
