
package com.example.androidmvc.practice.test_fragment.model;

import com.example.androidmvc.mvp.model.bean.User;
import com.example.androidmvc.mvp.model.biz.IUserBiz;
import com.example.androidmvc.mvp.model.biz.OnLoginListener;

/**
 * Created by liang on 2016/8/22.
 */
public class TestFragmentModel implements IUserBiz {
    //在这里重写IUserBiz中的方法
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        //注意，这里并没有new OnLoginListener的对象，所以也没有重写方法
        //要留在UserLoginPresenter中重写，并通过登陆的状态调用相应的视图
        new Thread(){
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                //模拟登陆成功
                if("lqy".equals(username)&&"123".equals(password)){
                    User user=new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                }else{
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}