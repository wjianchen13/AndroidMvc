package com.example.androidmvc.practice.test_activity.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.androidmvc.R;
import com.example.androidmvc.practice.base.view.BaseMvpActivity;
import com.example.androidmvc.practice.test_activity.presenter.TestMvpPresenter;
import com.example.androidmvc.utils.Utils;

public class TestMvpActivity extends BaseMvpActivity<ITestMvpView, TestMvpPresenter> implements ITestMvpView{

    private static final String TAG = TestMvpActivity.class.getSimpleName();
    private TextView tvTip1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_mvp);
        tvTip1 = findViewById(R.id.tv_tip1);
    }

    @Override
    protected TestMvpPresenter initPresenter() {
        return new TestMvpPresenter(this);
    }

    public void onToast(View v) {
        mPresenter.showToast("toast");
    }


    public void onTest(View v) {
        String str = mPresenter.getTestString();
        Utils.i(TAG, "str: " + str);
    }


    public void onContext(View v) {
        Context context = mPresenter.getContext();
        Utils.i(TAG, "context: " + context);
    }

    public void onTip(View v) {
        mPresenter.onTip();
    }

    @Override
    public void test() {
        tvTip1.setVisibility(View.VISIBLE);
    }
}