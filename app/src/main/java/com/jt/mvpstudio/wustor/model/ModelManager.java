package com.jt.mvpstudio.wustor.model;

import com.jt.mvpstudio.wustor.view.ViewCallBack;

/**
 * Created by Administrator on 2018/5/11 0011.
 * 这里面只是写了一个模板，
 * 可能一个界面需要多种数据处理方式，
 * 那么就根据需求在重新定义几个方法即可
 */

public class ModelManager extends BaseModelManager{


    public ModelManager(ViewCallBack mCallBack) {
        super(mCallBack);
    }

    @Override
    public void getData() {
        mViewCallBack.refreshView(1,"RNGFighters!");
    }
}
