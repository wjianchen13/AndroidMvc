package com.example.androidmvc.baserecyclerview;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.androidmvc.baserecyclerview.presenter.IRecyclerViewModle;
import com.example.androidmvc.baserecyclerview.view.IBaseActRecyclerView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewModleAssist<T> {

    private static final String TAG = RecyclerViewModleAssist.class.getSimpleName();

    // 如果=0不执行自动刷新
    protected long refreshInterval = 0;
    protected long lastValidActionTime = 0;
    protected List<T> mDatas;
    protected int pageCount = 0;
    protected int checkAdvanceDataPostCount;
    private boolean firstCheckAdvanceFlag;

    IBaseActRecyclerView mView;
    IRecyclerViewModle vm;

    public RecyclerViewModleAssist(IBaseActRecyclerView view, IRecyclerViewModle vm){
        this.mView = view;
        this.vm = vm;
        mDatas = new ArrayList<>();
    }

    public void onUIready(){
//        NetReceiver.register(this);
    }

    public void initData() {
        vm.asynRefreshData();
    }

    public void loadCacheData() {
        vm.onLoadCacheData();
    }

//    @Override
//    public void onNetworkAvailable(int neType, boolean netWorkConnected, boolean wifiEnable, boolean wifiConnected, boolean mobileConnected) {
//        if (!NetReceiver.isNetwork(neType)) return;
//        if (netWorkConnected) vm.asynRefreshData();
//    }

    public boolean checkShowRefreshGuide(){
        return mView.checkShowRefreshGuide(isDataNotEmpty(), vm.emptyDataTips());
    }

    public void checkAdvanceData(int postCount){
//        //不可加载更多
//        if (!mView.getSmartRefreshLayout().isEnableLoadmore()){
//            return;
//        }
//        // 通常最小10条每页，不够一页的不响应
//        if(!vm.isCheckAdvanceData() || getDataCount() < 10 || postCount >= getDataCount() - 1)
//            return;
//
//        int residue = getDataCount() - postCount;
//        if (residue <= 8 && (!firstCheckAdvanceFlag || (postCount / 10 - checkAdvanceDataPostCount) > 0)) {
//            firstCheckAdvanceFlag = true;
//            checkAdvanceDataPostCount = postCount / 10;
//            vm.asynLoadMoreData(new Condition.Builder().silent(true));
//        }
    }

    public void notifyValidAction(){
        lastValidActionTime = System.currentTimeMillis();
    }

    public void checkDataOutOfDate() {
//        postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                boolean isShown = false;
//                if (mView instanceof IBaseFrgRecyclerView) {
//                    isShown = ((IBaseFrgRecyclerView) mView).isShown();
//                } else if (mView instanceof IBaseActRecyclerView) {
//                    isShown = ((IBaseActRecyclerView) mView).isAlive();
//                }
//                if (lastValidActionTime > 0
//                        && refreshInterval > 0
//                        && isShown
//                        && System.currentTimeMillis() - lastValidActionTime > refreshInterval) {
//                    mView.refresh();
//                }
//            }
//        }, 500);
    }

    public boolean isDataEmpty(){
        return vm.isDataEmpty();
    }

    public boolean isDataNotEmpty(){
        return vm.isDataNotEmpty();
    }

    public int getDataCount(){
        if(mDatas != null)
            return mDatas.size();
        return 0;
    }

    public <K> void _asynLoadData(final boolean isRefresh, final String url,  @NonNull final OnAsynLoadDataListener<K> listener){
        _asynLoadData(isRefresh, url, null, listener);
    }

    public <K> void _asynLoadData(final boolean isRefresh, final String url, Condition condition, @NonNull final OnAsynLoadDataListener<K> listener){

        if (condition == null)
            condition = new Condition.Builder().build();

        final Condition finalCondition = condition;

        if (isRefresh) {
            notifyValidAction();
            pageCount = condition.pageStart;
        }

        listener.attachData(getDatas());
        listener.hideLoading = mView.isRefreshing() || mView.isLoadingMore();
        listener.attachComponent(new OnAsynLoadDataListener.AsyComponent<K>(){
            @Override
            public final void onHttpListener(boolean httpResult, K obj, boolean silent) {
                // 数据是否被改变
                boolean isDataChanged = isRefresh;
                if (httpResult) {
                    // 下拉刷新数据，先清除全部
                    if (isRefresh || pageCount == finalCondition.pageStart){
                        listener.preSize = mDatas.size();
                        mDatas.clear();
                    }
                    listener.size = mDatas.size();
                    boolean isDataEmpty = listener.onData(isRefresh, obj);

                    if (!isDataEmpty) {
                        isDataChanged = true;
                        pageCount++;
                    } else if (!isRefresh) {
                        // 非静默和自动加载模式弹提示
                        if (!silent && !finalCondition.silent) {
//                            ApplicationUtil.showToast(R.string.loading_all);
                        }
                    }
                }

                checkShowRefreshGuide();
                mView.onLoadDataFinish(isRefresh, mDatas, isDataChanged, pageCount);
            }
        });

        listener.preRequest(new RequestExecutor<K>(condition, url, listener));
//        AsyHttpManager.executeByMode(condition.mode, url, requestParams, listener);
    }


    /************************************************************************************************
     *
     * getter & setter
     *
     ***********************************************************************************************/
    public @NonNull List<T> getDatas() {
        return mDatas;
    }

    public List<T> setDatas(@NonNull List<T> datas) {
        return this.mDatas = datas;
    }

    public long setRefreshInterval(long refreshInterval) {
        return this.refreshInterval = refreshInterval;
    }

    public int getPageCount(){
        return pageCount;
    }

    public int setPageCount(int pageCount){
        return this.pageCount = pageCount;
    }

    // 自增pagecount
    public void incPageCount(){
        pageCount++;
    }

    public String emptyDataTips(){
        return "no data";
    }

    /************************************************************************************************
     *
     * class & interface
     *
     ***********************************************************************************************/
    /**
     * 调用真正的接口前进行过滤
     * @param <T>
     */
    public static class RequestExecutor<T>{
        private Condition condition;
        private String url;
        private OnAsynLoadDataListener<T> listener;

        public RequestExecutor(Condition condition, String url, OnAsynLoadDataListener<T> listener) {
            this.condition = condition;
            this.url = url;
            this.listener = listener;
        }

        public void execute(){
            execute("");
        }

        public void execute(String str){
            if (condition == null)
                condition = new Condition.Builder().build();

            if(listener != null)
                listener.component.onHttpListener(true, null, true);
        }

    }

    public static class OnAsynLoadDataListener<K> {
        public int preSize;
        int size;
        List mDatas;
        AsyComponent<K> component;
        private boolean hideLoading;
        // 标记是否提示错误
        private boolean isCancel;

        public OnAsynLoadDataListener(){
        }

        public OnAsynLoadDataListener(final Context context, final boolean isShowLoading) {

        }

        public OnAsynLoadDataListener(final Context context, final boolean isShowLoading, boolean notFocusable) {

        }

        public static OnAsynLoadDataListener<JSONObject> empty(){
            return new OnAsynLoadDataListener<>();
        }

        private void cancel(){
            isCancel = true;
        }

        /**
         * 正式执行前可进行过滤
         * @param executor
         */
        public void preRequest(@NonNull RequestExecutor<K> executor){
            executor.execute();
        }

        /**
         * 数据处理
         * @param isRefresh
         * @param obj
         * @return 是否空数据，是=true，排除刷新的情况，加载更多的空数据
         */
        public boolean onData(boolean isRefresh, K obj){
            return !isRefresh && size == mDatas.size();
        }

        private void attachData(List data){
            this.mDatas = data;
        }

        private void attachComponent(AsyComponent<K> component){
            this.component = component;
        }

        private static class AsyComponent<K>{
            public void onHttpListener(boolean httpResult, K obj, boolean silent){

            }
        }
    }

    public static class Condition{

        private boolean silent;
        private String pageKey;
        private int pageStart;

        private Condition(Builder builder) {
            this.silent = builder.silent;
            this.pageKey = builder.pageKey;
            this.pageStart = builder.pageStart;
        }

        public static class Builder{

            private boolean silent;
            private String pageKey = "page";
            private int pageStart;

            public Condition build(){
                return new Condition(this);
            }

            public Builder silent(boolean silent){
                this.silent = silent;
                return this;
            }

            public Builder pageKey(String pageKey){
                this.pageKey = pageKey;
                return this;
            }

            public Builder pageStart(int pageStart){
                this.pageStart = pageStart;
                return this;
            }

        }
    }

}
