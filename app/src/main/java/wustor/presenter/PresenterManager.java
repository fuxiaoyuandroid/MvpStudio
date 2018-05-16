package wustor.presenter;


import wustor.model.ModelManager;
import wustor.view.ViewCallBack;

/**
 * Created by Administrator on 2018/5/11 0011.
 * P层代码的方法跟Manager对应，
 * 然后处理M层跟V层的Callback即可，
 * 但是注意Presenter是一个对象，
 * 需要在界面销毁的时候置空，防止内存泄露
 */

public class PresenterManager extends BasePresenterManager{

    public PresenterManager(ViewCallBack viewCallBack) {
        super(viewCallBack);
    }

    @Override
    public void getData() {
        mModelManager = new ModelManager(mViewCallBack);
        mModelManager.getData();
    }
}
