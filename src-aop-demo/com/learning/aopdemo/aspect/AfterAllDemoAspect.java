package com.learning.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AfterAllDemoAspect {

	@After("execution(* com.learning.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterReturningDoSomething(JoinPoint joinPoint) {

		String method = joinPoint.getSignature().toShortString();

		System.out.println("===> Executing @After(Finally) on method: " + method);
	}
}
