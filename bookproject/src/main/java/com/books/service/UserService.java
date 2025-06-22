package com.books.service;

import java.util.List;

import com.books.entities.User;
import com.books.exception.UserNotFoundException;

public interface UserService {
	
	User createUser(User user);
	
	List<User> getAllUsers();
	
	User getUserById(String id) throws UserNotFoundException;
	
	User updateUser(User updatedUser) throws UserNotFoundException;
	
	User AddBookToUser(Long bookId, String userId) throws UserNotFoundException;
	
}
