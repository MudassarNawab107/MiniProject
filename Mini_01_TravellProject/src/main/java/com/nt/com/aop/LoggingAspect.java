package com.nt.com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
	int counter =0;
	@SneakyThrows
	@Before("execution(* com.nt.com..*(..))") // Change to your package
    public void logBefore(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();  
        log.error("Entering method::::: {} of class:::: {} :::::counter:::{}", methodName, className,counter);  
        //log.error("Argument: {}", new ObjectMapper().writeValueAsString(joinPoint.getArgs()) );
        counter++;     
    }
	
	@After("execution(* com.nt.com..*(..))") // Adjust to your package
    public void logAfter() {
        // Reset the counter after the method execution
        counter = 0;
    }
	
	@SneakyThrows
    @Around("@annotation(logExecutionTime)") // Intercept methods with @LogExecutionTime
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint, LogExecutionTime logExecutionTime) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();

        long startTime = System.currentTimeMillis();
       
        Object result = joinPoint.proceed(); // Proceed to the actual method

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        log.error("Exiting method: {} of class: {}. Execution time: {} ms", methodName, className, executionTime);

        return result; // Return the result from the method
    }
}
