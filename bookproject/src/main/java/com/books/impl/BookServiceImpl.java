package com.books.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.books.entities.Author;
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
	public Book getBookbyIsbn(String isbn) {
		logger.info("Searching for existing book with isbn10: {}", isbn);
		Book existingBook = bookRepository.findByIsbn10(isbn);

		if(existingBook != null) {
			logger.info("Found existing book in database with isbn10: {}", isbn);
			return existingBook;
		}

		logger.info("Book not found in database, fetching from OpenLibrary API with isbn: {}", isbn);
		return fetchAndSaveBookFromOpenLibrary(isbn);
	}

	private Book fetchAndSaveBookFromOpenLibrary(String isbn) {
		Map<String, OpenLibraryBook> openLibraryBookMap = fetchOpenLibraryBookMap(isbn);

		if (openLibraryBookMap == null || openLibraryBookMap.isEmpty()) {
			logger.warn("Book not found in OpenLibrary API with isbn: {}", isbn);
			return null;
		}

		BookDetails bookDetails = fetchBookDetails(isbn);
		if (bookDetails == null) {
			return null;
		}

		Author author = fetchAuthor(bookDetails);
		Book book = mapToBookEntity(isbn, bookDetails, author);

		Book savedBook = bookRepository.save(book);
		logger.info("Book saved to database with isbn10: {}", isbn);
		return savedBook;
	}

	private Map<String, OpenLibraryBook> fetchOpenLibraryBookMap(String isbn) {
		String uri = "/api/books?bibkeys=ISBN:{isbn}&format=json";
		logger.info("Calling OpenLibrary REST API with URI: {} with ISBN: {}", uri, isbn);

		Map<String, OpenLibraryBook> openLibraryBookMap = openLibraryRestClient.get()
				.uri(uri, isbn)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.body(new ParameterizedTypeReference<Map<String, OpenLibraryBook>>() {});

		logger.info("Response received from OpenLibrary API. Map size: {}",
			openLibraryBookMap != null ? openLibraryBookMap.size() : 0);

		return openLibraryBookMap;
	}

	private BookDetails fetchBookDetails(String isbn) {
		return openLibraryRestClient.get()
				.uri("/isbn/{isbn}", isbn)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.body(BookDetails.class);
	}

	private Author fetchAuthor(BookDetails bookDetails) {
		if(bookDetails.getAuthors() == null){
			return null;
		}
		String authorResponse = bookDetails.getAuthors().get(0).getKey();
		String author_OLID = extractOLID(authorResponse);

		return openLibraryRestClient.get()
				.uri("/authors/{author_OLID}", author_OLID)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.body(Author.class);
	}

	private String extractOLID(String url) {
		return Arrays.stream(url.split("/"))
				.filter(s -> s.startsWith("OL"))
				.findFirst()
				.orElse(null);
	}

	private Book mapToBookEntity(String isbn, BookDetails bookDetails, Author author) {
		Book book = new Book();
		book.isbn10 = isbn;
		book.author = author != null && author.getName() != null ? author.getName() : "No Author Data";
		book.isbn = bookDetails.getIsbn().get(0);
		book.title = bookDetails.getBookTitle();
		book.year = bookDetails.getYear();
		book.publication = bookDetails.getPublisher().get(0);
		book.numberOfPages = bookDetails.getNumberOfPages() != null ? bookDetails.getNumberOfPages() : 0;
		return book;
	}

	@Override
	public Book getBookByIsbnDB(String isbn) {
		logger.info("Searching database for book with isbn10: {}", isbn);
		Book book = bookRepository.findByIsbn10(isbn);
		if(book != null) {
			logger.info("Found book in database with isbn10: {}", isbn);
		} else {
			logger.warn("No book found in database with isbn10: {}", isbn);
		}
		return book;
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
		Book currentBook = getBookById(updatedBook.id);
		currentBook.author = updatedBook.author;
		currentBook.title = updatedBook.title;
		currentBook.isbn = updatedBook.isbn;
		currentBook.publication = updatedBook.publication;
		currentBook.year = updatedBook.year;
		currentBook.users = updatedBook.users;

		return this.bookRepository.save(currentBook);
	}
}
