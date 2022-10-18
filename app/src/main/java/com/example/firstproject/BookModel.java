package com.example.firstproject;

public class BookModel {
	String bookName;
	String bookInfo;

	public BookModel(String bookName, String bookInfo) {
		this.bookName = bookName;
		this.bookInfo = bookInfo;
	}

	public String getBookName() {
		return bookName;
	}

	public String getBookInfo() {
		return bookInfo;
	}
}
