package com.jt.mvpstudio.other.models;

/**
 * Created by Administrator on 2018/8/14 0014.
 */

public interface IWeatherModel {
    void loadWeather(String url,IWeatherLoadListener loadListener);
}
