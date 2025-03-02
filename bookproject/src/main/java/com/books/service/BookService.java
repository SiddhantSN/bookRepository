package com.books.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.dao.BookRepository;
import com.books.entities.Book;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	public List<Book> getAllBooks(){
		return StreamSupport.stream(this.bookRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
	}
	
	public Book getBookById(Long id) {
		
		Optional<Book> bookFound  = this.bookRepository.findById(id);
		return bookFound.get();
	}
	
	public List<Book> getAllBooksByYear(int year){
		return this.bookRepository.findByyearOfPublication(year);
	}
	
	public Book saveBook(Book book) {
		Book savedBook = this.bookRepository.save(book);
		return savedBook;
	}
	
	public List<Book> getByAuthor(String author) {
		List<Book> bookList = this.bookRepository.findByAuthor(author);
		return bookList;
	}
	
	public void updateByIsbn(Book book, String isbn) {
		book.setIsbn(isbn);
		this.bookRepository.save(book);
	}

	public void deleteById(Long id) {
		 this.bookRepository.deleteById(id);
	}
}
