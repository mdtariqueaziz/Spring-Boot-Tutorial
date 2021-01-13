package com.example.com.JSPViewInSpringBoot.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controler {
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/student")
	public String student() {
		return "student";
	}

}
