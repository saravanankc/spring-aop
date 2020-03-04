package com.kc.mylearnings.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//DEFINITION: (ASPECT = POINTCUT + ADVICE) Combination of POINTCUT & ADVICE
//@Aspect - defines that this block/class is a AOP
//@Configuration - this is some configuration for AOP
@Aspect
@Configuration
public class AfterAspect {
    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @After(value = "com.kc.mylearnings.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()")
    public void after(JoinPoint joinPoint){
        LOGGER.info("After execution of {}", joinPoint);
    }

    @AfterReturning(value = "com.kc.mylearnings.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        LOGGER.info("{} returned with value {}", joinPoint, result);
    }

    @AfterThrowing(value = "com.kc.mylearnings.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Object exception){
        LOGGER.info("Returned exception {}", joinPoint);
    }
//    @After("execution(* com.saravanan.spring.aop.springaop.business.*.*(..))")
//    public void after(JoinPoint joinPoint){
//        LOGGER.info("After execution of {}", joinPoint);
//    }
//
//    @AfterReturning(value = "execution(* com.saravanan.spring.aop.springaop.business.*.*(..))", returning = "result")
//    public void afterReturning(JoinPoint joinPoint, Object result){
//        LOGGER.info("{} returned with value {}", joinPoint, result);
//    }
//
//    @AfterThrowing(value = "execution(* com.saravanan.spring.aop.springaop.business.*.*(..))", throwing = "c")
//    public void afterThrowing(JoinPoint joinPoint, Object exception){
//        LOGGER.info("Returned exception {}", joinPoint);
//    }
}
