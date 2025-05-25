package com.books.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

	@Column(name = "year")
	public int year;

	@Column(name = "publication")
	public String publication;

	@Column(name = "image_Url_Small")
	public String imageUrlSmall;
	
	@Column(name="user_id")
	public String userId;

}
