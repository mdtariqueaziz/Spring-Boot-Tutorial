package com.smart.user.controler;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.dao.UserDao;
import com.smart.entities.User;
import com.smart.helper.Message;

@Controller
public class HomeControler {
	@Autowired
	private BCryptPasswordEncoder paasswordEncoder;
	
	@Autowired
	private UserDao userRepositary;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "this is home page");
		return "home";
	}

	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "this is about page");
		return "about";
	}

	@GetMapping("/signup")
	public String singup(Model model) {
		model.addAttribute("title", "this is singup page");
		model.addAttribute("user", new User());
		return "signup";
	}

	@GetMapping("/signin")
	public String login(Model model) {
		model.addAttribute("login", "this is login page");
		return "login";
	}

	@PostMapping("/do_register")
	public String registre(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model,
			HttpSession session) {
		try {
			if (bindingResult.hasErrors()) {
				System.out.println(bindingResult);
				model.addAttribute("user", user);
				return "signup";
			}
			if (!agreement) {
				System.out.println("You are not agreed terms and conditions");
				throw new Exception("You are not agreed terms and conditions");

			}

			user.setRole("ROLE_USER");
			user.setEnabled(true);
			user.setImageUrl("MyImage");
			user.setPassword(paasswordEncoder.encode(user.getPassword()));
			
			
			User result = this.userRepositary.save(user);
			model.addAttribute("user", new User());
			System.out.println(agreement);
			System.out.println(user);
			session.setAttribute("message", new Message("Successfully registered", "alert-success"));
			return "signup";

		} catch (Exception e) {
			e.getMessage();
			model.addAttribute("user", user);
			session.setAttribute("message", new Message("Somethong went wrong " + e.getMessage(), "alert-danger"));
			return "signup";
		}

	}
	
	@GetMapping("/login-fail")
	public String loginFail() {
		return "login-fail";
	}

}
