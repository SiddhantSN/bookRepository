package com.books.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.books.entities.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class BookDAOImpl implements BookDAO {
	
	@Autowired
	EntityManager entityManager;

	@Override
	@Transactional
	public Book save(Book book) {
		entityManager.persist(book);
		return book;
	}

	@Override
	public List<Book> getAll() {
		TypedQuery<Book> queryBooks = entityManager.createNamedQuery("getallbooks", Book.class);
		return queryBooks.getResultList();
		
	}

	@Override
	public Book deleteById(Long id) {
		Book bookFound = entityManager.find(Book.class, id);
		Assert.notNull(bookFound, "Book not found");
		entityManager.remove(bookFound);
		// TODO Auto-generated method stub
		return bookFound;
	}

}
