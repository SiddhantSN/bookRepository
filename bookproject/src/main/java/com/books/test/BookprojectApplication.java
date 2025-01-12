package com.books.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.*")
@EntityScan("com.*")
@SpringBootApplication(scanBasePackages = { "controller", "dao", "entities", "service" })
public class BookprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookprojectApplication.class, args);

	}
}
