package com.example.aoppractice.service

import com.example.aoppractice.util.EncodeUtil
import com.example.aoppractice.util.TimeUtil
import org.mockito.MockedStatic
import spock.lang.Specification

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import static org.mockito.Mockito.mockStatic

class HelloServiceTest extends Specification {
    def encodeUtil = new EncodeUtil()
    def obj = new HelloService(encodeUtil)
    private static MockedStatic<TimeUtil> mockTimeUtil
    static mockTime = LocalDateTime.of(2023, 4, 29, 12, 00)

    def setupSpec() {
        mockTimeUtil = mockStatic(TimeUtil.class)
        mockTimeUtil.when {-> TimeUtil.getCurrentTime()}.thenReturn(mockTime)
    }
    def cleanupSpec() {
        mockTimeUtil.close()
    }

    def getTime_test() {
        when: "i call getTime"
        def result = obj.getTime()

        then: "should get mockTime"
        result == mockTime
    }
    def getEncodedTime_test() {
        when: "i call getEncodedTime"
        def result = obj.getEncodedTime()

        then:
        result == encodeUtil.encode(mockTime.format(DateTimeFormatter.ofPattern("yyMMd")))
    }
}
