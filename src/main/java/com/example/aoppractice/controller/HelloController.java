package com.example.aoppractice.controller;

import com.example.aoppractice.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {
    private final HelloService helloService;
    @GetMapping("/first")
    public void first() {
        helloService.first();
    }
    @GetMapping("/second")
    public void second() {
        helloService.second();
    }
    @GetMapping("/both")
    public void both() {
        helloService.both();
    }
}
