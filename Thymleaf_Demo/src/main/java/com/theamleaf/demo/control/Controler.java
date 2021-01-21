package com.theamleaf.demo.control;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controler {

	@GetMapping("/test")
	public String demo(Model model) {
		model.addAttribute("name", "Tarique Aziz");
		model.addAttribute("currentDate", new java.util.Date());
		return "about";

	}

	@GetMapping("/examle-loop")
	public String iteratorExample(Model model) {
		ArrayList<String> fruits = new ArrayList<String>();
		fruits.add("Apple");
		fruits.add("Orange");
		fruits.add("Papaya");
		fruits.add("Mango");
		fruits.add("PineApple");
		model.addAttribute("fruitsName", fruits);
		return "iterator";

	}

	@GetMapping("/condition")
	public String condition(Model model) {
		model.addAttribute("isActive", false);
		model.addAttribute("gender","F");

		return "condition";
	}
	@GetMapping("/services")
	public String services(Model model) {
		model.addAttribute("firstName","Azhar");
		model.addAttribute("lastName","Khan");
		return "services";
	}

}
