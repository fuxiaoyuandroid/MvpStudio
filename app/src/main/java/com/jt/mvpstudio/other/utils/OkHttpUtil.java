package com.jt.mvpstudio.other.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/8/14 0014.
 */

public class OkHttpUtil {
    String responseResult = null;
    public static OkHttpUtil mOkHttpUtil;

    private OkHttpUtil(){

    }

    private static synchronized OkHttpUtil getInstance(){
        if (mOkHttpUtil == null){
            synchronized (OkHttpUtil.class){
                if (mOkHttpUtil == null){
                    mOkHttpUtil = new OkHttpUtil();
                }
            }
        }
        return mOkHttpUtil;
    }

    public static void getResultCallback(String url,ResultCallback resultCallback){
        getInstance().sendRequest(url,resultCallback);
    }



    public void sendRequest(String url, final ResultCallback resultCallback){
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(2, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (resultCallback != null){
                    resultCallback.onFailure(e);
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                responseResult = response.body().string();
                WeatherBean bean = JsonUtil.jsonWeather(responseResult);
                if (resultCallback != null){
                    resultCallback.getWeather(bean);
                }
            }
        });
    }

    public interface ResultCallback{

        void getWeather(WeatherBean weatherBean);

        void onFailure(Exception e);

    }
}
