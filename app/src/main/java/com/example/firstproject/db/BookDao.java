package com.example.firstproject.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
	public interface BookDao {

		@Query("SELECT * FROM book")
		List<Book> getAll();

		@Insert(onConflict = OnConflictStrategy.REPLACE)
		void insert(Book... books);
	}