package com.example.mts.aspects;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static Logger logger = Logger.getLogger("MTS");

//	@Before("execution(* *(..))")
//	public void doLogBefore(JoinPoint joinPoint) {
//		logger.info(joinPoint.getSignature().toShortString() +" invoked with "+Arrays.toString(joinPoint.getArgs()));
//	}
	
	
	@Around("execution(* *(..))")
	public void doLogAround(ProceedingJoinPoint joinPoint) {

		try {
			logger.info(joinPoint.getSignature().toShortString() + " invoking with "+ Arrays.toString(joinPoint.getArgs()));
			joinPoint.proceed();
			logger.info(joinPoint.getSignature().toShortString() + " invoked successfully");
		} catch (Throwable e) {
			logger.info(joinPoint.getSignature().toShortString() + " failed.");
		}
		logger.info(joinPoint.getSignature().toShortString() + " method-end");

	}

}
