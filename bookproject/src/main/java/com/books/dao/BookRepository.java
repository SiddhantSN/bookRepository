package com.books.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.books.entities.Book;

public interface BookRepository extends JpaRepository<Book, String> {

//	@Query(value = "SELECT * FROM books.book b where b.yearOfPublication = ?1", nativeQuery = true)
//	public List<Book> getBooksByYearOfPublication(int yearOfPublication);
	
}
