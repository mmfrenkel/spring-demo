package com.udemycourse.springdemo;


public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;


	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() { 
		return "Just do it! " + fortuneService.getFortune();
	}

	// add init method -- bean creation
	public void doMyStartUpStuff() {
		System.out.println("TrackCoach: Do my startup stuff!");
	}
	
	// add destroy method -- bean destruction
	public void doMyCleanUpStuff() {
		System.out.println("TrackCoach: Do my clean up stuff!");
	}
}

