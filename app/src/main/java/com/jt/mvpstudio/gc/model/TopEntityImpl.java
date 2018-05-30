package com.jt.mvpstudio.gc.model;

import cn.finalteam.okhttpfinal.BaseHttpRequestCallback;
import cn.finalteam.okhttpfinal.HttpRequest;

/**
 * Created by Administrator on 2018/5/30 0030.
 * 头条数据实现类
 */

public class TopEntityImpl implements TopNetExecute<String> {
    public static volatile TopEntityImpl mTopEntityImpl;
    public TopEntityImpl() {
    }

    /**
     * 单类
     * @return
     */
    public static TopEntityImpl getInstance(){
        if (mTopEntityImpl == null){
            synchronized (TopEntityImpl.class){
                if (mTopEntityImpl == null){
                    mTopEntityImpl = new TopEntityImpl();
                }
            }
        }
        return mTopEntityImpl;
    }

    @Override
    public void execute(String url, final TopNetCallBack callBack) {
        HttpRequest.get(url, new BaseHttpRequestCallback<TopEntity>(){

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            protected void onSuccess(TopEntity topEntity) {
                super.onSuccess(topEntity);
                callBack.onSuccess(topEntity);
            }

            @Override
            public void onFailure(int errorCode, String msg) {
                super.onFailure(errorCode, msg);
                callBack.onFail(msg);
            }

            @Override
            public void onFinish() {
                super.onFinish();
                callBack.onEnd();
            }
        });
    }

}
