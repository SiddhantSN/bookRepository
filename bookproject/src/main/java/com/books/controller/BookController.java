package com.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.books.entities.Book;
import com.books.service.BookService;

@RestController
//@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return this.bookService.getAllBooks();
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") String id) {
		Book book = this.bookService.getBookById(Long.parseLong(id));
		System.out.println(id);
		// handle if isbn not found, return not found status
		return ResponseEntity.ok(book); 
	}
	
	@GetMapping("/year/{year}")
	public List<Book> getAllBooksByYear(@PathVariable("year") int year){
		return this.bookService.getAllBooksByYear(year);
	}
	
	
	@PostMapping("/books")
	public ResponseEntity<Book> addNewBook(@RequestBody Book book){
		Book newBook = this.bookService.saveBook(book);
		return ResponseEntity.ok(newBook);
	}
	
	@GetMapping("/books/author/{author}")
	public List<Book> getByAuthor(@PathVariable("author") String author){
		System.out.println(author);
		List<Book> books = this.bookService.getByAuthor(author);
		System.out.println(author);
		return books;
	}
	
	@PutMapping("/books")
	public ResponseEntity<Book> updateBook(@RequestBody Book book){
		this.bookService.updateByIsbn(book, book.isbn);
		return ResponseEntity.ok(book);
	}
	
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable("id") String id) {
		this.bookService.deleteById(Long.parseLong(id));
	}
	
}
