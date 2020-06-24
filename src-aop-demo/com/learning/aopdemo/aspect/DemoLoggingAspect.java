package com.learning.aopdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(2)
public class DemoLoggingAspect {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Before("execution(public void com.learning.aopdemo.dao.AccountDAO.addAccount(..))")
	public void beforeAddAccountAdvice() {
		
		logger.info(getClass() + ": aspect work done here, specific to account DAO");
	}
	
	@Before("execution(public void add*())")
	public void beforeAnyAddMethod() {
		
		logger.info(getClass() + ": for any ADD method");
	}
	
	@Before("execution(* add*())")
	public void basedOnReturnType() {
		
		logger.info(getClass() + ": works for any return type for method name with 'add'");
	}
	
	@Before("execution(* add*(com.learning.aopdemo.Account))")
	public void basedOnParamType() {
		
		logger.info(getClass() + ": works for any method that takes Account class type param");
	}
	
	@Before("execution(* add*(com.learning.aopdemo.Account, ..))")
	public void basedOnOneOfManyParams() {
		
		logger.info(getClass() + ": works for any method that takes Account class type param");
	}
	
	@Before("execution(* add*(..))")
	public void basedOnAnyParam() {
		
		logger.info(getClass() + ": before anything!");
	}
	
	@Before("execution(* com.learning.aopdemo.dao.*.*(..))")
	public void basedOnPackage() {
		
		logger.info(getClass() + ": match on any class or method in the package!");
	}
	
	@Around("execution(* com.learning.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		// print out method
		String method = proceedingJoinPoint.getSignature().toShortString();
		logger.info("===> Executing @Around method: " + method);
		
		// get beginning timestamp
		long begin = System.currentTimeMillis();
		
		// execute method
		Object result = proceedingJoinPoint.proceed();
		
		// get ending timestamp, computing to find time
		long end = System.currentTimeMillis();
		
		logger.info("===> Finished method in  " + (end - begin / 1000) + " seconds");
		
		return result;
	}
	
	@Around("execution(* com.learning.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortuneHandleException(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		// print out method
		String method = proceedingJoinPoint.getSignature().toShortString();
		logger.info("===> Executing @Around method: " + method);

		Object result = null;
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Exception exc) {
			logger.warning("Uh oh! An exception was thrown: " +  exc.getMessage());
			result = "There was a major accident, but not to worry, a helicopter is coming for you";
		}
		
		logger.info("===> Finished method!");
		
		return result;
	}
	
}
