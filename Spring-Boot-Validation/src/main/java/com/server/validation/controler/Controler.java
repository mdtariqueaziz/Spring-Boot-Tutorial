package com.server.validation.controler;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.server.validation.loginData.LoginData;

@Controller
public class Controler {
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("loginData",new LoginData());
		return "form";
	}
	 @PostMapping("/process")
	public String process(@Valid @ModelAttribute("loginData") LoginData loginData,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "form";
		}
		 System.out.println(loginData);
		return "success";
		
	}

}
