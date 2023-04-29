package com.example.aoppractice.util;

import org.springframework.stereotype.Component;

@Component
public class EncodeUtil {
    public String encode(String plainText) {
        return plainText + "encoded";
    }
    public String decode(String encoded) {
        return encoded.replaceAll("encoded","");
    }
}
