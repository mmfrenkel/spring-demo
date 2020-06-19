package com.learning.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.learning.aopdemo.Account;

@Aspect
@Component
public class AfterReturningDemoAspect {

	// advice for @AfterReturning on findAccounts() method
	@AfterReturning(
			pointcut="execution(* com.learning.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result"
			)
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, 
			List<Account> result) {

		String method = joinPoint.getSignature().toShortString();

		System.out.println("===> Executing @AfterReturning on method: " + method);
		System.out.println("===== Result is: " + result);
	}
	
	@AfterReturning(
			pointcut="execution(* com.learning.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result"
			)
	public void modifyingReturnValueDamo(JoinPoint joinPoint, 
			List<Account> result) {

		String method = joinPoint.getSignature().toShortString();
		
		// post process the data -- convert account names to upper case
		convertAccountNamesToUpperCase(result);

		System.out.println("===> Executing @AfterReturning on method: " + method);
		System.out.println("===== Result (post-processing) is: " + result);
	}

	/*
	 * Helper method
	 */
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		for (Account account: result) {
			
			String uppercaseName = account.getName().toUpperCase();
			account.setName(uppercaseName);
		}
	}
	
}
