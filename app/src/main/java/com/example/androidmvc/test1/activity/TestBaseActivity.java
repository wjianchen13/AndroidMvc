package com.example.androidmvc.test1.activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidmvc.test1.module.BaseModule;
import com.example.androidmvc.test1.presenter.TestBasePresenter;
import com.example.androidmvc.test1.view.ITestView;

import java.util.LinkedList;
import java.util.List;

/**
 * MVP公共父类
 * 最开始这样写有问题
 * P extends BaseMvpPresenter<IBaseMvpView>
 * 因为子类需要使用BaseMvpPresenter<ITestMvpView>
 * 而父类限定了IBaseMvpView，所以类型不匹配，正确是是使用V extends IBaseMvpView
 */
public abstract class TestBaseActivity<V extends ITestView, P extends TestBasePresenter<V>> extends AppCompatActivity implements ITestView {

    protected P mPresenter;

    protected List<BaseModule> mModules;

    public List<BaseModule> getModules() {
        if(mModules == null)
            mModules = new LinkedList<>();
        return mModules;
    }

    protected <T extends  BaseModule> T createModule(T module) {
        if(module != null) {
            getModules().add(module);
        }
        return module;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
    }

    protected abstract P initPresenter();

    public P getPresenter() {
        if(mPresenter == null)
            mPresenter = initPresenter();
        return mPresenter;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mPresenter != null)
            mPresenter.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if(mPresenter != null)
            mPresenter.onRestart();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if(mPresenter != null)
            mPresenter.onPostResume();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mPresenter != null)
            mPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mPresenter != null)
            mPresenter.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mPresenter != null)
            mPresenter.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter != null)
            mPresenter.onDestroy();
    }
}