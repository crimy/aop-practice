package com.example.aoppractice.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class TimeUtil {

    public static LocalDateTime getCurrentTime() {
        return LocalDateTime.now();
    }
}
