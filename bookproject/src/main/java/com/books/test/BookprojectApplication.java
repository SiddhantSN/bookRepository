package com.books.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.books.dao.BookRepository;
import com.books.entities.Book;
@EnableJpaRepositories("com.*")
@EntityScan("com.*")
@SpringBootApplication
public class BookprojectApplication implements CommandLineRunner{
	
	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookprojectApplication.class, args);
		
		

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<Book> books = bookRepository.findByAuthor("RZ");
		for (Book book : books) {
			System.out.println(book.toString());
		}
		
	}
}
