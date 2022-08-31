package com.example.androidmvc.mvc.model;

import android.widget.TextView;

/**
 * Created by liang on 2016/8/22.
 */
public class UserBiz {
    
    private TextView tvTip;
    
    public UserBiz(TextView tv) {
        this.tvTip = tv;
    }

    public void login(final String username,final String password,final OnLoginListener
            
            loginListener){
        
        new Thread() {
            @Override
            public void run() {
                if(tvTip != null)
                    tvTip.setText("正在登陆");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                //模拟登陆
                if("lqy".equals(username)&&"123".equals(password)){
                    if(tvTip != null)
                        tvTip.setText("登陆成功");
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                } else {
                    loginListener.loginFailed();
                }
            }
        }.start();

    }
}