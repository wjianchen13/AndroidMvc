package com.example.androidmvc.test1.view;

import com.example.androidmvc.test1.module.BaseModule;

/**
 * 使用对象：Fragment Activity
 */
public interface ITargetView {

    void addModule(BaseModule module);
    void removeModule(BaseModule module);

}
