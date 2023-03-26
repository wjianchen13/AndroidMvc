package com.example.androidmvc.generic1;

import android.os.Bundle;

import com.example.androidmvc.R;
import com.example.androidmvc.generic1.view.CommonFragmentActivity;

/**
 * 测试项目中显示fragment的情况
 */
public class TestFragmentActivity extends CommonFragmentActivity<TestBean, ITestMvpView, TestMvpPresenter<TestBean, ITestMvpView>> {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment);
        TestFragment fragment = TestFragment.newInstance("main");
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_test, fragment).commit();
    }

}