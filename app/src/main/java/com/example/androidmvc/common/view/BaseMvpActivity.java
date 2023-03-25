package com.example.androidmvc.common.view;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidmvc.common.presenter.BaseMvpPresenter;

/**
 * 公共列表显示数据
 */
public abstract class BaseMvpActivity<P extends BaseMvpPresenter> extends AppCompatActivity implements IBaseMvpView, View.OnClickListener {

    protected  P mPresenter;

    protected abstract P createPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
    }

    @Override
    public P getPresenter() {
        return mPresenter;
    }

    @Override
    public void onClick(View view) {

    }
}