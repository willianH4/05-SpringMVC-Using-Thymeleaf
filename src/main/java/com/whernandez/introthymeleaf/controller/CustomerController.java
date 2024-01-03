package com.whernandez.introthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.whernandez.introthymeleaf.model.Customer;

import jakarta.validation.Valid;

@Controller
public class CustomerController {

	@GetMapping("/")
	public String showForm(Model theModel) {
		
		theModel.addAttribute("customer", new Customer());
		
		return "customer-form";
		
	}
	
	@PostMapping("/processCustomerForm")
	public String processCustomerForm(
			@Valid Customer theCustomer, 
			BindingResult theBindingResult) {
		
		if (theBindingResult.hasErrors()) {
			return "customer-form";
		}
		else {
			return "customer-confirmation";
		}
		
	}
	
}
