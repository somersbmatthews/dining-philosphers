package com.revature.diningphilosophers.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Component;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class Dining {


    @GetMapping("/dining")
    @Produces(MediaType.APPLICATION_JSON)
    public Mono<String> getHelloWorld() {
        return Mono.just("Hello, world!");
    }

    @MessageMapping("/socket")
    @Produces(MediaType.APPLICATION_JSON)
    @Con
    public
}
