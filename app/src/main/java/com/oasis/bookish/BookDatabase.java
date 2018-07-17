package com.oasis.bookish;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Book.class},version = 1,exportSchema = false)
public abstract class BookDatabase extends RoomDatabase{
    public abstract BookDao bookDao();

    private static BookDatabase INSTANCE;

    static BookDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BookDatabase.class) {
                if (INSTANCE == null) {
                    //Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BookDatabase.class, "book_database").build();
                }
            }
        }
        return INSTANCE;
    }

}
