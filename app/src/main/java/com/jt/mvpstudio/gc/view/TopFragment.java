package com.jt.mvpstudio.gc.view;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jt.mvpstudio.R;
import com.jt.mvpstudio.gc.contract.TopContract;
import com.jt.mvpstudio.gc.model.TopEntity;
import com.jt.mvpstudio.gc.presenter.TopPresenter;

/**
 * A simple {@link Fragment} subclass.
 * 新闻-头条Fragment
 */
public class TopFragment extends Fragment implements TopContract.View{
    private Button top_get_btn;
    private TextView top_show_tv;
    private TopContract.Presenter topPresenter;
    private ProgressDialog mProgressDialog;
    private static final String URL = "http://v.juhe.cn/toutiao/index?type=top&key=907b839d342a91c3206e04f793078752";

    public TopFragment() {

    }

    public static TopFragment getInstance(){
        return new TopFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View topView = inflater.inflate(R.layout.fragment_top, container, false);
        top_get_btn = topView.findViewById(R.id.top_get_btn);
        top_show_tv = topView.findViewById(R.id.top_show_tv);
        return topView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setTitle("获取数据中......");
        top_get_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topPresenter.getTopUrl(URL);
            }
        });
    }

    @Override
    public void setPresenter(TopContract.Presenter presenter) {
        topPresenter = presenter;
    }

    @Override
    public void setTopEntity(TopEntity topEntity) {
        top_show_tv.setText(topEntity.getResult().getData().get(3).getTitle());
    }

    @Override
    public void onShowError() {
        Toast.makeText(getActivity(), "网络出错", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onShowLoading() {
        mProgressDialog.show();
    }

    @Override
    public void onHideLoading() {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }
}
