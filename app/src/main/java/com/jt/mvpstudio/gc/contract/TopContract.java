package com.jt.mvpstudio.gc.contract;

import com.jt.mvpstudio.gc.model.TopEntity;
import com.jt.mvpstudio.gc.view.BaseView;

/**
 * Created by Administrator on 2018/5/30 0030.
 */

public interface TopContract {
    interface Presenter{
        void getTopUrl(String url);
    }

    interface View extends BaseView<Presenter>{

        void setTopEntity(TopEntity topEntity);

        void onShowError();

        void onShowLoading();

        void onHideLoading();

        boolean isActive();
    }
}
