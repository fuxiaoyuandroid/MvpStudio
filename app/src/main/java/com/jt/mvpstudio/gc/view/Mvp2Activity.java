package com.jt.mvpstudio.gc.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jt.mvpstudio.R;
import com.jt.mvpstudio.gc.model.TopEntityImpl;
import com.jt.mvpstudio.gc.presenter.TopPresenter;
import com.jt.mvpstudio.gc.utils.ActivityUtils;

public class Mvp2Activity extends AppCompatActivity {
    //当前页面Presenter
    private TopPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp2);
        //当前页面Model
        TopEntityImpl topEntity = TopEntityImpl.getInstance();
        //创建Fragment
        TopFragment topFragment = (TopFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if (topFragment == null){
            topFragment = TopFragment.getInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),topFragment,R.id.contentFrame);
        }
        //将Model和View传给Presenter
        presenter = new TopPresenter(topFragment,topEntity);
        //绑定当前页面的Presenter
        topFragment.setPresenter(presenter);
    }


}
