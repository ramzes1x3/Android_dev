package com.example.firstproject.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.firstproject.BookModel;
import com.example.firstproject.R;
import com.example.firstproject.ui.adapters.BooksAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

	private RecyclerView mRecyclerView;

	ArrayList<BookModel> bookModels = new ArrayList<>();
	int[] bookImages = {
			R.drawable.vlast_tmy_img, R.drawable.vlast_tmy_img,
			R.drawable.vlast_tmy_img, R.drawable.vlast_tmy_img,
			R.drawable.vlast_tmy_img, R.drawable.vlast_tmy_img,
			R.drawable.vlast_tmy_img, R.drawable.vlast_tmy_img,
			R.drawable.vlast_tmy_img };
	int heartIcon = R.drawable.ic_heart;

	private void setUpBookModels() {
		String[] bookNames = getResources().getStringArray(R.array.book_names);
		String[] bookInfo = getResources().getStringArray(R.array.book_info);

		for (int i = 0; i < bookNames.length; i++) {
			bookModels.add(new BookModel(bookNames[i],
					bookInfo[i],
					bookImages[i],
					heartIcon));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_home, container, false);

		return view;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		setUpBookModels();

		mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
		mRecyclerView.setHasFixedSize(true);

		BooksAdapter adapter = new BooksAdapter(getContext(), (ArrayList<BookModel>) bookModels);
		mRecyclerView.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}
}