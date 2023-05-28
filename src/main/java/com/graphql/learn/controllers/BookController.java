package com.graphql.learn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.graphql.learn.entities.Book;
import com.graphql.learn.services.BookService;

import lombok.Getter;
import lombok.Setter;

@Controller
public class BookController {
    
    @Autowired
    private BookService bookService;

    // create
    @MutationMapping("createBook")
    public Book create(@Argument BookInput book) {
        Book b = new Book();
        b.setTitle(book.getTitle());
        b.setAuthor(book.getAuthor());
        b.setDescription(book.getDescription());
        b.setPrice(book.getPrice());
        b.setPages(book.getPages());
        return this.bookService.create(b);
    }

    // get all
    @QueryMapping("allBooks")
    public List<Book> getAll() {
        return this.bookService.getAll();
    }

    // get by id
    @QueryMapping("getBook")
    public Book get(@Argument int bookId) {
        return this.bookService.get(bookId);
    }
}

@Getter
@Setter
class BookInput {
    private String title;
    private String description;
    private String author;
    private double price;
    private int pages;
}