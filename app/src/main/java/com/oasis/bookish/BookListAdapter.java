package com.oasis.bookish;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class BookListAdapter  extends RecyclerView.Adapter<BookListAdapter.MyviewHolder> {

    Context mContext;

    private List<Book> mBooks; // Cached copy of words

    public BookListAdapter(MainActivity mainActivity) {
    }


    class MyviewHolder extends RecyclerView.ViewHolder{
        private final TextView bookName;
        private final TextView bookGenre;

        private MyviewHolder(View itemView) {
            super(itemView);
            bookName = itemView.findViewById(R.id.tvBookname);
            bookGenre = itemView.findViewById(R.id.tvGenre);
        }
    }

    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {

        if(mBooks != null) {
            Book current = mBooks.get(position);
            holder.bookGenre.setText(current.getGenre());
            holder.bookName.setText(current.getBookName());

        }
        else{
            // Covers the case of data not being ready yet.
            holder.bookName.setText("Please Wait");
            holder.bookGenre.setText("Please Wait!");
        }


    }

    void setBooks(List<Book> books){
        mBooks = books;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {

        if (mBooks != null)
            return mBooks.size();
       else return 0;
    }






}
