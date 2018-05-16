package wustor.model;

import wustor.view.ViewCallBack;

/**
 * Created by Administrator on 2018/5/14 0014.
 */

public abstract class BaseModelManager {
    protected ViewCallBack mViewCallBack;

    public BaseModelManager(ViewCallBack mCallBack) {
        this.mViewCallBack = mCallBack;
    }

    public abstract void getData();
}
