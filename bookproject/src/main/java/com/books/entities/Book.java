package com.books.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
	
	@ManyToMany(mappedBy = "books", cascade = CascadeType.ALL)
	@JsonIgnore
	public List<User> users = new ArrayList<>();

}
