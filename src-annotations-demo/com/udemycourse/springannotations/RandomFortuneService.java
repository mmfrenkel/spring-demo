package com.udemycourse.springannotations;

import java.util.Random;

import org.springframework.stereotype.Component;


@Component
public class RandomFortuneService implements FortuneService {
	
	// create an array of strings
	private String[] fortunes = {
		"This is a great fortune",
		"Beware of the night moon",
		"Do you trust your own instincts?"
	};
	
	private Random randomNumbers = new Random();

	@Override
	public String getFortune() { 
		
		// built in random number generator
		int index = randomNumbers.nextInt(fortunes.length);
		return fortunes[index];
	}

}
