package com.graphql.learn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graphql.learn.entities.Book;
import com.graphql.learn.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
    
    @Autowired
    private BookService bookService;

    // create
    public Book create(@RequestBody Book book) {
        return this.bookService.create(book);
    }

    // get all
    public List<Book> getAll() {
        return this.bookService.getAll();
    }

    // get by id
    public Book get(@PathVariable int bookId) {
        return this.bookService.get(bookId);
    }
}
