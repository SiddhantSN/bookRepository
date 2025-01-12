package com.books.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.dao.BookRepository;
import com.books.entities.Book;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	public List<Book> getAllBooks(){
		return this.bookRepository.findAll();
	}
	
	public Book getBookByIsbn(String isbn) {
		
		Optional<Book> bookFound  = this.bookRepository.findById(isbn);
		return bookFound.get();
	}
	
	public List<Book> getAllBooksByYear(int year){
		return this.bookRepository.findByYearOfPublication(year);
	}
	
	public Book saveBook(Book book) {
		Book savedBook = this.bookRepository.save(book);
		return savedBook;
	}
	
	public List<Book> getByAuthor(String author) {
		List<Book> bookList = this.bookRepository.findByBookAuthor(author);
		return bookList;
	}
	
	public void updateByIsbn(Book book, String isbn) {
		book.setIsbn(isbn);
		this.bookRepository.save(book);
	}

	public void deleteByIsbn(String isbn) {
		this.bookRepository.deleteById(isbn);
	}
}
