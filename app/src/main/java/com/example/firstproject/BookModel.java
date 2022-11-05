package com.example.firstproject;

public class BookModel {
	String author;
	String genre;
	String name;
	String publicationDate;
	int rating;

	public BookModel(String author, String genre, String name, String publicationDate, int rating) {
		this.author = author;
		this.genre = genre;
		this.name = name;
		this.publicationDate = publicationDate;
		this.rating = rating;
	}

	public String getAuthor() {
		return author;
	}

	public String getGenre() {
		return genre;
	}

	public String getName() {
		return name;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public int getRating() {
		return rating;
	}

	public String getBookToString() { return String.valueOf("Book - " + "author:" + this.author + " " + "genre:" + this.genre +  " name:" + this.name +  " publicationDate:" + this.publicationDate +  " rating:" + this.rating); }
}