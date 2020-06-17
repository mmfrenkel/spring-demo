package com.udemycourse.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	private String emailAddress;
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside a setter method for emailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside a setter meothod for team");
		this.team = team;
	}

	private String team;
	
	//create no argument constructor
	public CricketCoach() {
		System.out.println("CricketCoach: inside no arg constructor");
	}
	
	// setter method called by spring to inject dependency
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside a setter method for fortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
