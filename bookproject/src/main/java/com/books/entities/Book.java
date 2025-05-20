package com.books.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
@Entity
@Table(name = "books")
public class Book {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long id;
	
	@Column(name = "isbn")
	public String isbn;
	
	@Column(name = "title")
	public String title;
	
	@Column(name = "author")
	public String author;

	@Column(name = "year_Of_Publication")
	public int yearOfPublication;

	@Column(name = "publication")
	public String publication;

	@Column(name = "image_Url_Small")
	public String imageUrlSmall;

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", yearOfPublication="
				+ yearOfPublication + ", publication=" + publication + ", imageUrlSmall=" + imageUrlSmall
				+ ", imageUrlMedium=" + imageUrlMedium + "]";
	}

	@Column(name = "image_Url_Medium")
	public String imageUrlMedium;

	public Book() {
		super();
	}

	public Book(String isbn, String title,String author, int yearOfPublication, String publication, String imageUrlSmall,
			String imageUrlMedium) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.yearOfPublication = yearOfPublication;
		this.publication = publication;
		this.imageUrlSmall = imageUrlSmall;
		this.imageUrlMedium = imageUrlMedium;
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String gettitle() {
		return title;
	}

	public void settitle(String title) {
		this.title = title;
	}

	public String getauthor() {
		return author;
	}

	public void setauthor(String author) {
		this.author = author;
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
