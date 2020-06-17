package com.udemycourse.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/hello")  // high level mapping, sub-mappings beneath
public class HelloWorldController {
	
	// controller to show initial form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	
	// controller to process the form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// new controller method to read form data 
	// and add to the model
	@RequestMapping("/processFormVersionTwo")
	public String processFormVersionTwo(HttpServletRequest request, Model model) {
		
		// read the request parameter from HTML form
		String name = request.getParameter("studentName");
		
		// convert data and create message
		String result = "HELLO, " + name.toUpperCase() + "!";

		// add new attribute to model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	// make use of Spring annotation to read form parameter from request
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(
			@RequestParam("studentName") String name, 
			Model model) {
		
		// convert data and create message
		String result = "Hey there! Nice to meet you, " + name.toUpperCase() + "!";

		// add new attribute to model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
}

