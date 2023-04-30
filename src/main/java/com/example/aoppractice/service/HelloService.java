package com.example.aoppractice.service;

import com.example.aoppractice.annotation.FirstMethod;
import com.example.aoppractice.annotation.SecondMethod;
import com.example.aoppractice.util.EncodeUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.example.aoppractice.util.TimeUtil.getCurrentTime;

@Service
@AllArgsConstructor
public class HelloService {
    private final EncodeUtil encodeUtil;
    @FirstMethod
    public void first() {

    }
    @SecondMethod
    public void second() {

    }
    @FirstMethod
    @SecondMethod
    public void both() {
    }

    public LocalDateTime getTime() {
        return getCurrentTime();
    }
    public String getEncodedTime() {
        LocalDateTime time = getCurrentTime();
        return encodeUtil.encode(time.format(DateTimeFormatter.ofPattern("yyMMd")));
    }
}
