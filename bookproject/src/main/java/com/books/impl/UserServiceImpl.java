package com.books.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.dao.UserRepository;
import com.books.entities.User;
import com.books.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
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

	@Override
	public User getUserById(String id) {
		User user = this.userRepository.findById(id).get();
		return user;
	}

	@Override
	public User updateUser(User updatedUser) {
		User currentUser = getUserById(updatedUser.getId());
		currentUser.setAge(updatedUser.getAge());
		currentUser.setBooks(updatedUser.getBooks());
		currentUser.setName(updatedUser.getName());
		User savedUser = this.userRepository.save(currentUser);
		return savedUser;
	}

}
