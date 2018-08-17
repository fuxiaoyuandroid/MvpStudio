package com.jt.mvpstudio.other.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/8/17 0017.
 */

public class RetrofitHelper {

    private static OkHttpClient mOkHttpClient;

    private RetrofitService mRetrofitService;

    public RetrofitHelper(String ip) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ip)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mRetrofitService = retrofit.create(RetrofitService.class);
    }

    public OkHttpClient getOkHttpClient(){
        if (mOkHttpClient == null){
            mOkHttpClient = new OkHttpClient.Builder()
                    .retryOnConnectionFailure(true)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build();
        }
        return mOkHttpClient;
    }


    public Call<WeatherBean> getWeather(String city){

        return mRetrofitService.getWeather(city);
    }


    public Call<BookBean> getBook(String book){
        return mRetrofitService.getBook(book);
    }
}
