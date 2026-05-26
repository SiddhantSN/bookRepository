package com.books.dao;

import java.lang.annotation.Native;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.books.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(String author);  // Correct Query
    @Query("select b from Book b where b.year=:year")
    List<Book> findByYear(int year);
	
	
	
	
	
	
	
	
	
}
