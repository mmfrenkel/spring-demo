package com.learning.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learning.aopdemo.dao.AccountDAO;


public class MainDemoAppAfterReturning {

	public static void main(String[] args) {
		
		// read spring configuration java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// demo the @AfterReturning method
		List<Account> accounts = accountDAO.findAccounts();
		
		context.close();
	}

}
