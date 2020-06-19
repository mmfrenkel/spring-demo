package com.learning.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.learning.aopdemo.Account;

@Order(1)
@Aspect
@Component
public class CloudLogAspect {

	/*
	 * Use point cut declarations instead of one by one. You can combine point cut expressions!
	 */
	@Before("com.learning.aopdemo.aspect.AppExpressions.forDAOPackage()")
	private void basedOnPackageByPointCut() {
		
		System.out.println(getClass() + ": using pointcut declaration "
				+ "for any class/method in package!");
	}
	
	// apply to the advice
	@Before("com.learning.aopdemo.aspect.AppExpressions.forDaoPackageNotGetterSetter()")
	public void usingCombinedPointcuts(){
		
		System.out.println(getClass() + ": combined pointcut expression "
				+ "for all but getters and setters!");
	}
	
	/*
	 * Use Join Points to get method parameters; joinPoint provides us with metadata
	 */
	// apply to the advice
	@Before("com.learning.aopdemo.aspect.AppExpressions.forDaoPackageNotGetterSetter()")
	public void demoJoinPoints(JoinPoint joinPoint){
		
		// display method signature
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method: " + signature);
		
		// display method argument
		Object[] args = joinPoint.getArgs();
		
		for (Object o: args) {
			
			System.out.println("Argument: " + o);
			
			if (o instanceof Account) {
				Account account = (Account) o;
				System.out.println("Account Name: " + account.getName());
			}
		}
		
	}
	
}
