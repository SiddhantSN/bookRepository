package com.books.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.books.dao.UserRepository;
import com.books.entities.Book;
import com.books.entities.User;
import com.books.exception.UserNotFoundException;
import com.books.service.BookService;
import com.books.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BookService bookService;
	
	@Override
	public User createUser(User user) {
		user.setId(UUID.randomUUID().toString());
		User savedUser = this.userRepository.save(user);
		return savedUser;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = this.userRepository.findAll();
		return allUsers;
	}
	
	@Cacheable(cacheNames = "cache1")
	@Override
	public User getUserById(String id) throws UserNotFoundException {
		User user = this.userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(""));
		return user;
	}

	@Override
	public User updateUser(User updatedUser) throws UserNotFoundException {
		User currentUser = getUserById(updatedUser.getId());
		currentUser.setAge(updatedUser.getAge());
		currentUser.setBooks(updatedUser.getBooks());
		currentUser.setName(updatedUser.getName());
		User savedUser = this.userRepository.save(currentUser);
		return savedUser;
	}

	@Override
	public User AddBookToUser(Long bookId, String userId) throws UserNotFoundException {
		// book id 2
		// user ID b6fa44e7-fe4a-4008-a38e-ceabae623fc9
//		Book book = this.bookService.getBookById(bookId);
//		User user = getUserById(userId);
//		List<Book> books = user.getBooks();
//		book.getUsers().add(user);
//		books.add(this.bookService.updateBook(book));
//		user.setBooks(books);
//		return updateUser(user);
		
		Book book = this.bookService.getBookById(bookId);
		User user = getUserById(userId);
		List<Book> books = user.getBooks();

		if (books.contains(book)) {
			throw new UserNotFoundException("Book already exists in user's collection");
		}

		book.getUsers().add(user);
		books.add(this.bookService.updateBook(book));
		user.setBooks(books);

		return updateUser(user);
	}

}
