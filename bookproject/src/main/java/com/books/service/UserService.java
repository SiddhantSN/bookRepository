package com.books.service;

import java.util.List;

import com.books.entities.User;

public interface UserService {
	
	User createUser(User user);
	
	List<User> getAllUsers();
	
	User getUserById(String id);
	
	User updateUser(User updatedUser);
	
}
