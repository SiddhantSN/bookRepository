package com.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.books.entities.Book;
import com.books.entities.User;
import com.books.service.BookService;
import com.books.service.UserService;

@RequestMapping("/users")
@RestController
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	BookService bookService;

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return ResponseEntity.ok(this.userService.createUser(user));
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable String id){
		return ResponseEntity.ok(this.userService.getUserById(id));
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		return ResponseEntity.ok(this.userService.updateUser(user));
	}
	
	@PutMapping
	public ResponseEntity<User> addBookToUser(@RequestParam Long bookId, @RequestParam String userId){
		// book id 2
		// user ID b6fa44e7-fe4a-4008-a38e-ceabae623fc9
		Book book = this.bookService.getBookById(bookId);
		User user = this.userService.getUserById(userId);
		List<Book> books = user.getBooks();
		books.add(book);
		book.setUserId(userId);
		user.setBooks(books);
		
		// persist this change?
		
		return ResponseEntity.ok(user);
	}
}
