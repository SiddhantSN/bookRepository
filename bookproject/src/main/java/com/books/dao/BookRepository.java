package com.books.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.books.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);

    @Query("select b from Book b where b.year=:year")
    List<Book> findByYear(@Param("year") int year);

    @Query("select b from Book b where b.isbn10 = :isbn10")
    Book findByIsbn10(@Param("isbn10") String isbn10);

	
	
	
	
	
	
	
	
}
