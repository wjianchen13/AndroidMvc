package com.example.androidmvc.practice.test_activity.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.androidmvc.R;
import com.example.androidmvc.practice.base.view.BaseMvpActivity;
import com.example.androidmvc.practice.test_activity.presenter.TestMvpActivityPresenter;
import com.example.androidmvc.utils.Utils;

public class TestMvpActivity extends BaseMvpActivity<ITestMvpActivityView, TestMvpActivityPresenter> implements ITestMvpActivityView {

    private static final String TAG = TestMvpActivity.class.getSimpleName();
    private TextView tvTip1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_mvp_activity);
        tvTip1 = findViewById(R.id.tv_tip1);
    }

    @Override
    protected TestMvpActivityPresenter initPresenter() {
        return new TestMvpActivityPresenter(this);
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