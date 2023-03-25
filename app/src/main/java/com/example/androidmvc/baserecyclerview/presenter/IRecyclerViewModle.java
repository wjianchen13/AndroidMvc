package com.example.androidmvc.baserecyclerview.presenter;

import androidx.annotation.NonNull;

import com.example.androidmvc.baserecyclerview.RecyclerViewModleAssist;

/**
 * 用于统一recyclerview.fragment和activity的viewmodle
 */
public interface IRecyclerViewModle {

    void checkAdvanceData(int postCount);
    boolean isCheckAdvanceData();
    void onLoadCacheData();
    void asynLoadMoreData();
    void asynRefreshData();
    void asynLoadMoreData(@NonNull RecyclerViewModleAssist.Condition.Builder builder);
    void asynRefreshData(@NonNull RecyclerViewModleAssist.Condition.Builder builder);
    void notifyValidAction();
    String emptyDataTips();

    boolean isDataEmpty();
    boolean isDataNotEmpty();
    /**
     * 强制数据改变，比如屏蔽用户
     */
    void onForceDataChanged();
}
