package com.learning.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learning.aopdemo.service.TrafficFortuneService;


public class MainDemoAppAround {

	public static void main(String[] args) {
		
		// read spring configuration java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get bean from spring container
		TrafficFortuneService trafficService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);

		System.out.println("Your fortune: " + trafficService.getFortune());
		
		context.close();
	}

}
