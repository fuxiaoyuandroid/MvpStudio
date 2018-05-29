package com.jt.mvpstudio.wustor.view;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jt.mvpstudio.R;

import com.jt.mvpstudio.wustor.presenter.PresenterManager;

public class MvpActivity extends BaseActivity<PresenterManager,String> implements ViewCallBack<String>{
    private TextView show;
    private Button get;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_mvp;
    }




    @Override
    protected void initViews() {
        show = findViewById(R.id.show);
        get = findViewById(R.id.get);
    }

    public void initListener() {
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getData();
            }
        });
    }

    @Override
    protected PresenterManager initPresenter() {
        return new PresenterManager(this);
    }

    @Override
    public void refreshView(int code, String data) {
        show.setText(data);
    }
}
