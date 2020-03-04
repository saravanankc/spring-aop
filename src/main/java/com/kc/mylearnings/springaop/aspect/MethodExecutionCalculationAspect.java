package com.kc.mylearnings.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {
    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    //DEFINITION: AROUND: Around advice helps to advances AOP than @Before and @After. Ex: used to calculate the execution time for
    // a method. ProceedingJoinPoint - allows to continue with the execution of the method.
    //@Around("execution(* com.saravanan.spring.aop.springaop.business.*.*(..))") //This point cut tracks time on all methods under .business.class.methods
    @Around(value = "com.kc.mylearnings.springaop.aspect.CommonJoinPointConfig.trackTimeAnnotation()") //This point cut tracks time on methods that has @TrackTime custom annotation
//    @Around("execution(* com.kc.mylearnings.springaop.business.*.*(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;
        LOGGER.info("Time taken by {} is {}ms", proceedingJoinPoint, timeTaken);
    }
}
