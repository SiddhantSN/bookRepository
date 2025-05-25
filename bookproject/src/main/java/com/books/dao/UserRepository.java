package com.books.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
}
