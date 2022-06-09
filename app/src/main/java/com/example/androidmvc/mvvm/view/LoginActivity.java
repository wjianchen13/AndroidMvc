package com.example.androidmvc.mvvm.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.androidmvc.R;
import com.example.androidmvc.databinding.ActivityLoginBinding;
import com.example.androidmvc.mvvm.viewmodel.LoginViewModel;

/**
 * Created by liang on 2016/8/23.
 */
public class LoginActivity extends AppCompatActivity {
    //当给布局指定格式之后会产生相应的Bing类，例如activity_login.xml会产生ActivityLoginBinding类
    ActivityLoginBinding loginBinding;
    LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //指定布局，没有XXX.findViewById了
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        viewModel = new LoginViewModel(this);
        loginBinding.setViewmodel(viewModel);
        loginBinding.loginUsername.setText("lqy");
        loginBinding.loginPassword.setText("123");
    }
}