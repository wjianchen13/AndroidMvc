package com.example.androidmvc.generic1.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidmvc.generic1.presenter.BaseMvpPresenter;

/**
 * 测试项目中显示fragment的情况
 */
public class BaseFragmentActivity<V extends IBaseMvpView, P extends BaseMvpPresenter<V>>  extends AppCompatActivity {

    V view;
    P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public BaseMvpPresenter getMvpPresenter() {
        return presenter = createPresenter();
    }

    protected P createPresenter() {
        return null;
    }
}