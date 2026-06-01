package com.books.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
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

	@Column(name = "isbn10")
	public String isbn10;

	@Column(name = "title")
	public String title;

	@Column(name = "author")
	public String author;

	@Column(name = "year")
	public String year;

	@Column(name = "publication")
	public String publication;

	@Column(name = "number_of_pages")
	public Integer numberOfPages;

	@ManyToMany(mappedBy = "books", cascade = CascadeType.ALL)
	@JsonIgnore
	public List<User> users = new ArrayList<>();

}
