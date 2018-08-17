package com.jt.mvpstudio.other.presenters;

import com.jt.mvpstudio.other.models.IWeatherLoadListener;
import com.jt.mvpstudio.other.models.IWeatherModel;
import com.jt.mvpstudio.other.models.WeatherModel;
import com.jt.mvpstudio.other.utils.Api;
import com.jt.mvpstudio.other.utils.WeatherBean;
import com.jt.mvpstudio.other.views.IWeatherView;

/**
 * Created by Administrator on 2018/8/14 0014.
 */

public class WeatherPresenter implements IWeatherPresenter,IWeatherLoadListener {
    private IWeatherModel iWeatherModel;

    private IWeatherView iWeatherView;

    public WeatherPresenter(IWeatherView iWeatherView) {
        this.iWeatherModel = new WeatherModel();
        this.iWeatherView = iWeatherView;
    }

    @Override
    public void loadWeather(String city) {
        iWeatherView.showProgress();
        iWeatherModel.loadWeather(Api.WEATHER_CITY+city,this);
    }

    @Override
    public void onSuccess(WeatherBean bean) {
        iWeatherView.hideProgress();
        iWeatherView.showWeatherData(bean);
    }

    @Override
    public void onFailure(Exception e) {
        iWeatherView.hideProgress();
        iWeatherView.showErrorMsg(e);
    }
}
