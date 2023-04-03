package com.example.aoppractice.aspect;

import com.example.aoppractice.annotation.FirstMethod;
import com.example.aoppractice.annotation.SecondMethod;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class SampleAspect {
    @Pointcut("@annotation(com.example.aoppractice.annotation.FirstMethod)")
    public void firstAnnotated(){}
    @Pointcut("@annotation(com.example.aoppractice.annotation.SecondMethod)")
    public void secondAnnotated(){}

    @Around(value = "firstAnnotated() || secondAnnotated()")
    public Object BothAnnotated(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        FirstMethod firstMethod = method.getAnnotation(FirstMethod.class);
        SecondMethod secondMethod = method.getAnnotation(SecondMethod.class);
        log.info(firstMethod.toString());
        log.info(secondMethod.toString());
        return joinPoint.proceed();
    }
}
