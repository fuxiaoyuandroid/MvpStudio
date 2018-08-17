package com.jt.mvpstudio.other.utils;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2018/8/14 0014.
 */

public class JsonUtil {
    public static WeatherBean jsonWeather(String result){
        Gson gson = new Gson();
        WeatherBean weatherBean = gson.fromJson(result,WeatherBean.class);
        return weatherBean;
    }
}
