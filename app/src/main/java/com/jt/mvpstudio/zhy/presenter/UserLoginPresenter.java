package com.jt.mvpstudio.zhy.presenter;

import android.os.Handler;

import com.jt.mvpstudio.zhy.model.IUserBiz;
import com.jt.mvpstudio.zhy.model.OnLoginListener;
import com.jt.mvpstudio.zhy.model.User;
import com.jt.mvpstudio.zhy.model.UserBiz;
import com.jt.mvpstudio.zhy.view.IUserLoginView;

/**
 * Created by Administrator on 2018/5/11 0011.
 */

public class UserLoginPresenter {
    private IUserBiz iUserBiz;
    private IUserLoginView iUserLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView iUserLoginView) {
        this.iUserLoginView = iUserLoginView;
        iUserBiz = new UserBiz();
    }

    public void login(){
        iUserBiz.login(iUserLoginView.getUsername(), iUserLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserLoginView.toLoginSuccess(user);
                    }
                });
            }

            @Override
            public void loginFail() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserLoginView.toShowFail();
                    }
                });
            }
        });
    }

    public void clear(){
        iUserLoginView.clearUsername();
        iUserLoginView.clearPassword();
    }
}
