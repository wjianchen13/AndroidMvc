package com.example.androidmvc.practice.test_multi_activity.presenter;

import com.example.androidmvc.practice.base.presenter.MultiPartyMvpPresenter;
import com.example.androidmvc.practice.test_multi_activity.view.ITestMultiPartMvpActivityView;
import com.example.androidmvc.practice.test_multi_fragment.presenter.FragmentPart1Presenter;
import com.example.androidmvc.practice.test_multi_fragment.presenter.FragmentPart2Presenter;
import com.example.androidmvc.practice.test_multi_fragment.presenter.FragmentPart3Presenter;

public class TestMultiPartMvpActivityPresenter extends MultiPartyMvpPresenter<ITestMultiPartMvpActivityView> {

    private ActivityPart1Presenter mPart1Presenter;
    private ActivityPart2Presenter mPart2Presenter;
    private ActivityPart3Presenter mPart3Presenter;

    public TestMultiPartMvpActivityPresenter(ITestMultiPartMvpActivityView view) {
        super(view);
        initPresenters(view);
    }

    private void initPresenters(ITestMultiPartMvpActivityView view) {
        mPart1Presenter = initChildPresenter(new ActivityPart1Presenter(view));
        mPart2Presenter = initChildPresenter(new ActivityPart2Presenter(view));
        mPart3Presenter = initChildPresenter(new ActivityPart3Presenter(view));
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