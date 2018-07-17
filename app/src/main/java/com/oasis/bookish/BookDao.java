package com.oasis.bookish;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface BookDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertBook (Book book);

    @Query("SELECT * FROM Book ORDER BY Bookname ASC")
    LiveData<List<Book>> getAllBooks();

    @Delete
    void delete(Book book);

    @Update
    void updateBook(Book book);
}
