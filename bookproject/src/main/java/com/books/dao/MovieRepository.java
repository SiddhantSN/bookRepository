package com.books.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
