package com.example.firstproject.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;;
import androidx.recyclerview.widget.RecyclerView;
import com.example.firstproject.BookModel;
import com.example.firstproject.R;
import java.util.ArrayList;

public class BooksAdapter extends
		RecyclerView.Adapter<BooksAdapter.BooksViewHolder> {

	Context context;
	ArrayList<BookModel> bookModels;

	public static class BooksViewHolder extends RecyclerView.ViewHolder {
		public ImageView bookImage, heartIcon;
		public TextView bookName, bookInfo;
		public  BooksViewHolder(View itemView) {
			super(itemView);

			bookName = itemView.findViewById(R.id.book_name);
			bookInfo = itemView.findViewById(R.id.about_book);
			bookImage = itemView.findViewById(R.id.book_image);
			heartIcon = itemView.findViewById(R.id.icon_add_favorite);
		}
	}

	public BooksAdapter(Context context, ArrayList<BookModel> bookModels) {
		this.context = context;
		this.bookModels = bookModels;
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
		holder.bookName.setText(bookModels.get(position).getBookName());
		holder.bookInfo.setText(bookModels.get(position).getBookInfo());
		holder.bookImage.setImageResource(bookModels.get(position).getBookImage());
		holder.heartIcon.setImageResource(bookModels.get(position).getHeartIcon());
	}

	@Override
	public int getItemCount() { return bookModels.size(); }

}
