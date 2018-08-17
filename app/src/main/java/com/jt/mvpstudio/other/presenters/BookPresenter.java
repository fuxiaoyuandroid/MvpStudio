package com.jt.mvpstudio.other.presenters;

import com.jt.mvpstudio.other.models.BookModel;
import com.jt.mvpstudio.other.models.IBookLoadListener;
import com.jt.mvpstudio.other.models.IBookModel;
import com.jt.mvpstudio.other.utils.BookBean;
import com.jt.mvpstudio.other.views.IBookView;

/**
 * Created by Administrator on 2018/8/17 0017.
 */

public class BookPresenter implements IBookPresenter,IBookLoadListener{
    private IBookModel iBookModel;

    private IBookView iBookView;

    public BookPresenter(IBookView bookView) {
        this.iBookView = bookView;
        iBookModel = new BookModel();
    }

    @Override
    public void loadBook(String name) {
        iBookModel.loadBook(name,this);
    }

    @Override
    public void onSuccess(BookBean bookBean) {
        iBookView.showBook(bookBean);
    }

    @Override
    public void onError(Throwable t) {

    }
}
