package com.revature.diningphilosophers.controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.springframework.stereotype.Component;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class Dining {

//    @GET
//    @Path("/dining")
//    @Produces(MediaType.APPLICATION_JSON)
    @GetMapping("/dining")
    public Mono<String> getHelloWorld() {
        return Mono.just("Hello, world!");
    }
}
