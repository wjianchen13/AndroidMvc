package com.example.androidmvc.common.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.CallSuper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.example.androidmvc.common.presenter.BaseMvpPresenter;

import java.lang.ref.WeakReference;

/**
 * 公共列表显示数据
 */
public abstract class BaseMvpActivity<P extends BaseMvpPresenter> extends AppCompatActivity implements IBaseMvpView, View.OnClickListener {

    protected P mPresenter;

    protected abstract P createPresenter();

    private MessageQueue.IdleHandler mIdleHandler = null;
    private CustomHandler handler = null;
    private Runnable mIdleBackupRunnable;

    private Runnable mLongPressRunnable;

    private boolean isIdleCalled;

    private long idleCalledTime;


    private static class CustomHandler extends Handler {
        private final WeakReference<FragmentActivity> mActivity;

        public CustomHandler(FragmentActivity activity) {
            mActivity = new WeakReference<>(activity);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();


        /**
         * 所有生命周期结束的空闲回调，有可能不回调
         */
        Looper.myQueue().addIdleHandler(mIdleHandler = new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {
                mIdleHandler = null;
                if (handler != null && mIdleBackupRunnable != null){
                    handler.removeCallbacks(mIdleBackupRunnable);
                    mIdleBackupRunnable = null;
                }
                isIdleCalled = true;
                idleCalledTime = SystemClock.elapsedRealtime();
                BaseMvpActivity.this.queueIdle(savedInstanceState, getIntent(), getLayoutInflater());
                // 仅执行一次
                return false;
            }
        });

        handler = new CustomHandler(this);
        /**
         * 以防addIdleHandler不会执行
         */
        handler.postDelayed(mIdleBackupRunnable = new Runnable() {
            @Override
            public void run() {
                mIdleBackupRunnable = null;
                if (mIdleHandler != null) {
                    Looper.myQueue().removeIdleHandler(mIdleHandler);
                    mIdleHandler = null;
                }
                isIdleCalled = true;
                idleCalledTime = SystemClock.elapsedRealtime();
                // 后备调用
                queueIdle(savedInstanceState, getIntent(), getLayoutInflater());
            }
        }, 1500);

    }

    @CallSuper
    public boolean queueIdle(Bundle savedInstanceState, Intent intent, LayoutInflater inflater) {
        // 这里入场动画已经执行完毕
        mPresenter.queueIdle(savedInstanceState, intent, inflater);
        return false;
    }

    @Override
    public P getPresenter() {
        return mPresenter;
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void onClick(View view) {

    }
}