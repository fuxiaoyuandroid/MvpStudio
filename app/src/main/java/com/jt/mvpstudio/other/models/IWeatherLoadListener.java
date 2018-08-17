package com.jt.mvpstudio.other.models;

import com.jt.mvpstudio.other.utils.WeatherBean;

/**
 * Created by Administrator on 2018/8/14 0014.
 */

public interface IWeatherLoadListener {
    void onSuccess(WeatherBean bean);

    void onFailure(Exception e);
}
