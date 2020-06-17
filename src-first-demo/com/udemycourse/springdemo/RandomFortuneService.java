package com.udemycourse.springdemo;


public class RandomFortuneService implements FortuneService {

	@Override
	public String getFortune() { 
		
		String[] fortunes = {
			"There is ice cream in your future",
			"Beware those who may lead you astray",
			"Stay positive; there are things to look forward to"
		};
		return fortunes[(int) Math.floor(Math.random() * 3)];
	}

}
