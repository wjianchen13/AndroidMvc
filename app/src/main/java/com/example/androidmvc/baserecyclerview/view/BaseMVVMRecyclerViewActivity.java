package com.example.androidmvc.baserecyclerview.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.androidmvc.common.view.BaseMvpActivity;
import com.example.androidmvc.baserecyclerview.RecyclerViewAssist;
import com.example.androidmvc.baserecyclerview.presenter.BaseRecyclerViewPresenter;
import com.example.androidmvc.baserecyclerview.presenter.IRecyclerViewModle;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import java.util.List;

public abstract class BaseMVVMRecyclerViewActivity<D, P extends BaseRecyclerViewPresenter<D, ? extends IBaseActRecyclerView>> extends BaseMvpActivity<P> implements IBaseActRecyclerView<D> {

    // 避免直接引用
    private RecyclerViewAssist<D> mAssist;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContentView();
        getAssist().initViews();
    }

    protected void initContentView() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getAssist().onDestroy();
    }

    @Override
    public int findFirstVisibleItemPosition(){
        return getAssist().findFirstVisibleItemPosition();
    }

    //new State 一共有三种状态
    // SCROLL_STATE_IDLE：目前RecyclerView不是滚动，也就是静止
    // SCROLL_STATE_DRAGGING：RecyclerView目前被外部输入如用户触摸输入。
    //SCROLL_STATE_SETTLING：RecyclerView目前动画虽然不是在最后一个位置外部控制。
    @Override
    public int findLastVisibleItemPosition(){
        return getAssist().findLastVisibleItemPosition();
    }

    // 各种类型的layoutmanager的滚动到顶部可能调用的方法不一样，可以重写此方法，比如GridLayoutManager
    @Override
    public void scrollToPositionWithOffset(int position, int offset){
        getAssist().scrollToPositionWithOffset(position, offset);
    }

    @Override @CallSuper
    public boolean checkShowRefreshGuide(boolean isDataNotEmpty, String text) {
        return getAssist().checkShowRefreshGuide(isDataNotEmpty, text);
    }

    @Override
    public final boolean checkShowRefreshGuide(String text){
        return checkShowRefreshGuide(getPresenter().isDataNotEmpty(), text);
    }

    @Override
    public final boolean checkShowRefreshGuide(){
        return checkShowRefreshGuide(getPresenter().isDataNotEmpty(), getPresenter().emptyDataTips());
    }

    @Override
    public void notifyDataSetChanged(){
        getAssist().notifyDataSetChanged();
    }

    /**
     * 设置显示或隐藏刷新提示界面
     */
    protected void setShowRefreshGuide(boolean show) {
        getAssist().setShowRefreshGuide(show);
    }

    protected void onClickNoData(View v) {
        getAssist().onClickNoData(v);
    }

    // 各种类型的layoutmanager的滚动到顶部可能调用的方法不一样，可以重写此方法，比如GridLayoutManager
    @Override @UiThread
    public void scrollTop() {
        getAssist().scrollTop();
    }

    @Override
    public <T extends View> T findView(int id) {
        return findViewById(id);
    }

    @Override
    public void onLoadDataFinish(boolean isRefresh, List<D> datas, boolean dataChanged, int pageCount) {
        getAssist().onLoadDataFinish(isRefresh, datas, dataChanged, pageCount);
    }

    @Override
    public boolean refresh() {
        getAssist().refresh();
        return true;
    }

    @Override
    public Activity getActivityContext() {
        return super.getActivity();
    }

    /**
     * 关闭默认局部刷新动画
     */
    protected void closeRecyclerViewDefaultAnimator() {
        getAssist().closeRecyclerViewDefaultAnimator();
    }

    /**
     * 打开默认局部刷新动画
     */
    protected void openRecyclerViewDefaultAnimator() {
        getAssist().openRecyclerViewDefaultAnimator();
    }

    public List<D> getDatas() {
        return getPresenter().getDatas();
    }

    public void setDatas(List<D> datas) {
        getPresenter().setDatas(datas);
    }

    public int getDataCount(){
        return getPresenter().getDataCount();
    }

    @Override
    public View getLayoutView(){
        return null;
    }

    @Override
    public View getLoadSirTarget() {
        return getAssist().getLoadSirTarget();
    }

    @Override
    public boolean isRefreshing() {
        return getAssist().isRefreshing();
    }

    @Override
    public boolean isLoadingMore() {
        return getAssist().isLoadingMore();
    }


    public void finishRefreshOrLoadmore(){
        getAssist().finishRefreshOrLoadmore();
    }

    private RecyclerViewAssist<D> getAssist(){
        if (mAssist == null) {
            synchronized (this) {
                if (mAssist == null) {
                    mAssist = new RecyclerViewAssist<>(this, new RecyclerViewAssist.VMProvider() {
                        @Override
                        public boolean checkNotNull() {
                            return getPresenter() != null;
                        }

                        @Nullable
                        @Override
                        public IRecyclerViewModle provider() {
                            return getPresenter();
                        }
                    });
                }
            }
        }
        return mAssist;
    }

    public <K extends RecyclerView.LayoutManager> K getLayoutManager(){
        return getAssist().getLayoutManager();
    }

    public BaseQuickAdapter getBaseAdapter(){
        return getAssist().getBaseAdapter();
    }

    public BaseQuickAdapter setBaseAdapter(BaseQuickAdapter mBaseAdapter) {
        return getAssist().setBaseAdapter(mBaseAdapter);
    }

    public RecyclerView.LayoutManager setBaseLayoutManager(RecyclerView.LayoutManager mBaseLayoutManager) {
        return getAssist().setBaseLayoutManager(mBaseLayoutManager);
    }

    public RecyclerView getRecyclerView() {
        return getAssist().getRecyclerView();
    }

    public RecyclerView setRecyclerView(RecyclerView mRecyclerView) {
        return getAssist().setRecyclerView(mRecyclerView);
    }

    public SmartRefreshLayout getSmartRefreshLayout() {
        return getAssist().getSmartRefreshLayout();
    }

    public SmartRefreshLayout setSmartRefreshLayout(SmartRefreshLayout mSmartRefreshLayout) {
        return getAssist().setSmartRefreshLayout(mSmartRefreshLayout);
    }

}
