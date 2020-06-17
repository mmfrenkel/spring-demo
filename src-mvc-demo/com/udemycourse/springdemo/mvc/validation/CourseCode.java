package com.udemycourse.springdemo.mvc.validation;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.validation.Constraint;
import javax.validation.Payload;


@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target( {ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

	// define the attributes you can pass into your annotation
	
	// define default course code
	public String value() default "CU";
	
	// define default error message
	public String message() default "Must start with CU";
	
	// define default groups  -- group constraints together
	public Class<?>[] groups() default {};
	
	// define default payload -- additional info
	public Class<? extends Payload>[] payload() default {};
}
