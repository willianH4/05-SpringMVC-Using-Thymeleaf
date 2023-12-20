package com.whernandez.introthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

	// new a controller method to show install HTML form
	@GetMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// need a controller method to process the HTML form
	@GetMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	 // Need a controller method to read form data and
	// add data to the model
	
	@GetMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		// read the request parameter from HTML form
		String theName = request.getParameter("studentName");
		
		// convert the data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Yo!!!" + theName;
		
		// add mesage to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
}
