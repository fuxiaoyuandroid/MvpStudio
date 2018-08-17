package com.jt.mvpstudio.other.models;

import com.jt.mvpstudio.other.utils.Api;
import com.jt.mvpstudio.other.utils.BookBean;
import com.jt.mvpstudio.other.utils.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/8/17 0017.
 */

public class BookModel implements IBookModel{
    @Override
    public void loadBook(String name, final IBookLoadListener listener) {
        RetrofitHelper retrofitHelper = new RetrofitHelper(Api.BOOK_NAME);

        retrofitHelper.getBook(name).enqueue(new Callback<BookBean>() {
            @Override
            public void onResponse(Call<BookBean> call, Response<BookBean> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<BookBean> call, Throwable t) {
                listener.onError(t);
            }
        });
    }
}
