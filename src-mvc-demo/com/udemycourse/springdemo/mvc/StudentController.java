package com.udemycourse.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/student")
public class StudentController {
	
	// create a method for showing the form
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		// create a new student object
		Student newStudent = new Student();
		
		// add student object as model attribute
		model.addAttribute("student", newStudent);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student newStudent) {
		
		// make sure its working
		System.out.println("New Student: " + newStudent.getFirstName());
		
		return "student-confirmation";
	}
}
