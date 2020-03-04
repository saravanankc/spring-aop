package com.kc.mylearnings.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//DEFINITION: (ASPECT = POINTCUT + ADVICE) Combination of POINTCUT & ADVICE
//@Aspect - defines that this block/class is a AOP
//@Configuration - this is some configuration for AOP
@Aspect
@Configuration
public class BeforeAspect {
    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    //What kind of method calls I would intercept?

    //DEFINITION: POINTCUT -> Is the expression or format for what kind of methods AOP has to intercept within a package
    //execution(RETURNTYPE PACKAGE.CLASS.METHOD(ARGS))
    //Ex: execution(* PACKAGE.*.*(..)) -> defines intercept all page
    //DEFINITION: JOINPOINT - Specific interception of a method call! specific execution instance. provides details of the intercepted method calls
    //DEFINITION: WEAVING, WEAVER - Whole process of AOP is called WEAVING and the framework performing this is WEAVER.
    //@Before - called before the method is called. Usually used for user access on method
    // @Before("execution(* com.saravanan.spring.aop.springaop..*.*(..))") // Intercepts all packages under the package com.saravanan.spring.aop.springaop

//    @Before("execution(* com.saravanan.spring.aop.springaop.dao.*.*(..))")
//    public void before(JoinPoint joinPoint){
//        //DEFINITION: ADVICE: After  intercepting the call, what should I do? write code to manage action
//        LOGGER.info("Intercepted method call - {}", joinPoint);
//
//        // This is a sample for UserAccessAspect
//        // LOGGER.info("Check for user access and may be allow user access.");
//        // LOGGER.info("Allow execution for {}", joinPoint);
//    }

    // Either above @Before expression with actual class or overridden with a Pointcut function or bean expression can be used to AOP
    @Before(value = "com.kc.mylearnings.springaop.aspect.CommonJoinPointConfig.daoLayerExecution()")
    public void before(JoinPoint joinPoint){
        LOGGER.info("Intercepted method call - {}", joinPoint);
    }
}
