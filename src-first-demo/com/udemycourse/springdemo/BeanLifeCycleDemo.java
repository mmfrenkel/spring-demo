package com.udemycourse.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BeanLifeCycleDemo {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		// retrieve beans from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class); 		
		
		// use the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// close context
		context.close();
	}
}
