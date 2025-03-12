package com.example.androidmvc.test1.presenter;

import com.example.androidmvc.test1.view.ITestView;

import java.util.LinkedList;
import java.util.List;

public class TestPresenter<V extends ITestView> extends TestBasePresenter<V> {

    private TestPresenter1 mPart1Presenter;
    private TestPresenter2 mPart2Presenter;
    private TestPresenter3 mPart3Presenter;

    protected List<TestBasePresenter> mChildFragmentPresenters;

    protected List<TestBasePresenter> getChildFragmentPresenters() {
        if(mChildFragmentPresenters == null)
            mChildFragmentPresenters = new LinkedList<>();
        return mChildFragmentPresenters;
    }

    public TestPresenter(V view) {
        super(view);
        initPresenters(view);
    }

    protected <T extends TestBasePresenter> T initChildPresenter(T presenter) {
        if(presenter != null)
            getChildFragmentPresenters().add(presenter);
        return presenter;
    }

    private void initPresenters(ITestView view) {
        mPart1Presenter = initChildPresenter(new TestPresenter1(view));
        mPart2Presenter = initChildPresenter(new TestPresenter2(view));
        mPart3Presenter = initChildPresenter(new TestPresenter3(view));
    }

    public void getPart1Text() {
        if(mPart1Presenter != null)
            mPart1Presenter.getPart1Text();
    }

    public void getPart2Text() {
        if(mPart2Presenter != null)
            mPart2Presenter.getPart2Text();
    }

    public void getPart3Text() {
        if(mPart3Presenter != null)
            mPart3Presenter.getPart3Text();
    }

    public String getTestString() {
        return "TestMvpPresenter";
    }

    public void onTip() {
        getView().test();
    }

}