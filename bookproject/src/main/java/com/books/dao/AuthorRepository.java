package com.books.dao;

import com.books.entities.AuthorDetails;
import com.books.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorDetails, Long> {

}
