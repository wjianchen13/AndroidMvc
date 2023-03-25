package com.example.androidmvc.test_recyclerview.bean;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewResultBean {

    List<RecyclerViewBean> mData = new ArrayList<>();

    public RecyclerViewResultBean(List<RecyclerViewBean> mData) {
        this.mData = mData;
    }

    public List<RecyclerViewBean> getmData() {
        return mData;
    }

    public void setmData(List<RecyclerViewBean> mData) {
        this.mData = mData;
    }
}
