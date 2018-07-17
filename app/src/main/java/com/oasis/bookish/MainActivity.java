package com.oasis.bookish;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    private EditText BookName;
    private  EditText Genre;
    private BookViewModel mBookViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Recycler view
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final BookListAdapter adapter = new BookListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //ViewModel
        mBookViewModel = ViewModelProviders.of(this).get(BookViewModel.class);

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        mBookViewModel.getmAllBooks().observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(@Nullable List<Book> books) {
                adapter.setBooks(books);
            }
        });


        // Instantiate
        BookName = findViewById(R.id.etBookName);
        Genre = findViewById(R.id.etGenre);
        final Button button = findViewById(R.id.submitBook);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(BookName.getText()) || !TextUtils.isEmpty(Genre.getText())){

                    final Book book= new Book(Genre.getText().toString(),BookName.getText().toString());
                    mBookViewModel.insert(book);

                }
                else{
                    Toast.makeText(getApplicationContext(),"Please Enter a book and Genre.",Toast.LENGTH_LONG).show();
                }

            }
        });







    }


}
