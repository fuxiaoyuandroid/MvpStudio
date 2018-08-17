package com.jt.mvpstudio.other.utils;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018/8/17 0017.
 */

public interface RetrofitService {
    /**
     * "https://www.sojson.com/open/api/weather/json.shtml?city="
     * @param city
     * @return
     */
    @GET("open/api/weather/json.shtml")
    Call<WeatherBean> getWeather(@Query("city") String city);

    /**
     * https://api.douban.com/v2/book/search?q=
     * @param name
     * @return
     */
    @GET("book/search")
    Call<BookBean> getBook(@Query("q") String name);
}
