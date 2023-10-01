package com.books.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.entities.Book;
import java.util.List;


public interface BookRepository extends JpaRepository<Book, String> {

//	@Query(value = "SELECT * FROM books.book b where b.yearOfPublication = ?1", nativeQuery = true)
//	public List<Book> getBooksByYearOfPublication(int yearOfPublication);
	
	List<Book> findByBookAuthor(String bookAuthor);
	
	
	
	
	
}
