package com.example.androidmvc.practice.test_multi_fragment.presenter;

import com.example.androidmvc.practice.base.presenter.MultiPartyMvpPresenter;
import com.example.androidmvc.practice.test_multi_fragment.view.ITestMultiPartMvpFragmentView;

public class TestMultiPartMvpFragmentPresenter extends MultiPartyMvpPresenter<ITestMultiPartMvpFragmentView> {

    private FragmentPart1Presenter mPart1Presenter;
    private FragmentPart2Presenter mPart2Presenter;
    private FragmentPart3Presenter mPart3Presenter;

    public TestMultiPartMvpFragmentPresenter(ITestMultiPartMvpFragmentView view) {
        super(view);
        initPresenters(view);
    }

    private void initPresenters(ITestMultiPartMvpFragmentView view) {
        mPart1Presenter = initChildPresenter(new FragmentPart1Presenter(view));
        mPart2Presenter = initChildPresenter(new FragmentPart2Presenter(view));
        mPart3Presenter = initChildPresenter(new FragmentPart3Presenter(view));
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