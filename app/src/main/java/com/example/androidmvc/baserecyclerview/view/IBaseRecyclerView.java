package com.example.androidmvc.baserecyclerview.view;

import android.app.Activity;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.androidmvc.common.view.IBaseMvpView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import java.util.List;

/**
 * 列表接口
 */
public interface IBaseRecyclerView<D> extends IBaseMvpView {


    View getLoadSirTarget();
    boolean requireLogin();
    void onLoadDataFinish(boolean isRefresh, List<D> datas, boolean dataChanged, int pageCount);
    void scrollTop();
    <K extends RecyclerView.LayoutManager> K getLayoutManager();
    BaseQuickAdapter getBaseAdapter();
    SmartRefreshLayout getSmartRefreshLayout();
    void notifyDataSetChanged();
    // 检查是否需要显示或隐藏刷新提示界面
    boolean checkShowRefreshGuide(boolean isDataNotEmpty, String text);
    boolean checkShowRefreshGuide(String text);
    boolean checkShowRefreshGuide();

    int findFirstVisibleItemPosition();
    int findLastVisibleItemPosition();
    void scrollToPositionWithOffset(int position, int offset);

    Activity getActivityContext();

    // 获得布局视图
    View getLayoutView();

    boolean isLoadmoreEnable();
    boolean isRefreshEnable();
    boolean isRefreshing();
    boolean isLoadingMore();

    <T extends View> T findView(int id);

}
