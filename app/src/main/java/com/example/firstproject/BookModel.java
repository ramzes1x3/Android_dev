package com.example.firstproject;

public class BookModel {
	String bookName;
	String bookInfo;
	int bookImage;
	int heartIcon;

	public BookModel(String bookName, String bookInfo, int bookImage, int heartIcon) {
		this.bookName = bookName;
		this.bookInfo = bookInfo;
		this.bookImage = bookImage;
		this.heartIcon = heartIcon;
	}

	public String getBookName() {
		return bookName;
	}

	public String getBookInfo() {
		return bookInfo;
	}

	public int getBookImage() {
		return bookImage;
	}

	public int getHeartIcon() {
		return heartIcon;
	}
}
