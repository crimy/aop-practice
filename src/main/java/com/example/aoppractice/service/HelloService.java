package com.example.aoppractice.service;

import com.example.aoppractice.annotation.FirstMethod;
import com.example.aoppractice.annotation.SecondMethod;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    @FirstMethod
    public void hello() {

    }
    @SecondMethod
    public void hi() {

    }
    @FirstMethod
    @SecondMethod
    public void bye() {

    }
}
