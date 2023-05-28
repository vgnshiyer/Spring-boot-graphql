package com.graphql.learn.services;


import java.util.List;

import com.graphql.learn.entities.Book;

public interface BookService {
    // create book
    Book create(Book book);

    // get all books
    List<Book> getAll();

    // get single book
    Book get(int bookId);
}
