package com.example.androidmvc.mvvm.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.androidmvc.R;
import com.example.androidmvc.databinding.ActivityMvvmBinding;
import com.example.androidmvc.mvvm.model.User;
import com.example.androidmvc.mvvm.viewmodel.MainViewModel;

/**
 * Created by liang on 2016/8/23.
 */
public class MvvmActivity extends AppCompatActivity {
    ActivityMvvmBinding activityMvvmBinding;
    MainViewModel mainViewModel;

    //传递数据的标志
    private static final String EXTRA_USER = "extra_user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMvvmBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);


        User user=getIntent().getParcelableExtra(EXTRA_USER);
//        DataBindingUtil.inflate()
        mainViewModel = new MainViewModel(this,user);
        activityMvvmBinding.setMainviewmodel(mainViewModel);
    }

    //viewmodel唤醒这个Activity的方法
    public static Intent newIntent(Context context, User user){
        Intent intent = new Intent(context, MvvmActivity.class);
        intent.putExtra(EXTRA_USER,user);
        return intent;
    }
}