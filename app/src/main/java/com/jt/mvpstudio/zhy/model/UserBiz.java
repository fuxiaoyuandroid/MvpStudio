package com.jt.mvpstudio.zhy.model;

/**
 * Created by Administrator on 2018/5/11 0011.
 */

public class UserBiz implements IUserBiz {
    @Override
    public void login(final String username, final String password, final OnLoginListener onLoginListener) {
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                if ("fxy".equals(username) && "123".equals(password)){
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    onLoginListener.loginSuccess(user);
                }else {
                    onLoginListener.loginFail();
                }
            }
        }.start();
    }
}
