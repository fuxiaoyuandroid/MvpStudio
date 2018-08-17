package com.jt.mvpstudio.other.models;

/**
 * Created by Administrator on 2018/8/17 0017.
 */

public interface IBookModel {
    void loadBook(String name,IBookLoadListener listener);
}
