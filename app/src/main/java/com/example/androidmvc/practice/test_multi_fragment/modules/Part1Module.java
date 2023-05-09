package com.example.androidmvc.practice.test_multi_fragment.modules;

import android.view.View;
import android.widget.TextView;

import com.example.androidmvc.R;
import com.example.androidmvc.practice.base.module.BaseModule;
import com.example.androidmvc.practice.base.view.BaseMultiPartMvpFragment;
import com.example.androidmvc.practice.test_multi_fragment.view.IPart1View;

public class Part1Module extends BaseModule implements IPart1View {

    private TextView tvPart1;

    public Part1Module(View parent) {
        super(parent);
    }

    public Part1Module(BaseMultiPartMvpFragment fragment, View parent) {
        super(fragment, parent);
    }

    @Override
    public void setVisible(int animEnum) {
        super.setVisible(animEnum);
    }

    @Override
    protected void lazyInitView() {
        super.lazyInitView();
        tvPart1 = mRootLayout.findViewById(R.id.tv_part1);
    }

    @Override
    public void onGetText(String str) {
        tvPart1.setText(str);
    }
}
