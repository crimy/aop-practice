package com.example.aoppractice.aspect;

import com.example.aoppractice.annotation.FirstMethod;
import com.example.aoppractice.annotation.SecondMethod;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SampleAspect {
    @Pointcut("@annotation(com.example.aoppractice.annotation.FirstMethod)")
    public void firstAnnotated(){}
    @Pointcut("@annotation(com.example.aoppractice.annotation.SecondMethod)")
    public void secondAnnotated(){}

    @Around("@annotation(firstMethod) || @annotation(secondMethod)")
    public Object BothAnnotated(ProceedingJoinPoint joinPoint, FirstMethod firstMethod, SecondMethod secondMethod) throws Throwable {
        return joinPoint.proceed();
    }
}
