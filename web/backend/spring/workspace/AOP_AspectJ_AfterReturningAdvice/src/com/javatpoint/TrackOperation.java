package com.javatpoint;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
  
@Aspect
public class TrackOperation {
    @AfterReturning(
              pointcut = "execution(* Operation.*(..))",  
              returning = "result")
                
    public void myadvice(JoinPoint jp, Object result) //it is advice (after returning advice)  
    {  
        System.out.println("AFTER-RETURNING: additional concern");
        System.out.println("Method Signature: "  + jp.getSignature());
        System.out.println("Result in advice: " + result);
        System.out.println("end of after returning advice...");
    }  
}
