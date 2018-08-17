package com.jt.mvpstudio.other.views;

import com.jt.mvpstudio.other.utils.WeatherBean;

/**
 * Created by Administrator on 2018/8/14 0014.
 */

public interface IWeatherView {
    void showProgress();
    void hideProgress();
    void showWeatherData(WeatherBean bean);
    void showErrorMsg(Exception e);
}
