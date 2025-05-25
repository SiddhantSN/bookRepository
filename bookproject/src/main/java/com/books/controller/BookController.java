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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.entities.Book;
import com.books.service.BookService;



@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks(){
		List<Book> allBooks = bookService.getAllBooks();
		return ResponseEntity.ok(allBooks);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable String id) {
		Book book = this.bookService.getBookById(Long.parseLong(id));
		System.out.println(id);
		// handle if isbn not found, return not found status
		return ResponseEntity.ok(book); 
	}
	
	@PostMapping
	public ResponseEntity<Book> addNewBook(@RequestBody Book book){
		Book newBook = this.bookService.saveBook(book);
		return ResponseEntity.ok(newBook);
	}
	
	@GetMapping("/author/{author}")
	public ResponseEntity<List<Book>> getByAuthor(@PathVariable String author){
	    List<Book> books = bookService.getByAuthor(author);
	    return ResponseEntity.ok(books);
	}
	
	@GetMapping("/year/{year}")
	public ResponseEntity<List<Book>> getByYear(@PathVariable int year){
	    List<Book> books = bookService.getByYear(year);
	    return ResponseEntity.ok(books);
	}
	
	@PutMapping
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		return ResponseEntity.ok(this.bookService.updateBook(book));
	}
	
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable String id) {
		this.bookService.deleteById(Long.parseLong(id));
	}
	
}
