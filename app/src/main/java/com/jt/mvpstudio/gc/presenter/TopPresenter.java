package com.jt.mvpstudio.gc.presenter;

import com.jt.mvpstudio.gc.contract.TopContract;
import com.jt.mvpstudio.gc.model.TopEntity;
import com.jt.mvpstudio.gc.model.TopNetCallBack;
import com.jt.mvpstudio.gc.model.TopNetExecute;

/**
 * Created by Administrator on 2018/5/30 0030.
 * 含有View 和  Model的实例  并且实现了网络回调接口
 */

public class TopPresenter implements TopContract.Presenter,TopNetCallBack<TopEntity>{
    private TopContract.View mView;

    private TopNetExecute mTopNetExecute;

    public TopPresenter(TopContract.View view, TopNetExecute topNetExecute) {
        this.mView = view;
        this.mTopNetExecute = topNetExecute;
    }

    @Override
    public void onSuccess(TopEntity data) {
        if (mView.isActive()){
            mView.setTopEntity(data);
        }
    }

    @Override
    public void onFail(String error) {
        if (mView.isActive()){
            mView.onShowError();
            mView.onHideLoading();
        }
    }

    @Override
    public void onStart() {
        if (mView.isActive()){
            mView.onShowLoading();
        }
    }

    @Override
    public void onEnd() {
        if (mView.isActive()){
            mView.onHideLoading();
        }
    }

    @Override
    public void getTopUrl(String url) {
        //获取数据
        mTopNetExecute.execute(url,this);
    }
}
