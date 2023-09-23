package com.books.dao;


import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.books.entities.Book;
@EnableJpaRepositories("com.*")
@EntityScan("com.*")   
@SpringBootApplication
public class BookprojectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BookprojectApplication.class, args);
		BookRepository bookRepository = context.getBean(BookRepository.class);
		
		//Book book = new Book();
		
		Optional<Book> bookTest = bookRepository.findById("0452264464");
		
		System.out.println("\n");
		System.out.println(bookTest.get().toString());
	}

}
