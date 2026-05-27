package com.books.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.books.entities.BookDetails;
import com.books.entities.OpenLibraryBook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.books.dao.BookRepository;
import com.books.entities.Book;
import com.books.service.BookService;
import org.springframework.web.client.RestClient;

@Service
public class BookServiceImpl implements BookService {
	
	private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

	@Autowired
	BookRepository bookRepository;

	@Autowired
	@Qualifier("openLibraryRestClient")
	RestClient openLibraryRestClient;
	
	@Override
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}

	@Override
	public BookDetails getBookbyIsbn(String isbn) {
		String uri = "/api/books?bibkeys=ISBN:{isbn}&format=json";
		logger.info("Calling OpenLibrary REST API with URI: {} with ISBN: {}", uri, isbn);
		Map<String, OpenLibraryBook> openLibraryBookMap = openLibraryRestClient.get()
				.uri(uri, isbn)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.body(new ParameterizedTypeReference<Map<String, OpenLibraryBook>>() {
				});
		logger.info("Response received from OpenLibrary API. Map size: {}", openLibraryBookMap != null ? openLibraryBookMap.size() : 0);
		if (openLibraryBookMap != null) {
			OpenLibraryBook openLibraryBook = openLibraryBookMap.get("ISBN:" + isbn);
			String infoUrl = openLibraryBook.getInfo_url();
			String OLID = Arrays.stream(infoUrl.split("/")).filter(s -> s.startsWith("OL")).findFirst().get();
			return openLibraryRestClient.get().uri("/books/{OLID}", OLID).accept(MediaType.APPLICATION_JSON).retrieve().body(BookDetails.class);
		}
		return null;
	}

	@Override
	public Book getBookById(Long id) {

		Optional<Book> bookFound  = this.bookRepository.findById(id);
		return bookFound.get();
	}
	
	@Override
	public Book saveBook(Book book) {
		Book savedBook = this.bookRepository.save(book);
		return savedBook;
	}
	
	@Override
	public List<Book> getByAuthor(String author) {
		List<Book> bookList = this.bookRepository.findByAuthor(author);
		return bookList;
	}
	
	@Override
	public List<Book> getByYear(int year) {
		List<Book> bookList = this.bookRepository.findByYear(year);
		return bookList;
	}
	

	@Override
	public void deleteById(Long id) {
		 this.bookRepository.deleteById(id);
	}

	@Override
	public Book updateBook(Book updatedBook) {
		Book currentBook = getBookById(updatedBook.getId());
		currentBook.setAuthor(updatedBook.getAuthor());
		currentBook.setTitle(updatedBook.getTitle());
		currentBook.setIsbn(updatedBook.getIsbn());
		currentBook.setPublication(updatedBook.getPublication());
		currentBook.setYear(updatedBook.getYear());
		currentBook.setUsers(updatedBook.getUsers());
		
		return this.bookRepository.save(currentBook);
	}
}
