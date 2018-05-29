package com.jt.mvpstudio.wustor.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jt.mvpstudio.wustor.presenter.BasePresenterManager;

/**
 * Created by Administrator on 2018/5/15 0015.
 */

public abstract class BaseActivity<T extends BasePresenterManager,V> extends AppCompatActivity implements ViewCallBack<V> {
    public T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mPresenter = initPresenter();
        initViews();
        initListener();
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter == null) {
            mPresenter = initPresenter();
        }
        mPresenter.add((ViewCallBack) this);

    }

    protected abstract void initViews();

    protected abstract void initListener();//初始化监听事件

    protected abstract T initPresenter(); //初始化Presenter

    protected abstract int getLayoutId();


    @Override
    protected void onDestroy() {
        if (mPresenter == null){
            mPresenter.remove();
            mPresenter = null;
        }
        super.onDestroy();
    }
}
