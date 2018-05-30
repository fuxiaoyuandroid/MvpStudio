package com.jt.mvpstudio.gc.model;

/**
 * Created by Administrator on 2018/5/30 0030.
 * 头条数据网络回调接口
 */

public interface TopNetCallBack<T> {

    void onSuccess(T data);//回调成功

    void onFail(String error);//回调失败

    void onStart();//开始

    void onEnd();//结束

}
