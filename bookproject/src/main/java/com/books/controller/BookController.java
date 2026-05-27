package com.books.controller;

import java.util.List;

import com.books.entities.OpenLibraryBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.books.entities.Book;
import com.books.service.BookService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
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

	@GetMapping("/isbn")
	public ResponseEntity<OpenLibraryBook> getBookByIsbn(@RequestParam(name = "isbn") String isbn){
		OpenLibraryBook openLibraryBook = this.bookService.getBookbyIsbn(isbn);
		return ResponseEntity.ok(openLibraryBook);
	}
	
	@PostMapping
	public ResponseEntity<Book> addNewBook(@RequestBody Book book){
		Book newBook = this.bookService.saveBook(book);
		return ResponseEntity.ok(newBook);
	}
	
	@GetMapping("/author")
	public ResponseEntity<List<Book>> getByAuthor(@RequestParam(name = "author") String author){
	    List<Book> books = bookService.getByAuthor(author);
	    return ResponseEntity.ok(books);
	}
	
	@GetMapping("/year")
	public ResponseEntity<List<Book>> getByYear(@RequestParam(name = "year") int year){
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
