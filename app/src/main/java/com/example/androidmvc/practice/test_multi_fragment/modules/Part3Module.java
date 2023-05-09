package com.example.androidmvc.practice.test_multi_fragment.modules;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;

import com.example.androidmvc.R;
import com.example.androidmvc.practice.base.module.BaseModule;
import com.example.androidmvc.practice.base.view.BaseMultiPartMvpFragment;
import com.example.androidmvc.practice.test_multi_fragment.view.IPart3View;
import com.example.androidmvc.practice.test_multi_fragment.view.TestMultiPartMvpFragment;

public class Part3Module extends BaseModule implements IPart3View {

    private TextView tvPart3;

    public Part3Module(View parent) {
        super(parent);
    }

    public Part3Module(TestMultiPartMvpFragment fragment, View parent) {
        super(fragment, parent);
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
