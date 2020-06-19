package com.learning.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;


public class AfterThrowingDemoAspect {

	@AfterThrowing(
			pointcut="execution(* com.learning.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="exc"
			)
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, 
			Throwable exc) {

		String method = joinPoint.getSignature().toShortString();

		System.out.println("===> Executing @AfterThrowing on method: " + method);
		System.out.println("===== Exception is: " + exc);
	}
}
