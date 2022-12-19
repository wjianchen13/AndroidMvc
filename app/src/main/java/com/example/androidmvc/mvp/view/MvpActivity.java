package com.example.androidmvc.mvp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidmvc.R;
import com.example.androidmvc.mvp.model.bean.User;
import com.example.androidmvc.mvp.presenter.UserLoginPresenter;


public class MvpActivity extends AppCompatActivity implements IUserLoginView{

    private EditText username_edit,password_edit;
    private Button login_btn,clear_btn;
    private ProgressBar loading;

    private UserLoginPresenter userLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);

        initViews();
        username_edit.setText("lqy");
        password_edit.setText("123");
    }

    private void initViews(){
        username_edit =(EditText)findViewById(R.id.edit_username);
        password_edit=(EditText)findViewById(R.id.edit_password);

        login_btn=(Button)findViewById(R.id.login);
        clear_btn=(Button)findViewById(R.id.clear);

        loading=(ProgressBar)findViewById(R.id.login_progressbar);
        loading.setVisibility(View.INVISIBLE);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLoginPresenter.login();
            }
        });

        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLoginPresenter.clear();
            }
        });

    }

    @Override
    public String getUserName() {
        return username_edit.getText().toString();
    }

    @Override
    public String getPassword() {
        return password_edit.getText().toString();
    }

    @Override
    public void clearUserName() {
        username_edit.setText("");
    }

    @Override
    public void clearPassword() {
        password_edit.setText("");
    }

    @Override
    public void showLoading() {
        loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this,user.getUsername()+" login success , to MvvmActivity",Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show();
    }
}