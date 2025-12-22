package com.example.androidmvc.test1.module;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;

import com.example.androidmvc.R;
import com.example.androidmvc.practice.test_multi_fragment.view.IPart3View;
import com.example.androidmvc.test1.activity.TestActivity;
import com.example.androidmvc.test1.presenter.TestPresenter;

public class TestModule3 extends BaseModule<TestActivity, TestPresenter>  implements IPart3View {

    private TextView tvPart3;

    public TestModule3(View parent) {
        super(parent);
    }

    public TestModule3(TestActivity activity, TestPresenter presenter, View parent) {
        super(activity, presenter, parent);
    }

    @Override
    public void setVisible(int animEnum) {
        super.setVisible(animEnum);
    }

    @Override
    protected void lazyInitView() {
        super.lazyInitView();
        ViewStub viewStub = mRootLayout.findViewById(R.id.vs_part3);
        viewStub.inflate();
        mCurrentLayout = mRootLayout.findViewById(R.id.llyt_part3);
        tvPart3 = mRootLayout.findViewById(R.id.tv_part3);
    }

    @Override
    public void onGetText3(String str) {
        tvPart3.setText(str);
    }
}
