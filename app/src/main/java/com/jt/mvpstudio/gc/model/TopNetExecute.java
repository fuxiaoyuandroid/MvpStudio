package com.jt.mvpstudio.gc.model;

/**
 * Created by Administrator on 2018/5/30 0030.
 * 获取头条数据
 */

public interface TopNetExecute<T> {

    void execute(T data,TopNetCallBack callBack);

}
