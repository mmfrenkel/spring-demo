package com.udemycourse.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AnotherController {
	
	@RequestMapping("/showForm")
	public String displayTheForm() {
		return "Here is a form!";
	}
}
