package com.jmachuca.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.jmachuca.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    public void serviceLayerMethods() {}

    @Before("serviceLayerMethods()")
    public void loggerBefore(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Antes de ejecutar: {}.{}({})", joinPoint.getSignature().getDeclaringTypeName(), method, args);
    }

    @AfterReturning(pointcut = "serviceLayerMethods()", returning = "result")
    public void loggerAfterReturning(JoinPoint joinPoint, Object result) {

        String method = joinPoint.getSignature().getName();

        logger.info("Después de ejecutar y retornar exitosamente: {}.{}() con resultado: {}", joinPoint.getSignature().getDeclaringTypeName(), method, result);
    }

    @AfterThrowing(pointcut = "serviceLayerMethods()", throwing = "exception")
    public void loggerAfterThrowing(JoinPoint joinPoint, Exception exception) {

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Después de ejecutar y lanzar excepción: {}.{}() con argumentos: {} con excepción: {}", joinPoint.getSignature().getDeclaringTypeName(), method, args, exception.getMessage());
    }

}
