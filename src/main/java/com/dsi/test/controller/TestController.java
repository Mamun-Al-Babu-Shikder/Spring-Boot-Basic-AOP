package com.dsi.test.controller;


import com.dsi.test.exception.InvalidAgeException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by A.A.MAMUN on 6/4/2020.
 */

@RestController
@RequestMapping("/aspect/test")
public class TestController {

    /**
     * AOP (Aspect-Oriented Programming) is a programming pattern
     * that increases modularity by allowing the separation of
     * the cross-cutting concern. The cross-cutting concern is a
     * concern that we want to implement in multiple places in
     * an application. It affects the entire application.
     */

    /**
     * There are five types of AOP advices are as follows:
     * Before Advice
     * After Advice
     * Around Advice
     * After Throwing
     * After Returning
     */

    @RequestMapping(value = "/before")
    public String testBeforeAdvice(){

        System.out.println("|  This is second message. Don't worry first message comes from Test Aspect.   |");
        System.out.println("|------------------------------------------------------------------------------|");

        return "Test Before Advice : Please check out the console, You can see two message. One of them comes from " +
                "'com.dsi.test.aspect.TestAspect.beforeAdvice()' method";
    }

    @RequestMapping(value = "/after")
    public String testAfterAdvice(){

        System.out.println("|------------------------------------------------------------------------------|");
        System.out.println("|  This is first message and the second message comes from our Test Aspect.    |");

        return "Test After Advice : Please check out the console, You can see two message. One of them comes from " +
                "'com.dsi.test.aspect.TestAspect.afterAdvice()' method";
    }

    @RequestMapping(value = "/around")
    public String testAroundAdvice(){

        System.out.println("| This is second message. First and Third messages are from our Test Aspect.   |");

        return "Test Around Advice : Please check out the console, You can see three message. Two of them comes from " +
                "'com.dsi.test.aspect.TestAspect.aroundAdvice()' method";
    }

    @RequestMapping(value = "/after-returning")
    public String testAfterReturningAdvice(@RequestParam int a, @RequestParam int b){

        int val = a / b;
        return "Test After Returning Advice : Division successfully complete without any exception as a result we get" +
                " a message from Test Aspect. Please open your console to see that message.";
    }

    @RequestMapping(value = "/after-throwing")
    public String testAfterThrowing(@RequestParam int age) throws InvalidAgeException {
        if(age < 18 || age > 100){
            throw new InvalidAgeException("Age "+age+" is invalid for vote.");
        }
        return "Test After Throwing : Age "+age+" is valid for vote. If you pass age > 100 or age < 18 then you will " +
                "get InvalidAgeException at that time 'After Throwing' aspect will execute.";
    }

}
