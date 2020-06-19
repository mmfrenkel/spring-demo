package com.learning.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learning.aopdemo.dao.AccountDAO;
import com.learning.aopdemo.dao.MembershipDAO;


public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring configuration java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// run the business logic
		Account account = new Account("Meg", "Premium");
		
		accountDAO.addAccount(account);
		accountDAO.addInfo(true);
		accountDAO.setServiceCode("1234serviceCode");
		
		membershipDAO.addAccount();
		
		context.close();
	}

}
