package com.graphql.learn.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphql.learn.entities.Book;
import com.graphql.learn.repositories.BookRepo;
import com.graphql.learn.services.BookService;

@Service
public class BookServiceImpl implements BookService{

    private BookRepo bookRepo;

    @Autowired
    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public Book create(Book book) {
        return this.bookRepo.save(book);
    }

    @Override
    public List<Book> getAll() {
        return this.bookRepo.findAll();
    }

    @Override
    public Book get(int bookId) {
        return this.bookRepo.findById(bookId).orElseThrow(() -> new RuntimeException("Book you are looking for is not available."));
    }
    
}
