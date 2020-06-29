package com.dsi.test.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * Created by A.A.MAMUN on 6/4/2020.
 */
@Aspect
@Component
public class TestAspect {

    /**
     * @Before annotation define the 'Before Advice'. Using the attribute 'value'
     * we can specify the target method by following way. If we want to
     * call every method inside any class like 'TestController' class, just set the value as
     * 'value = "execution(* com.dsi.test.controller.TestController.*(..))"'.
     * '()' is use only for non parameterized method on the other hand '(..)' is
     * use for all kinds of method.
     */

    /**
     * We can use 'JoinPoint' as parameter to get the details about the called method
     * like (i) Method Signature (ii) Arguments (iii) Source Location etc.
     */
    @Before(value = "execution(* com.dsi.test.controller.TestController.testBeforeAdvice())")
    public void beforeAdvice(){
        // write your logic that will call before execute join point.
        System.out.println("|------------------------------------------------------------------------------|");
        System.out.println("|  I am 'Before Advice'. I always execute before call the join point.          |");
        System.out.println("|------------------------------------------------------------------------------|");
    }

    @After(value = "execution(* com.dsi.test.controller.TestController.testAfterAdvice())")
    public void afterAdvice(){
        // write your logic that will call after execute join point.
        System.out.println("|------------------------------------------------------------------------------|");
        System.out.println("|  I am 'After Advice'. I always execute after call the join point.            |");
        System.out.println("|------------------------------------------------------------------------------|\n\n");
    }

    @Around(value = "execution(* com.dsi.test.controller.TestController.testAroundAdvice())")
    public void aroundAdvice(ProceedingJoinPoint jp){ // ProceedingJoinPoint is only supported for around advice
        // write your logic that will call after execute target method.
        // I am 'Around Advice'.I always execute before and after call the join point.
        System.out.println("|------------------------------------------------------------------------------|");
        System.out.println("|  Before execute the join point.                                              |");
        System.out.println("|------------------------------------------------------------------------------|");
        try {
            jp.proceed();  // process our business logic.
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("|------------------------------------------------------------------------------|");
        System.out.println("|  After execute the join point.                                               |");
        System.out.println("|------------------------------------------------------------------------------|\n\n");
    }


    @AfterReturning(value = "execution(* com.dsi.test.controller.TestController.testAfterReturningAdvice(..))")
    public void afterReturningAdvice(){
        // write your logic that will call after successfully execute return statement at join point.
        // JP : Join Point
        System.out.println("|------------------------------------------------------------------------------|");
        System.out.println("|  I am 'After Returning Advice'.Execute after execute return statement at JP  |");
        System.out.println("|------------------------------------------------------------------------------|\n\n");
    }

    @AfterThrowing(value = "execution(* com.dsi.test.controller.TestController.testAfterThrowing(..))", throwing = "ex")
    public void afterThrowingAdvice(Exception ex){

        System.out.println("|------------------------------------------------------------------------------|");
        System.out.println("|  I am 'After Throwing Advice'. Execute scope at throwing exception.          |");
        System.out.println("|------------------------------------------------------------------------------|");
        System.out.println("Exception : " + ex.toString() + "\n\n");

    }

}
