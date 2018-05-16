package com.jt.mvpstudio.zhy.model;

/**
 * Created by Administrator on 2018/5/11 0011.
 */

public interface IUserBiz {
    void login(String username,String password,OnLoginListener onLoginListener);
}
