package com.example.androidmvc.test1.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidmvc.R;
import com.example.androidmvc.test1.module.BaseModule;
import com.example.androidmvc.test1.module.TestModule1;
import com.example.androidmvc.test1.module.TestModule2;
import com.example.androidmvc.test1.module.TestModule3;
import com.example.androidmvc.test1.presenter.TestPresenter;
import com.example.androidmvc.test1.view.ITargetView;
import com.example.androidmvc.test1.view.ITestBaseView;
import com.example.androidmvc.test1.view.ITestView;

public class TestActivity<V extends ITestView, P extends TestPresenter<V>> extends TestBaseActivity<V, P> implements ITestView, ITargetView, View.OnClickListener {

    public static final String TAG = TestActivity.class.getSimpleName();

    private String LOG = "=============================> ";

    private View mRootView;
    private Button btnTest1;
    private Button btnTest2;
    private Button btnTest3;
    private Button btnTest4;
    private TestHandler mTestHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_multi_part);

        initView();
        mTestHandler = new TestHandler(this, mRootView);
        initModules();
    }

    public void initView() {
        mRootView = findViewById(R.id.rlyt_frame);
        btnTest1 = findViewById(R.id.btn_test1);
        btnTest2 = findViewById(R.id.btn_test2);
        btnTest3 = findViewById(R.id.btn_test3);
        btnTest4 = findViewById(R.id.btn_test4);
        btnTest1.setOnClickListener(this);
        btnTest2.setOnClickListener(this);
        btnTest3.setOnClickListener(this);
        btnTest4.setOnClickListener(this);
    }

    @Override
    protected P initPresenter() {
        return (P) new TestPresenter(this);
    }

    @Override
    protected <M extends  BaseModule> M createModule(M module) {
        return super.createModule(module);
    }
//    private TestModule1 mPart1Module;
//
//    public void initModules1() {
//        mPart1Module = createModule(new TestModule1(this, getPresenter(), mRootView));
//        mPart1Module.init();
//    }

    private void initModules() {
        mTestHandler.initModules();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_test1) {
            getPresenter().getPart1Text();
        } else if(v.getId() == R.id.btn_test2) {
            getPresenter().getPart2Text();
        } else if(v.getId() == R.id.btn_test3) {
//            mPart3Module.setVisible(MODULE_VISIABLE);
            mTestHandler.setPart3Visibility();
        } else if(v.getId() == R.id.btn_test4) {
            getPresenter().getPart3Text();
        }
    }

    @Override
    public void test() {

    }

    @Override
    public void onGetText(String str) {
        mTestHandler.onGetText(str);
    }


    @Override
    public void onGetText2(String str) {
        mTestHandler.onGetText2(str);
    }

    @Override
    public void onGetText3(String str) {
        mTestHandler.onGetText3(str);
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void addModule(BaseModule module) {

    }

    @Override
    public void removeModule(BaseModule module) {

    }
}