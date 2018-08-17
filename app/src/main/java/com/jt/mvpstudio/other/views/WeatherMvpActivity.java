package com.jt.mvpstudio.other.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jt.mvpstudio.R;
import com.jt.mvpstudio.other.presenters.BookPresenter;
import com.jt.mvpstudio.other.presenters.WeatherPresenter;
import com.jt.mvpstudio.other.utils.BookBean;
import com.jt.mvpstudio.other.utils.WeatherBean;

/**
 * 参考别人的简书写的  https://www.jianshu.com/p/80e9a6c88ac8
 */
public class WeatherMvpActivity extends AppCompatActivity implements IWeatherView,IBookView,View.OnClickListener {
    private TextView jn_tv,book_tv;
    private WeatherPresenter weatherPresenter;
    private BookPresenter bookPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_mvp);
        jn_tv = findViewById(R.id.jn_tv);
        jn_tv.setOnClickListener(this);

        book_tv = findViewById(R.id.bk_tv);
        book_tv.setOnClickListener(this);
        weatherPresenter = new WeatherPresenter(this);
        bookPresenter = new BookPresenter(this);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showWeatherData(final WeatherBean bean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                jn_tv.setText(bean.getCity()+""+bean.getDate()+"..."+bean.getData().getForecast().get(0).getType().toString());
            }
        });
    }

    @Override
    public void showErrorMsg(Exception e) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.jn_tv:
                weatherPresenter.loadWeather("济南");
                break;
            case R.id.bk_tv:
                bookPresenter.loadBook("水浒传");
                break;
        }
    }

    @Override
    public void showBook(final BookBean bean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                book_tv.setText(String.valueOf(bean.getCount()));
            }
        });
    }
}
