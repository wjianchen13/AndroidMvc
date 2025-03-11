package com.example.androidmvc.test1.module;

import android.view.View;
import android.widget.TextView;

import com.example.androidmvc.R;
import com.example.androidmvc.practice.test_multi_activity.presenter.TestMultiPartMvpActivityPresenter;
import com.example.androidmvc.practice.test_multi_fragment.view.IPart2View;
import com.example.androidmvc.test1.activity.TestActivity;
import com.example.androidmvc.test1.presenter.TestPresenter;

public class TestModule2 extends BaseModule<TestActivity, TestPresenter> implements IPart2View {

    private TextView tvPart2;

    public TestModule2(View parent) {
        super(parent);
    }

    public TestModule2(TestActivity activity, TestPresenter presenter, View parent) {
        super(activity, presenter, parent);
    }

    @Override
    public void setVisible(int animEnum) {
        super.setVisible(animEnum);
    }

    @Override
    protected void lazyInitView() {
        super.lazyInitView();
        tvPart2 = mRootLayout.findViewById(R.id.tv_part2);
    }

    @Override
    public void onGetText2(String str) {
        tvPart2.setText(str);
    }
}
