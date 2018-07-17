package com.oasis.bookish;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Book {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "bID")
    private int bookId;

    @ColumnInfo(name = "genre")
    private String genre;

    @ColumnInfo(name = "Bookname")
    private String bookName;

    //Constructor


    public Book(String genre, String bookName) {
        this.genre = genre;
        this.bookName = bookName;
    }

    @NonNull
    public int getBookId() {
        return bookId;
    }

    public void setBookId(@NonNull int bookId) {
        this.bookId = bookId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
