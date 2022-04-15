package com.example.springboot.reactive.demo;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono(){
        Mono<String> monoStringPublisher = Mono.just("Hello").log();
        monoStringPublisher.subscribe(System.out::println);
    }

    @Test
    public void testMonoError(){
        Mono<?> monoStringPub = Mono.just("Hello---------------")
                .then(Mono.error(new RuntimeException("Run time errr")))
                .log();
        monoStringPub.subscribe((e)->{System.out.println(e);},(ex)->{ex.printStackTrace();});
    }


    public void testFlux(){

    }
}
