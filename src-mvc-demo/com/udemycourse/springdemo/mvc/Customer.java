package com.udemycourse.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.udemycourse.springdemo.mvc.validation.CourseCode;


public class Customer {
	
	private String firstName;
	
	@NotNull(message="This field is required.")
	@Size(min=1, message="This field is required.")
	private String lastName;
	
    // place two annotations for a given range
    @Min(value=0, message="Value must be greater than or equal to zero.")
    @Max(value=10, message="Value must be less than or equal to 10.")
    @NotNull(message="This field is required.")
    private Integer freePasses;
    
    @Pattern(regexp="^[a-zA-Z0-9]{5}", message="Only 5 characters/digits allowed")
    private String postalCode;
    
    @CourseCode  // use defaults for value and message
    private String courseCode;
	
	public Customer() {
		// empty constructor
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
}
