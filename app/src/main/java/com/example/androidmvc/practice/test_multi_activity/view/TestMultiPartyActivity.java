package com.example.androidmvc.practice.test_multi_activity.view;

import static com.example.androidmvc.practice.base.module.Constants.MODULE_VISIABLE;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidmvc.R;
import com.example.androidmvc.practice.base.view.BaseMultiPartMvpActivity;
import com.example.androidmvc.practice.test_multi_activity.modules.ActivityPart1Module;
import com.example.androidmvc.practice.test_multi_activity.modules.ActivityPart2Module;
import com.example.androidmvc.practice.test_multi_activity.modules.ActivityPart3Module;
import com.example.androidmvc.practice.test_multi_activity.presenter.TestMultiPartMvpActivityPresenter;

public class TestMultiPartyActivity extends BaseMultiPartMvpActivity<ITestMultiPartMvpActivityView, TestMultiPartMvpActivityPresenter> implements ITestMultiPartMvpActivityView, View.OnClickListener {

    public static final String TAG = TestMultiPartyActivity.class.getSimpleName();

    private String LOG = "=============================> ";

    private View mRootView;
    private Button btnTest1;
    private Button btnTest2;
    private Button btnTest3;
    private Button btnTest4;

    private ActivityPart1Module mPart1Module;
    private ActivityPart2Module mPart2Module;
    private ActivityPart3Module mPart3Module;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_multi_part);
        initView();
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
    protected TestMultiPartMvpActivityPresenter initPresenter() {
        return new TestMultiPartMvpActivityPresenter(this);
    }

    private void initModules() {
        mPart1Module = new ActivityPart1Module(this, getPresenter(), mRootView);
        mPart1Module.init();
        mPart2Module = new ActivityPart2Module(this, getPresenter(), mRootView);
        mPart2Module.init();
        mPart3Module = new ActivityPart3Module(this, getPresenter(), mRootView);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_test1) {
            getPresenter().getPart1Text();
        } else if(v.getId() == R.id.btn_test2) {
            getPresenter().getPart2Text();
        } else if(v.getId() == R.id.btn_test3) {
            mPart3Module.setVisible(MODULE_VISIABLE);
        } else if(v.getId() == R.id.btn_test4) {
            getPresenter().getPart3Text();
        }
    }

    @Override
    public void test() {

    }

    @Override
    public void onGetText(String str) {
        mPart1Module.onGetText(str);
    }


    @Override
    public void onGetText2(String str) {
        mPart2Module.onGetText2(str);
    }

    @Override
    public void onGetText3(String str) {
        mPart3Module.onGetText3(str);
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
}