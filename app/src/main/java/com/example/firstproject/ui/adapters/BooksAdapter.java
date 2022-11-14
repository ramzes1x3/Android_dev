package com.example.firstproject.ui.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import com.example.firstproject.R;
import com.example.firstproject.db.Book;

import java.util.List;

public class BooksAdapter extends
		RecyclerView.Adapter<BooksAdapter.BooksViewHolder> {

	Context context;
	List<Book> bookList;

	public static class BooksViewHolder extends RecyclerView.ViewHolder {
		public TextView bookName, bookInfo;
		public View book;

		public BooksViewHolder(View itemView) {
			super(itemView);

			bookName = itemView.findViewById(R.id.book_name);
			bookInfo = itemView.findViewById(R.id.about_book);
			book = itemView.findViewById(R.id.book_card);
		}
	}

	public BooksAdapter(Context context, List<Book> bookList) {
		this.context = context;
		this.bookList = bookList;
	}

	@Override
	public BooksAdapter.BooksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		LayoutInflater inflater = LayoutInflater.from(context);
		View view = inflater.inflate(R.layout.item_book, parent, false);

		BooksViewHolder vh = new BooksAdapter.BooksViewHolder(view);
		return vh;
	}

	@Override
	public void onBindViewHolder(BooksViewHolder holder, int position) {
		Book book = (bookList.get(position));
		holder.bookName.setText(bookList.get(position).nameBook);
		holder.bookInfo.setText(bookList.get(position).author);

		holder.book.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Bundle bundle = new Bundle();
				String name = book.nameBook;
				String author = book.author;
				String genre = book.genre;
				String publicationDate = book.publicationDate;
				String rating = String.valueOf(book.rating);

				bundle.putString("name", name);
				bundle.putString("author", author);
				bundle.putString("genre", genre);
				bundle.putString("publicationDate", publicationDate);
				bundle.putString("rating", rating);

				Navigation.findNavController(v).navigate(R.id.navigation_solo_book_item, bundle);
			}
		});

		holder.book.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(context);

				Log.i("Click", "on long item click");
				return true;
			}
		});
	}

	@Override
	public int getItemCount() { return this.bookList.size(); }
}