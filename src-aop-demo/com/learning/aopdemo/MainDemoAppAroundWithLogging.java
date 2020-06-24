package com.learning.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learning.aopdemo.service.TrafficFortuneService;


public class MainDemoAppAroundWithLogging {

	private static Logger logger = 
			Logger.getLogger(MainDemoAppAroundWithLogging.class.getName());
	
	public static void main(String[] args) {
		
		logger.info("Starting main application...");
		
		// read spring configuration java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		

		// get bean from spring container
		TrafficFortuneService trafficService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);

		logger.info("Getting a new fortune...");
		logger.info("Your fortune: " + trafficService.getFortune());
		
		context.close();
	}

}
