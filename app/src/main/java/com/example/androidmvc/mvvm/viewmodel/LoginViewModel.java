package com.example.androidmvc.mvvm.viewmodel;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.example.androidmvc.mvvm.model.User;
import com.example.androidmvc.mvvm.view.MvvmActivity;

/**
 * Created by liang on 2016/8/23.
 */
public class LoginViewModel implements ViewModel {
    private Context context;
    //用于数据刷新的便捷类型：ObservableField，ObservableInt····
    public ObservableField<String> loginMessage;
    public ObservableInt loginMessageVisibility;
    private String editTextUsernameValue = "";
    private String editTextPasswordValue = "";

    public LoginViewModel(Context context) {
        this.context = context;
        this.loginMessage = new ObservableField<>("");
        this.loginMessageVisibility = new ObservableInt(View.INVISIBLE);
        editTextUsernameValue = "lqy";
        editTextPasswordValue = "123";
    }

    //登陆，实际上这个方法是在layout文件中调用的

    public void loginAuthentication(View view) {
        if ((editTextUsernameValue.equals("lqy")) && (editTextPasswordValue.equals("123"))) {
            loginMessage.set("");
            loginMessageVisibility.set(View.INVISIBLE);
            User user = new User(editTextUsernameValue, editTextPasswordValue);
            context.startActivity(MvvmActivity.newIntent(context, user));
        } else if ((editTextUsernameValue.equals("")) || (editTextPasswordValue.equals(""))) {
            loginMessage.set("Username or Password can't be empty!");
            loginMessageVisibility.set(View.VISIBLE);
        } else {
            loginMessage.set("Username = lqy Password = 123");
                    loginMessageVisibility.set(View.VISIBLE);
        }
    }

    //观察Text变化的TextWatcher
    public TextWatcher getUsernameUpdate() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editTextUsernameValue = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
    }

    public TextWatcher getPasswordUpdate() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editTextPasswordValue = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
    }


    @Override
    public void destroy() {

    }
}