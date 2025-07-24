package com.jmachuca.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.jmachuca.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    public void loggerBefore(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Antes de ejecutar: {}.{}({})", joinPoint.getSignature().getDeclaringTypeName(), method, args);
    }

    @After("execution(* com.jmachuca.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    public void loggerAfter(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Despues de ejecutar: {}.{}({})", joinPoint.getSignature().getDeclaringTypeName(), method, args);
    }
}
