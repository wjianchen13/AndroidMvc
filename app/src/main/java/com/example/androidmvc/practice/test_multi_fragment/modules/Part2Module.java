package com.example.androidmvc.practice.test_multi_fragment.modules;

import android.view.View;
import android.widget.TextView;

import com.example.androidmvc.R;
import com.example.androidmvc.practice.base.module.BaseModule;
import com.example.androidmvc.practice.base.view.BaseMultiPartMvpFragment;
import com.example.androidmvc.practice.test_multi_fragment.view.IPart2View;

public class Part2Module extends BaseModule implements IPart2View {

    private TextView tvPart2;

    public Part2Module(View parent) {
        super(parent);
    }

    public Part2Module(BaseMultiPartMvpFragment fragment, View parent) {
        super(fragment, parent);
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
