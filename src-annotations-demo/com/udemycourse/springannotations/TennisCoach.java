package com.udemycourse.springannotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("singleton")
//@Scope("prototype") // new instance every time TennisCoach retrieved from Spring Container
public class TennisCoach implements Coach {

	// Field injection
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	// default constructor for debugging
	public TennisCoach() {
		System.out.println(">> Tennis Coach: inside default constructor");
	}
	
	@PostConstruct
	public void doStartUp() {
		System.out.println("Do my start up steps!");
	}
	
	@PreDestroy
	public void doCleanUp() {
		System.out.println("Do my clean up steps!");
	}
	
	//// @Autowired   // use for constructor injection
	//	 public TennisCoach(FortuneService fortuneService) {
	//	 	this.fortuneService = fortuneService;
	//	 }
	//	 
		
	//	@Autowired     // use for setter injection
	//	public void setFortuneService(FortuneService fortuneService) {
	//		this.fortuneService = fortuneService;
	//	}
	//	
	//	@Autowired    // method injection, just an example where no need to setter methods
	//	public void doSomethingCool(FortuneService fortuneService) {
	//		System.out.println("Inside do some cool things method!");
	//	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() { 
		return fortuneService.getFortune();
	}

}
