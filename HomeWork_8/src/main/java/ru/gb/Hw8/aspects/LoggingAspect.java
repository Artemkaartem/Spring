package ru.gb.Hw8.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import ru.gb.Hw8.services.AnimalService;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(AnimalService.class.getName());

    @Around(value = "@annotation(ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

        System.out.println("Method " + methodName +
                " with parameters " + Arrays.asList(arguments) +
                " will execute");

        Object returnByMethod = joinPoint.proceed();
        System.out.println("Method complete");
        return returnByMethod;
    }

    @Around(value = "@annotation(ToLog)")
    public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() -start;
        System.out.println("Method: "+joinPoint.getSignature().getName() + " - "+elapsedTime+" millis");
        return result;
    }
}