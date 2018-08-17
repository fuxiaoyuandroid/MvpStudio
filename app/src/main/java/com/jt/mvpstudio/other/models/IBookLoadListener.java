package com.jt.mvpstudio.other.models;

import com.jt.mvpstudio.other.utils.BookBean;

/**
 * Created by Administrator on 2018/8/17 0017.
 */

public interface IBookLoadListener {
    void onSuccess(BookBean bookBean);

    void onError(Throwable t);
}
