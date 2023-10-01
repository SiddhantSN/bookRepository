package com.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.books.entities.Book;
import com.books.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return this.bookService.getAllBooks();
	}
	
	@GetMapping("/books/{isbn}")
	public ResponseEntity<Book> getBookByIsbn(@PathVariable("isbn") String isbn) {
		Book book = this.bookService.getBookByIsbn(isbn);
		// handle if isbn not found, return not found status 
		return ResponseEntity.ok(book); 
	}
	
//	@GetMapping("/books/{year}")
//	public List<Book> getAllBooksByIsbn(@PathVariable("year") int year){
//		return this.bookService.getAllBooksByYear(year);
//	}
	
	
	@PostMapping("/books")
	public ResponseEntity<Book> addNewBook(@RequestBody Book book){
		Book newBook = this.bookService.saveBook(book);
		return ResponseEntity.ok(newBook);
	}
	
//	@GetMapping("/books/{author}")
//	public List<Book> getByAuthor(@PathVariable String author){
//		List<Book> book = this.bookService.getByAuthor(author);
//		return book;
//	}
	
	@PutMapping("/books")
	public ResponseEntity<Book> updateBook(@RequestBody Book book){
		this.bookService.updateByIsbn(book, book.isbn);
		return ResponseEntity.ok(book);
	}
	
	@DeleteMapping("/books/{isbn}")
	public void deleteBook(@PathVariable("isbn") String isbn) {
		this.bookService.deleteByIsbn(isbn);
	}
	
}
