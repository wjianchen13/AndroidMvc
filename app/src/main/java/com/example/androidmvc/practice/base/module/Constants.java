package com.example.androidmvc.practice.base.module;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 */
public class Constants {

    public static final int MODULE_INIT = 1;
    public static final int MODULE_VISIABLE = 2;
    public static final int MODULE_IN_VISIABLE = 3;

    @IntDef({MODULE_INIT
            , MODULE_VISIABLE
            , MODULE_IN_VISIABLE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AnimEnum {

    }

    public class PayType {
        public static final int PAY_TYPE_GOOGLE = 1;
        public static final int PAY_TYPE_THIRD = 2;
        public static final int PAY_TYPE_COIN = 3;
    }

}
