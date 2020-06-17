package com.udemycourse.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// retrieve beans from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);		
		
		// check if these are currently the same objects by comparing their references
		boolean result = (theCoach == alphaCoach);  // are they pointing to same memory location?
		
		// print results
		System.out.println("\nAre they pointing to the same object? " + result);
		System.out.println("Memory location for theCoach: " + theCoach);
		System.out.println("Memory location for alphaCoach: " + alphaCoach + "\n");
	
		// close context
		context.close();
	}
}
