package wustor.presenter;

import wustor.model.BaseModelManager;
import wustor.view.ViewCallBack;

/**
 * Created by Administrator on 2018/5/15 0015.
 */

public abstract class BasePresenterManager {
    protected BaseModelManager mModelManager;
    protected ViewCallBack mViewCallBack;

    public BasePresenterManager(ViewCallBack viewCallBack) {
        this.mViewCallBack = viewCallBack;
    }

    public void add(ViewCallBack viewCallBack){
        this.mViewCallBack = viewCallBack;
    }

    public void remove(){
        this.mViewCallBack = null;
    }

    public abstract void getData();
}
