package com.smart.user.controler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.sql.Blob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.smart.dao.UserDao;
import com.smart.entities.Contact;
import com.smart.entities.User;

@Controller
@RequestMapping("/user")
public class UserControler {

	@Autowired
	private UserDao userRepositary;

	@ModelAttribute
	public void addCommonData(Model model, Principal principal) {
		String userName = principal.getName();
		User user = userRepositary.getUserByUserName(userName);
		model.addAttribute("user", user);

	}

	@GetMapping("/dashboard")
	public String user(Model model) {
		model.addAttribute("Dashboard ,Contact Dashboard ");
		return "normal_user/user_dashboard";
	}

	@GetMapping("/add-contact")
	public String addContact(Model model) {
		model.addAttribute("contact", new Contact());
		return "normal_user/add_contact";
	}

	@PostMapping("/process-contact")
	public String processContact(@ModelAttribute Contact contact, @RequestParam("userImage") MultipartFile filePart,
			Principal principal) {

		String userName = principal.getName();
		User user = this.userRepositary.getUserByUserName(userName);
		// processing and uploading file

		// file the file to folder and update the name to contact
		try {
			contact.setImage(filePart.getBytes());
			File saveFile = new ClassPathResource("static/img").getFile();
			Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + filePart.getOriginalFilename());
			Files.copy(filePart.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		user.getContact().add(contact);

		contact.setUser(user);

		this.userRepositary.save(user);

		System.out.println("Data " + contact);

		System.out.println("Added to database!");

		return "normal_user/add_contact";
	}
}
