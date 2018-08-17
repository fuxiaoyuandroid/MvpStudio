package com.jt.mvpstudio.other.models;

import com.jt.mvpstudio.other.utils.OkHttpUtil;
import com.jt.mvpstudio.other.utils.WeatherBean;

/**
 * Created by Administrator on 2018/8/14 0014.
 */

public class WeatherModel implements IWeatherModel {
    @Override
    public void loadWeather(String url, final IWeatherLoadListener loadListener) {
        OkHttpUtil.ResultCallback resultCallback = new OkHttpUtil.ResultCallback() {
            @Override
            public void getWeather(WeatherBean weatherBean) {
                loadListener.onSuccess(weatherBean);
            }

            @Override
            public void onFailure(Exception e) {
                loadListener.onFailure(e);
            }
        };

        OkHttpUtil.getResultCallback(url,resultCallback);
    }
}
