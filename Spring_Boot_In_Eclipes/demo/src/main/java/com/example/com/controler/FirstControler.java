package com.example.com.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstControler {
	
	@ResponseBody
	@GetMapping("/test")
	public String First() {
		return "Hello World";
	}

}
