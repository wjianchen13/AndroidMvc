package com.example.androidmvc.baserecyclerview.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;

import com.example.androidmvc.common.presenter.BaseMvpPresenter;
import com.example.androidmvc.baserecyclerview.RecyclerViewModleAssist;
import com.example.androidmvc.baserecyclerview.view.IBaseActRecyclerView;


import java.util.List;

public abstract class BaseRecyclerViewPresenter<D, K extends IBaseActRecyclerView> extends BaseMvpPresenter<K> implements IRecyclerViewModle {

    private static final String TAG = BaseRecyclerViewPresenter.class.getSimpleName();

    protected boolean isFirstCreate;
    private RecyclerViewModleAssist<D> mAssist;

    /************************************************************************************************
     *
     * construct
     *
     ***********************************************************************************************/
    public BaseRecyclerViewPresenter(K baseView) {
        super(baseView);
        mAssist = new RecyclerViewModleAssist<>(baseView, this);
    }

    /************************************************************************************************
     *
     * overrides
     *
     ***********************************************************************************************/
    @Override
    public boolean queueIdle(Bundle savedInstanceState, Intent intent, LayoutInflater inflater) {
        mAssist.onUIready();
        mAssist.initData();
        return super.queueIdle(savedInstanceState, intent, inflater);
    }

    /************************************************************************************************
     *
     * methods
     *
     ***********************************************************************************************/

    @Override
    public void onLoadCacheData() {

    }

    /**
     * 下拉刷新
     */
    @Override @CallSuper
    public void asynRefreshData(){
        asynLoadData(true, new RecyclerViewModleAssist.Condition.Builder());
    }

    @Override @CallSuper
    public void asynRefreshData(@NonNull RecyclerViewModleAssist.Condition.Builder builder){
        asynLoadData(true, builder);
    }

    /**
     * 上拉加载更多
     */
    @Override @CallSuper
    public void asynLoadMoreData(){
        asynLoadData(false, new RecyclerViewModleAssist.Condition.Builder());
    }

    @Override @CallSuper
    public void asynLoadMoreData(@NonNull RecyclerViewModleAssist.Condition.Builder builder){
        asynLoadData(false, builder);
    }

    protected abstract void asynLoadData(final boolean isRefresh, final @NonNull RecyclerViewModleAssist.Condition.Builder builder);

    protected boolean checkShowRefreshGuide(){
        return mAssist.checkShowRefreshGuide();
    }

    /**
     * 剩余一定数量的数据前，提前预加载下一页
     * @param postCount 浏览过的数量
     */
    @Override
    public void checkAdvanceData(int postCount){
        mAssist.checkAdvanceData(postCount);
    }

    @Override
    public boolean isCheckAdvanceData(){
        return true;
    }

    @Override
    public String emptyDataTips(){
        return mAssist == null ? "" : mAssist.emptyDataTips();
    }

    // 用于记录有效的操作，自动刷新的时间记录
    @Override
    public void notifyValidAction(){
        mAssist.notifyValidAction();
    }

    // 数据是否为空
    @Override
    public boolean isDataEmpty(){
        return getDatas() != null && getDatas().size() > 0;
    }

    @Override
    public boolean isDataNotEmpty(){
        return !isDataEmpty();
    }

    @Override
    public void onForceDataChanged(){

    }

    /************************************************************************************************
     *
     * getter & setter
     *
     ***********************************************************************************************/
    public int getPageCount(){
        return mAssist.getPageCount();
    }

    public int setPageCount(int pageCount){
        return mAssist.setPageCount(pageCount);
    }

    public void incPageCount(){
        mAssist.incPageCount();
    }

    public long setRefreshInterval(long refreshInterval) {
        return mAssist.setRefreshInterval(refreshInterval);
    }

    public @NonNull List<D> getDatas() {
        return mAssist.getDatas();
    }

    public List<D> setDatas(@NonNull List<D> datas) {
        return mAssist.setDatas(datas);
    }

    public int getDataCount(){
        return mAssist.getDataCount();
    }

    public <S> void _asynLoadData(final boolean isRefresh, final String url, @NonNull final RecyclerViewModleAssist.OnAsynLoadDataListener<S> listener){
        mAssist._asynLoadData(isRefresh, url, listener);
    }

    public <S> void _asynLoadData(final boolean isRefresh, final String url, RecyclerViewModleAssist.Condition condition, @NonNull final RecyclerViewModleAssist.OnAsynLoadDataListener<S> listener){
        mAssist._asynLoadData(isRefresh, url, condition, listener);
    }

}
