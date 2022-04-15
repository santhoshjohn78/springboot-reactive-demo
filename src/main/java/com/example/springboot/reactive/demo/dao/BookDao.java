package com.example.springboot.reactive.demo.dao;

import com.example.springboot.reactive.demo.dto.Book;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class BookDao {

    public static void delay(){
        try {
            Thread.sleep(1000);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public List<Book> getBooks(){
        return IntStream.rangeClosed(1,10)
                .peek(b -> BookDao.delay())
                .peek(b -> System.out.println("Processing:::"+b))
                .mapToObj(b -> new Book(b,"Book"+b))
                .collect(Collectors.toList());
    }

    public Flux<Book> getBooksStream(){
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(b -> System.out.println("Processing:::"+b))
                .map(b -> new Book(b,"Book"+b));
    }
}
