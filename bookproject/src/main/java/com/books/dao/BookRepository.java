package com.books.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.entities.Book;

public interface BookRepository extends JpaRepository<Book, String> {

	public List<Book> findByyearOfPublication(int publication);
	
}
