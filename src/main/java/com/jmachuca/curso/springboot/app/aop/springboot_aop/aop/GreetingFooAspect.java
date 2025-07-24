package com.jmachuca.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
@Aspect
public class GreetingFooAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.jmachuca.curso.springboot.app.aop.springboot_aop.services.*.*(..))")
    public void serviceLayerMethodsFoo() {}

    @Before("serviceLayerMethodsFoo()")
    public void loggerBefore(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("GreetingFooAspect - Antes de ejecutar: {}.{}({})", joinPoint.getSignature().getDeclaringTypeName(), method, args);
    }

    @AfterReturning(pointcut = "serviceLayerMethodsFoo()", returning = "result")
    public void loggerAfterReturning(JoinPoint joinPoint, Object result) {

        String method = joinPoint.getSignature().getName();

        logger.info("GreetingFooAspect - Después de ejecutar y retornar exitosamente: {}.{}() con resultado: {}", joinPoint.getSignature().getDeclaringTypeName(), method, result);
    }

}
