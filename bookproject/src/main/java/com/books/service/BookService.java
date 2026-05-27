package com.books.service;

import java.util.List;

import com.books.entities.Book;
import com.books.entities.BookDetails;
import com.books.entities.OpenLibraryBook;

public interface BookService {

	List<Book> getAllBooks();

	Book getBookById(Long id);

	Book saveBook(Book book);

	List<Book> getByAuthor(String author);

	List<Book> getByYear(int year);

	BookDetails getBookbyIsbn(String isbn);

	Book updateBook(Book book);

	void deleteById(Long id);

}