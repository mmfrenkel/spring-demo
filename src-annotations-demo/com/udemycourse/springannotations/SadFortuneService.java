package com.udemycourse.springannotations;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is a rainy day";
	}
}
