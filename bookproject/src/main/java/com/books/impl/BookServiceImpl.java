package com.books.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.dao.BookRepository;
import com.books.entities.Book;
import com.books.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	@Override
	public Book getBookById(Long id) {
		
		Optional<Book> bookFound  = this.bookRepository.findById(id);
		return bookFound.get();
	}
	
	@Override
	public Book saveBook(Book book) {
		Book savedBook = this.bookRepository.save(book);
		return savedBook;
	}
	
	@Override
	public List<Book> getByAuthor(String author) {
		List<Book> bookList = this.bookRepository.findByAuthor(author);
		return bookList;
	}
	
	@Override
	public List<Book> getByYear(int year) {
		List<Book> bookList = this.bookRepository.findByYear(year);
		return bookList;
	}
	

	@Override
	public void deleteById(Long id) {
		 this.bookRepository.deleteById(id);
	}

	@Override
	public Book updateBook(Book updatedBook) {
		Book currentBook = getBookById(updatedBook.getId());
		currentBook.setAuthor(updatedBook.getAuthor());
		currentBook.setTitle(updatedBook.getTitle());
		currentBook.setIsbn(updatedBook.getIsbn());
		currentBook.setPublication(updatedBook.getPublication());
		currentBook.setYear(updatedBook.getYear());
		currentBook.setUsers(updatedBook.getUsers());
		
		return this.bookRepository.save(currentBook);
	}
}
