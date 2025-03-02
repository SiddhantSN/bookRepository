package com.books.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.books.entities.Book;

@RepositoryRestResource
public interface BookRepository extends CrudRepository<Book, Long> {

//	@Query(value = "SELECT * FROM Book b where b.yearOfPublication = ?1", nativeQuery = true)
//	public List<Book> findByYearOfPublication(int yearOfPublication);
	
	public List<Book> findByyearOfPublication(int yearOfPublication);
	
//	@Query(value = "SELECT * FROM Book WHERE author = :author", nativeQuery = true)
//	List<Book> findBooksByAuthor(@Param("author") String author);
	
	@Query("SELECT b FROM Book b WHERE b.author = ?1")
	List<Book> findByAuthor(String author);
	
	
	
	
	
	
	
	
	
	
}
