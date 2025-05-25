package com.books.service;

import java.util.List;

import com.books.entities.Book;

public interface BookService {

	List<Book> getAllBooks();

	Book getBookById(Long id);

	Book saveBook(Book book);

	List<Book> getByAuthor(String author);

	List<Book> getByYear(int year);

	void updateById(Long id);

	void deleteById(Long id);

}