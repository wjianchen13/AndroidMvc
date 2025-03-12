package com.example.androidmvc.test1.activity;

import static com.example.androidmvc.practice.base.module.Constants.MODULE_VISIABLE;

import android.view.View;

import com.example.androidmvc.test1.module.BaseModule;
import com.example.androidmvc.test1.module.TestModule1;
import com.example.androidmvc.test1.module.TestModule2;
import com.example.androidmvc.test1.module.TestModule3;
import com.example.androidmvc.test1.presenter.TestPresenter;

public class TestHandler {

    private TestActivity mTestActivity;
    private View mRootView;

    private TestModule1 mPart1Module;
    private TestModule2 mPart2Module;
    private TestModule3 mPart3Module;

    public TestHandler(TestActivity activity, View rootView) {
        mTestActivity = activity;
        mRootView = rootView;
    }

    protected <M extends BaseModule> M createModule(M module) {
        return (M)mTestActivity.createModule(module);
    }

    public void initModules() {
        mPart1Module = (TestModule1)mTestActivity.createModule(new TestModule1(mTestActivity, getPresenter(), mRootView));
        mPart1Module.init();
        mPart2Module = (TestModule2)mTestActivity.createModule(new TestModule2(mTestActivity, getPresenter(), mRootView));
        mPart2Module.init();
        mPart3Module = (TestModule3)mTestActivity.createModule(new TestModule3(mTestActivity, getPresenter(), mRootView));

    }

    public TestPresenter getPresenter() {
        return (TestPresenter)mTestActivity.getPresenter();
    }

    public void setPart3Visibility() {
        mPart3Module.setVisible(MODULE_VISIABLE);
    }

    public void onGetText(String str) {
        mPart1Module.onGetText(str);
    }

    public void onGetText2(String str) {
        mPart2Module.onGetText2(str);
    }

    public void onGetText3(String str) {
        mPart3Module.onGetText3(str);
    }


}
