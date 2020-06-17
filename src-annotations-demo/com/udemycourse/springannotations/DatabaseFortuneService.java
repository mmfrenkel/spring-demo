package com.udemycourse.springannotations;

import org.springframework.stereotype.Component;


@Component
public class DatabaseFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "This is a fortune from a database service";
	}

}
