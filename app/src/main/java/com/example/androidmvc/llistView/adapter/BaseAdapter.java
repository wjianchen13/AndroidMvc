package com.example.androidmvc.llistView.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.androidmvc.R;
import com.example.androidmvc.llistView.bean.TestBean;

import java.util.List;

/**
 * 首页我的
 */
public class BaseAdapter extends BaseQuickAdapter<TestBean, BaseViewHolder> {

    public BaseAdapter() {
        super(R.layout.item_list_test);
    }

    public BaseAdapter(List<TestBean> data) {
        super(R.layout.item_list_test, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, TestBean item) {
        if (item != null) {
            holder.setText(R.id.tv_test, item.getName());
        }
    }
}
