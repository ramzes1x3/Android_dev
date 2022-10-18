package com.example.firstproject.ui.home;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.firstproject.BookModel;
import com.example.firstproject.R;
import com.example.firstproject.ui.adapters.BooksAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

	private RecyclerView mRecyclerView;

	ArrayList<BookModel> bookModels = new ArrayList<>();

	private void setUpBookModels() {
		String[] bookNames = getResources().getStringArray(R.array.book_names);
		String[] bookInfo = getResources().getStringArray(R.array.book_info);

		for (int i = 0; i < bookNames.length; i++) {
			bookModels.add(new BookModel(bookNames[i],
					bookInfo[i]));
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

//		setUpBookModels();
		Thread fetch = new Thread(new Runnable() {
			@Override
			public void run() {
				StringBuilder response = new StringBuilder();

				try {
					URL url = new URL("https://api.npoint.io/9d9526bc5f8d6d1b81ab");
					HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
					InputStream inputStream = httpURLConnection.getInputStream();
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
					String line;

					while ((line = bufferedReader.readLine()) != null) {
						response.append(line);
					}

					inputStream.close();

					if (response != null) {
						JSONObject jsonObject = new JSONObject(String.valueOf(response));
						JSONArray books = jsonObject.getJSONArray("books");
						bookModels.clear();

						for (int i = 0; i < books.length(); i++) {
							JSONObject booksJSON = books.getJSONObject(i);
							String name = booksJSON.getString("name");
							String description = booksJSON.getString("description");
							bookModels.add(i, new BookModel(name, description));
						}
					}

				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		});

		fetch.start();

		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
		mRecyclerView.setHasFixedSize(true);

		BooksAdapter adapter = new BooksAdapter(getContext(), (ArrayList<BookModel>) bookModels);
		mRecyclerView.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}
}