package org.gigachat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello from Spring Boot with Bazel!";
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}

