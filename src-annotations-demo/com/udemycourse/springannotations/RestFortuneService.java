package com.udemycourse.springannotations;

import org.springframework.stereotype.Component;


@Component
public class RestFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "This is a REST Fortune Service fortune";
	}

}
