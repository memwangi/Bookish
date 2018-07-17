package com.oasis.bookish;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class BookRepository {

    private BookDao mBookDao;
    private LiveData<List<Book>> mAllBooks;


    //Constructor

    public BookRepository(Application application) {
        BookDatabase db = BookDatabase.getDatabase(application);
        this.mBookDao = mBookDao;
        this.mAllBooks = mAllBooks;
    }

    //Wrapper for getAllBooks
    LiveData<List<Book>> getAllBooks() {

        return mAllBooks;
    }

    //Wrapper for insert
    public void insertBook (Book book){
        new insertAsyncTask(mBookDao).execute(book);
    }

    //Insert Task

    private static class insertAsyncTask extends AsyncTask<Book, Void, Void> {

        private BookDao mAsyncTaskDao;

        insertAsyncTask(BookDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Book... params) {
            mAsyncTaskDao.insertBook(params[0]);
            return null;
        }
    }

}
