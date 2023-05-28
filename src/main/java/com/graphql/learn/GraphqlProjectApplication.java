package com.graphql.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.graphql.learn.entities.Book;
import com.graphql.learn.services.BookService;

@SpringBootApplication
public class GraphqlProjectApplication implements CommandLineRunner{

	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(GraphqlProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book b1 = new Book();
		b1.setTitle("Cracking the coding interview");
		b1.setAuthor("Gayle Lacman");
		b1.setDescription("Tutorials on how to crack the best job.");
		b1.setPages(500);
		b1.setPrice(29.99);

		Book b2 = new Book();
		b2.setTitle("Grokking the system design interview");
		b2.setAuthor("Educative.io");
		b2.setPages(250);
		b2.setPrice(19.99);
		b2.setDescription("Crack the system design interview");

		this.bookService.create(b1);
		this.bookService.create(b2);
	}
}
