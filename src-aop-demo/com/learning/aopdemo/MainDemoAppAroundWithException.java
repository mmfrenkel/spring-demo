package com.learning.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learning.aopdemo.service.TrafficFortuneService;


public class MainDemoAppAroundWithException {

	private static Logger logger = 
			Logger.getLogger(MainDemoAppAroundWithException.class.getName());
	
	public static void main(String[] args) {
		
		boolean tripWire = true;
		
		logger.info("Starting main application...");
		
		// read spring configuration java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		

		// get bean from spring container
		TrafficFortuneService trafficService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);

		logger.info("Getting a new fortune...");
		logger.info("Your fortune: " + trafficService.getFortune(tripWire));
		
		context.close();
	}

}
