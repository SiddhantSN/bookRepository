package com.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableCaching
@EnableWebSecurity
@EnableJpaRepositories("com.*")
@EntityScan("com.*")
@SpringBootApplication
public class BookprojectApplication{
	

	public static void main(String[] args) {
		SpringApplication.run(BookprojectApplication.class, args);
		

	}

//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		List<Book> books = bookRepository.findByAuthor("RZ");
//		List<Book> books2 = StreamSupport.stream(this.bookRepository.findAll().spliterator(), false)
//		 .collect(Collectors.toList());
//		// Book bookFound = this.bookRepository.findById(Long.valueOf(1)).get();
//		 //System.out.println(bookFound.toString() + "///////////////////////");
//		for (Book book : books) {
//			System.out.println(book.toString());
//		}
//		
//	}
}
