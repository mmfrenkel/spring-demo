package com.learning.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(2)
public class DemoLoggingAspect {
	
	@Before("execution(public void com.learning.aopdemo.dao.AccountDAO.addAccount(..))")
	public void beforeAddAccountAdvice() {
		
		System.out.println(getClass() + ": aspect work done here, specific to account DAO");
	}
	
	@Before("execution(public void add*())")
	public void beforeAnyAddMethod() {
		
		System.out.println(getClass() + ": for any ADD method");
	}
	
	@Before("execution(* add*())")
	public void basedOnReturnType() {
		
		System.out.println(getClass() + ": works for any return type for method name with 'add'");
	}
	
	@Before("execution(* add*(com.learning.aopdemo.Account))")
	public void basedOnParamType() {
		
		System.out.println(getClass() + ": works for any method that takes Account class type param");
	}
	
	@Before("execution(* add*(com.learning.aopdemo.Account, ..))")
	public void basedOnOneOfManyParams() {
		
		System.out.println(getClass() + ": works for any method that takes Account class type param");
	}
	
	@Before("execution(* add*(..))")
	public void basedOnAnyParam() {
		
		System.out.println(getClass() + ": before anything!");
	}
	
	@Before("execution(* com.learning.aopdemo.dao.*.*(..))")
	public void basedOnPackage() {
		
		System.out.println(getClass() + ": match on any class or method in the package!");
	}
	
}
