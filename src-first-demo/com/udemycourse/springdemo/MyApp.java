package com.udemycourse.springdemo;

public class MyApp {

	public static void main(String[] args) {
		Coach theCoach = new TennisCoach();
		
		// code to interface to allow any implementation
		System.out.println(theCoach.getDailyWorkout());
	}

}
