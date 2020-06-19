package com.learning.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class AppExpressions {
	
	// @Pointcut for getters
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void getter(){}

	// @Pointcut for setters
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void setter(){}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDAOPackage() {}
	
	// combine
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	public void forDaoPackageNotGetterSetter(){}
	
}
