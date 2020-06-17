package com.udemycourse.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class CourseCodeConstraintValidator 
	implements ConstraintValidator<CourseCode, String>{

	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode courseCode) {
		coursePrefix = courseCode.value();
	}
	
	// in theory, you'd be able to do whatever you want here; based on own custom business logic
	@Override
	public boolean isValid(String code, ConstraintValidatorContext constaintValidatorContext) {
		
        boolean result;
        
        if (code != null) {
            result = code.startsWith(coursePrefix);
        } else {
            result = true;
        }
        return result;
	}

}
