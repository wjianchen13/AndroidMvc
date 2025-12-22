package com.example.androidmvc.test1.module;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidmvc.R;
import com.example.androidmvc.practice.test_multi_fragment.view.IPart1View;
import com.example.androidmvc.test1.activity.TestActivity;
import com.example.androidmvc.test1.presenter.TestPresenter;

public class TestModule1 extends BaseModule<TestActivity, TestPresenter> implements IPart1View {

    private TextView tvPart1;
    private Button btnPart1;

    public TestModule1(View parent) {
        super(parent);
    }

    public TestModule1(TestActivity activity, TestPresenter presenter, View parent) {
        super(activity, presenter, parent);
//        this.mActivityPresenter = mTarget.getPresenter();
//        mTarget.initModules
    }

    @Override
    public void setVisible(int animEnum) {
        super.setVisible(animEnum);
    }

    @Override
    protected void lazyInitView() {
        super.lazyInitView();
        tvPart1 = mRootLayout.findViewById(R.id.tv_part1);
        btnPart1 = mRootLayout.findViewById(R.id.btn_part10);
        btnPart1.setOnClickListener(this);
    }

    @Override
    public void onGetText(String str) {
        tvPart1.setText(str);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if(v.getId() == R.id.btn_part10) {
            if(mPresenter != null)
                mPresenter.getPart1Text();
        }
    }
}
