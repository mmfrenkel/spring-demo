package com.udemycourse.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller  // this is an MVC controller
public class HomeController {

	@RequestMapping("/")
	public String showPage() {
		return "main-menu"; // making use of configuration file where prefix and suffix are added
	}
}
