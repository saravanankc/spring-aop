package com.kc.mylearnings.springaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {


    //Pointcuts defining package class expressions
    //expression: execution(RETURNTYPE PACKAGE.CLASS.METHOD(ARGS))
    @Pointcut("execution(* com.kc.mylearnings.springaop.business.*.*(..))")
    public void businessLayerExecution(){}

    @Pointcut("execution(* com.kc.mylearnings.springaop.dao.*.*(..))")
    public void daoLayerExecution(){}


    //Pointcuts defining bean expressions
    //expression: bean(*dao*)
    @Pointcut("bean(*dao*)")
    public void beansContainingDAO(){}

    //Pointcuts defining bean expressions
    //expression: within(package.class.)
    @Pointcut("within(com.kc.mylearnings.springaop.dao..*)")
    public void dataLayerExecutionWithWithin(){}

    @Pointcut("@annotation(com.kc.mylearnings.springaop.aspect.TrackTime)")
    public void trackTimeAnnotation(){}
}
