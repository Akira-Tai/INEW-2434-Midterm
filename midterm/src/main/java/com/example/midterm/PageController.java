package com.example.midterm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	@GetMapping("/")
	String displayHome() {
		return "index";
	}
	
	@GetMapping("/terminology")
	String displayTerminology() {
		return "terminology";
	}
	
	@GetMapping("/students")
	String displayStudents() {
		return "students";
	}
}