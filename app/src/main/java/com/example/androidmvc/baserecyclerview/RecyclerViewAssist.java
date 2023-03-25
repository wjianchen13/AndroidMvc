package com.example.androidmvc.baserecyclerview;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.androidmvc.R;
import com.example.androidmvc.baserecyclerview.presenter.IRecyclerViewModle;
import com.example.androidmvc.baserecyclerview.view.IBaseRecyclerView;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.List;


/**
 * 用于recyclerviewfragment和activity的辅助类
 * 避免fragment和activity维护两套代码
 */
public class RecyclerViewAssist<D> {

    private BaseQuickAdapter mBaseAdapter;
    private RecyclerView.LayoutManager mBaseLayoutManager;

    RecyclerView mRecyclerView;

    SmartRefreshLayout mSmartRefreshLayout;

    ClassicsHeader mClassicsHeader;

    ClassicsFooter mClassicsFooter;
//    private RefreshGuideTool mRefreshGuideTool; // 加载数据提醒

    @NonNull
    IBaseRecyclerView mView;
    @NonNull VMProvider mProvider;

    boolean initCalled;

    public RecyclerViewAssist(@NonNull IBaseRecyclerView view, @NonNull VMProvider provider){
        this.mView = view;
        this.mProvider = provider;
        checkBindViewIfNull();
    }

    public void initViews(){
        mRecyclerView = (RecyclerView)mView.findView(R.id.rv_refresh);
        mSmartRefreshLayout = (SmartRefreshLayout)mView.findView(R.id.refreshLayout);
        mClassicsHeader = (ClassicsHeader)mView.findView(R.id.header);
        mClassicsFooter = (ClassicsFooter)mView.findView(R.id.footer);
        // 已经初始化过
        if (initCalled)
            return;

        if(mRecyclerView != null){
            mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                    if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
//                        vm.checkAdvanceData(mView.findLastVisibleItemPosition());
//                    }
                }

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    // onScrolledToTop
                    if (!mRecyclerView.canScrollVertically(-1)) {
                    } else if (!mRecyclerView.canScrollVertically(1)) {
                        // onScrolledToBottom
                    } else if (dy < 0) {
                        // onScrolledUp
                    } else if (dy > 0) {
                        // onScrolledDown
                        if (mProvider.checkNotNull()) {
                            mProvider.provider().checkAdvanceData(mView.findLastVisibleItemPosition());
                        }
                    }
                }
            });
        }
        if (mSmartRefreshLayout != null) {
            mSmartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
                @Override
                public void onLoadMore(RefreshLayout refreshLayout) {
                    if (mProvider.checkNotNull()) {
                        mProvider.provider().asynLoadMoreData();
                    }
                }
            });
            mSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshLayout) {
                    if (mProvider.checkNotNull()) {
                        mProvider.provider().asynRefreshData();
                    }
                }
            });

        }

//        try {
//            if(mRefreshGuideTool == null)
//                mRefreshGuideTool = new RefreshGuideTool(mView.getLayoutView());
//            mRefreshGuideTool.isShow(false);
//        } catch (Exception e){
//            e.printStackTrace();
//            mRefreshGuideTool = null;
//        }
//
//        if (mRefreshGuideTool != null) {
//            mRefreshGuideTool.setNoDataOnClick(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    onClickNoData(v);
//                }
//            });
//        }

        initCalled = true;
    }

    private void checkBindViewIfNull(){
        if (mRecyclerView == null || mSmartRefreshLayout == null) {
//            try {
//                ButterKnife.bind(this, mView.getLayoutView());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }
    }

    public int findFirstVisibleItemPosition(){
        if (mBaseLayoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager)mBaseLayoutManager).findFirstVisibleItemPosition();
        }
        return 0;
    }

    public int findLastVisibleItemPosition(){
        if (mBaseLayoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager)mBaseLayoutManager).findLastVisibleItemPosition();
        }
        return 0;
    }

    public void scrollToPositionWithOffset(int position, int offset){
        if (mBaseLayoutManager instanceof LinearLayoutManager) {
            ((LinearLayoutManager)mBaseLayoutManager).scrollToPositionWithOffset(position, offset);
        }
    }

    public View getLoadSirTarget() {
        // RefreshGuideTool启用时禁用LoadSir
//        return mRefreshGuideTool.isEnable() ? null : mRecyclerView;
        return null;
    }

    /**
     * 显示空数据
     * @param isDataNotEmpty
     * @param text
     * @return true=空/显示，false=非空/隐藏
     */
    public boolean checkShowRefreshGuide(boolean isDataNotEmpty, String text) {
//        if (mRefreshGuideTool != null) {
//            if (isDataNotEmpty) {
//                return mRefreshGuideTool.isShow(false);
//            } else {
//                mRefreshGuideTool.setEmptyText(text);
//                if (mSmartRefreshLayout != null) {
//                    mSmartRefreshLayout.finishRefresh();
//                    mSmartRefreshLayout.finishLoadmore();
//                }
//                return mRefreshGuideTool.isShow(true);
//            }
//        }
        return false;
    }

    public void notifyDataSetChanged() {
//        if (mBaseAdapter == null)
//            ApplicationUtil.showToastIfDebug("mBaseAdapter is null，no data show!");
        if (mBaseAdapter != null) {
            if (mRecyclerView != null && mRecyclerView.isComputingLayout()){
                mRecyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        if (mView != null) {
                            mView.notifyDataSetChanged();
                        } else {
                            mBaseAdapter.notifyDataSetChanged();
                        }
                    }
                });
            } else {
                mBaseAdapter.notifyDataSetChanged();
            }
        }
        mView.checkShowRefreshGuide(mProvider.checkNotNull() ? mProvider.provider().emptyDataTips() : "");
    }

    public void setShowRefreshGuide(boolean show) {
//        if (mRefreshGuideTool != null && !show) {
//            mRefreshGuideTool.isShow(false);
//        }
    }

    public void onClickNoData(View v) {
        if (mProvider.checkNotNull()) {
            mProvider.provider().asynRefreshData();
        }
    }

    public void scrollTop() {
        if (mBaseLayoutManager != null) {
            if (mBaseLayoutManager instanceof LinearLayoutManager) {
                ((LinearLayoutManager) mBaseLayoutManager).scrollToPositionWithOffset(0, 0);
            } else if (mBaseLayoutManager instanceof StaggeredGridLayoutManager) {
                ((StaggeredGridLayoutManager) mBaseLayoutManager).scrollToPositionWithOffset(0, 0);
            } else {
                mView.scrollToPositionWithOffset(0, 0);
            }
        }
    }

    public void onLoadDataFinish(boolean isRefresh, List<D> datas, boolean dataChanged, int pageCount) {
        if(isRefresh){
            //传入false表示刷新失败
            if(mSmartRefreshLayout != null) mSmartRefreshLayout.finishRefresh();
        } else {
            //传入false表示加载失败
            if(mSmartRefreshLayout != null)  mSmartRefreshLayout.finishLoadMore();
        }
        if(dataChanged) mView.notifyDataSetChanged();
    }

    public void refresh() {
        mView.scrollTop();
        if(mSmartRefreshLayout != null) mSmartRefreshLayout.autoRefresh();
    }

    public void finishRefreshOrLoadmore(){
        if (mSmartRefreshLayout != null){
            mSmartRefreshLayout.finishRefresh();
            mSmartRefreshLayout.finishLoadMore();
        }
    }

    /**
     * 关闭默认局部刷新动画
     */
    public void closeRecyclerViewDefaultAnimator() {
        if (mRecyclerView != null) {
            mRecyclerView.getItemAnimator().setAddDuration(0);
            mRecyclerView.getItemAnimator().setChangeDuration(0);
            mRecyclerView.getItemAnimator().setMoveDuration(0);
            mRecyclerView.getItemAnimator().setRemoveDuration(0);
            ((SimpleItemAnimator) mRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        }
    }

    /**
     * 打开默认局部刷新动画
     */
    public void openRecyclerViewDefaultAnimator() {
        if (mRecyclerView != null) {
            mRecyclerView.getItemAnimator().setAddDuration(120);
            mRecyclerView.getItemAnimator().setChangeDuration(250);
            mRecyclerView.getItemAnimator().setMoveDuration(250);
            mRecyclerView.getItemAnimator().setRemoveDuration(120);
            ((SimpleItemAnimator) mRecyclerView.getItemAnimator()).setSupportsChangeAnimations(true);
        }
    }

    public void onDestroy() {
        if (mSmartRefreshLayout != null) {
            mSmartRefreshLayout.setOnLoadMoreListener(null);
            mSmartRefreshLayout.setOnRefreshListener(null);
        }
    }

    public boolean isRefreshing() {
        return null != mSmartRefreshLayout && mSmartRefreshLayout.isRefreshing();
    }

    public boolean isLoadingMore() {
        return null != mSmartRefreshLayout && mSmartRefreshLayout.isLoading();
    }

    /************************************************************************************************
     *
     * getter & setter
     *
     ***********************************************************************************************/
    public BaseQuickAdapter getBaseAdapter(){
        return mBaseAdapter;
    }

    public BaseQuickAdapter setBaseAdapter(BaseQuickAdapter mBaseAdapter) {
        return this.mBaseAdapter = mBaseAdapter;
    }

    public <K  extends RecyclerView.LayoutManager> K getLayoutManager() {
        return (K) mBaseLayoutManager;
    }

    public RecyclerView.LayoutManager setBaseLayoutManager(RecyclerView.LayoutManager mBaseLayoutManager) {
        return this.mBaseLayoutManager = mBaseLayoutManager;
    }

    public RecyclerView getRecyclerView() {
        checkBindViewIfNull();
        return mRecyclerView;
    }

    public RecyclerView setRecyclerView(RecyclerView mRecyclerView) {
        return this.mRecyclerView = mRecyclerView;
    }

    public SmartRefreshLayout getSmartRefreshLayout() {
        checkBindViewIfNull();
        return mSmartRefreshLayout;
    }

    public SmartRefreshLayout setSmartRefreshLayout(SmartRefreshLayout mSmartRefreshLayout) {
        return this.mSmartRefreshLayout = mSmartRefreshLayout;
    }


    public interface VMProvider{
        boolean checkNotNull();
        @Nullable
        IRecyclerViewModle provider();
    }
}
