package com.books.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public long id;
	
	@Column(name = "isbn")
	public String isbn;
	
	@Column(name = "bookTitle")
	public String bookTitle;
	
	@Column(name = "bookAuthor")
	public String bookAuthor;

	@Column(name = "yearOfPublication")
	public int yearOfPublication;

	@Column(name = "publication")
	public String publication;

	@Column(name = "imageUrlSmall")
	public String imageUrlSmall;

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor + ", yearOfPublication="
				+ yearOfPublication + ", publication=" + publication + ", imageUrlSmall=" + imageUrlSmall
				+ ", imageUrlMedium=" + imageUrlMedium + "]";
	}

	@Column(name = "imageUrlMedium")
	public String imageUrlMedium;

	public Book() {
		super();
	}

	public Book(String isbn, String bookTitle,String bookAuthor, int yearOfPublication, String publication, String imageUrlSmall,
			String imageUrlMedium) {
		super();
		this.isbn = isbn;
		this.bookAuthor = bookAuthor;
		this.yearOfPublication = yearOfPublication;
		this.publication = publication;
		this.imageUrlSmall = imageUrlSmall;
		this.imageUrlMedium = imageUrlMedium;
		this.bookTitle = bookTitle;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public int getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(int yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getImageUrlSmall() {
		return imageUrlSmall;
	}

	public void setImageUrlSmall(String imageUrlSmall) {
		this.imageUrlSmall = imageUrlSmall;
	}

	public String getImageUrlMedium() {
		return imageUrlMedium;
	}

	public void setImageUrlMedium(String imageUrlMedium) {
		this.imageUrlMedium = imageUrlMedium;
	}

}
