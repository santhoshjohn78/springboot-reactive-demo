package com.example.springboot.reactive.demo.controller;

import com.example.springboot.reactive.demo.dto.Book;
import com.example.springboot.reactive.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping(value= "/streams", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Book> getBooksStream(){
        return bookService.getBookStreams();
    }
}
