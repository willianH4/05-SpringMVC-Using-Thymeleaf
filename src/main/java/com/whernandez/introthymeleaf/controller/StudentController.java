package com.whernandez.introthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.whernandez.introthymeleaf.model.Student;

@Controller
public class StudentController {

	@GetMapping("/showStudentForm")
	public String showForm(Model model) {
		
		// create a student object
		Student theStudent = new Student();
		
		// Add a student object to the model
		model.addAttribute("student", theStudent);
		
		return "student-form";
		
	}
	
	@PostMapping("/processStudentForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		// log the input data
		System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());
		
		return "student-confirmation";
	}
	
}
