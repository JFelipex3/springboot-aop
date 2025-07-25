package com.jmachuca.curso.springboot.app.aop.springboot_aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointcuts {

    @Pointcut("execution(* com.jmachuca.curso.springboot.app.aop.springboot_aop.services.*.*(..))")
    public void serviceLayerMethods() {}

    @Pointcut("execution(* com.jmachuca.curso.springboot.app.aop.springboot_aop.services.*.*(..))")
    public void serviceLayerMethodsFoo() {}
}
