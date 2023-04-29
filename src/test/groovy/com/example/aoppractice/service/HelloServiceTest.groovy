package com.example.aoppractice.service

import java.time.LocalDateTime
import com.example.aoppractice.util.EncodeUtil
import com.example.aoppractice.util.TimeUtil
import spock.lang.Specification

class HelloServiceTest extends Specification {
    def obj = new HelloService(encodeUtil)
    def encodeUtil = new EncodeUtil()
    static mockTime = LocalDateTime.of(2023, 4, 29, 12, 00)

    def setupSpec() {

        System.out.println("set up before all")
    }

    def getTime_test() {
        setup:


        when: "i call getTime"
        def result = obj.getTime()
        then:
        result == mockTime
    }
}
