package com.example.springboot.reactive.demo.service;

import com.example.springboot.reactive.demo.dao.BookDao;
import com.example.springboot.reactive.demo.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookDao bookDao;

    public List<Book> getBooks(){
        return bookDao.getBooks();
    }

    public Flux<Book> getBookStreams(){
        return bookDao.getBooksStream();
    }
}
