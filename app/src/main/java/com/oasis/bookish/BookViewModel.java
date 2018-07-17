package com.oasis.bookish;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class BookViewModel extends AndroidViewModel {

    private BookRepository mRepository;

    private LiveData<List<Book>> mAllBooks;

    public BookViewModel(Application application) {
        super(application);
        mRepository = new BookRepository(application);
        mAllBooks = mRepository.getAllBooks();
    }


    //Getter for all the words

    LiveData<List<Book>> getmAllBooks(){
        return mAllBooks;
    }

    public void insert(Book book) {
        mRepository.insertBook(book);
    }
}
