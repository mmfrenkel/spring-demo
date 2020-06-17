package com.udemycourse.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		model.addAttribute("customer", new Customer());
		
		return "customer-form";
	}
	
	
	//  Using validation of the last name field here.
	@RequestMapping("/processForm")
	public String processForm(
			
			// the @Valid attribute allows us to use all checks
			@Valid @ModelAttribute("customer") Customer customer,
			BindingResult bindingResult){
		
		if (bindingResult.hasErrors()) {
			return "customer-form";
		}
		
		return "customer-confirmation";
	}
	
	@InitBinder  // allows us to pre-process data; called for every web request to this controller
	public void initBinder(WebDataBinder dataBinder) {
	    
	    // this is a class defined in Spring API, trims strings. 
		// "true" will trim it down to null
	    StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
	    
	    // pre-process every string in form data, removing white-space
	    dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
}
