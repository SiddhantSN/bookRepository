package com.books.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.entities.Book;


public interface BookRepository extends JpaRepository<Book, String> {

//	@Query(value = "SELECT * FROM Book b where b.yearOfPublication = ?1", nativeQuery = true)
//	public List<Book> findByYearOfPublication(int yearOfPublication);
	
	public List<Book> findByYearOfPublication(int yearOfPublication);
	
	public List<Book> findByBookAuthor(String bookAuthor);
	
	
	
	
	
	
	
}
