package com.example.androidmvc.practice.base.view;

import com.example.androidmvc.practice.base.module.BaseModule;

/**
 * 使用对象：Fragment Activity
 */
public interface IBaseTargetView {

    void addModule(BaseModule module);
    void removeModule(BaseModule module);

}
