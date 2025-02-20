package com.books.dao;

import java.util.List;

import com.books.entities.Book;

public interface BookDAO {
	
	Book save(Book book);
	
	Book deleteById(Long id);
	
	List<Book> getAll();
}
