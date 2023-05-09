package com.example.androidmvc.practice.test_multi_fragment.modules;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidmvc.R;
import com.example.androidmvc.practice.base.module.BaseModule;
import com.example.androidmvc.practice.base.view.BaseMultiPartMvpFragment;
import com.example.androidmvc.practice.test_multi_fragment.presenter.TestMultiPartMvpFragmentPresenter;
import com.example.androidmvc.practice.test_multi_fragment.view.IPart1View;
import com.example.androidmvc.practice.test_multi_fragment.view.TestMultiPartMvpFragment;

public class Part1Module extends BaseModule implements IPart1View {

    private TextView tvPart1;
    private Button btnPart1;
    private TestMultiPartMvpFragment mTestFragment;
    private TestMultiPartMvpFragmentPresenter mFragmentPresenter;

    public Part1Module(View parent) {
        super(parent);
    }

    public Part1Module(BaseMultiPartMvpFragment fragment, View parent) {
        super(fragment, parent);
        this.mTestFragment = (TestMultiPartMvpFragment)fragment;
        this.mFragmentPresenter = mTestFragment.getPresenter();
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
            if(mFragmentPresenter != null)
                mFragmentPresenter.getPart1Text();
        }
    }
}
