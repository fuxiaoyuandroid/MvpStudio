package com.jt.mvpstudio.zhy.view;

import com.jt.mvpstudio.zhy.model.User;

/**
 * Created by Administrator on 2018/5/11 0011.
 */

public interface IUserLoginView {
    String getUsername();

    String getPassword();

    void clearUsername();

    void clearPassword();

    void toLoginSuccess(User user);

    void toShowFail();
}
