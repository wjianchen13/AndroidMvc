package com.example.androidmvc.test1.view;

import android.content.Context;

/**
 * MVP公共接口
 */
public interface ITestBaseView {

    Context getContext();
    void showToast(String str);

}
