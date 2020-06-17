package com.udemycourse.springannotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
// @ComponentScan("com.udemycourse.springannotations")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	// define method to expose sad fortune service
	@Bean
	public FortuneService sadFortuneService () {
		return new SadFortuneService();
	}
	
	// define bean for swim coach AND inject dependencies
	// note that here we are actually calling the method
	@Bean
	public SwimCoach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
