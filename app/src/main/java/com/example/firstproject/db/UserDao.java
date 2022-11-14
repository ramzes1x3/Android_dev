package com.example.firstproject.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
	public interface UserDao {
		@Query("SELECT * FROM user")
		List<User> getAll();

		@Insert(onConflict = OnConflictStrategy.REPLACE)
		void insert(User... users);
	}
