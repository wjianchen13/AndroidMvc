package com.example.androidmvc.mvc.controllor;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidmvc.R;
import com.example.androidmvc.mvc.model.OnLoginListener;
import com.example.androidmvc.mvc.model.User;
import com.example.androidmvc.mvc.model.UserBiz;

public class MvcActivity extends AppCompatActivity implements OnLoginListener {

    public static final int TYPE_SUCCESS = 1;
    public static final int TYPE_FAIL = 2;
    
    private EditText edtvName;
    private EditText edtvPassword;
    private TextView tvTip;
    
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            if(msg.what == TYPE_SUCCESS) {
                User user = (User)msg.obj;
                if(user != null) {
                    Toast.makeText(MvcActivity.this, user.getUsername() + "登录成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MvcActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                }
            } else if(msg.what == TYPE_FAIL) {
                Toast.makeText(MvcActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
            }
        }
    };
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        edtvName = findViewById(R.id.edit_username);
        edtvPassword = findViewById(R.id.edit_password);
        tvTip = findViewById(R.id.tv_tip);
        edtvName.setText("lqy");
        edtvPassword.setText("123");
    }
    
    public void onLogin(View v) {
        new UserBiz(tvTip).login(edtvName.getText().toString(), edtvPassword.getText().toString(), this);
    }

    public void onClear(View v) {

    }

    @Override
    public void loginSuccess(User user) {
        if(mHandler != null) {
            Message msg = mHandler.obtainMessage();
            msg.what = TYPE_SUCCESS;
            msg.obj = user;
            mHandler.sendMessage(msg);
        }
    }

    @Override
    public void loginFailed() {
        if(mHandler != null) {
            mHandler.sendEmptyMessage(TYPE_FAIL);
        }
    }
}