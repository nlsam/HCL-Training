package com.hcl.taskmanager.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hcl.taskmanager.entities.EndUser;
import com.hcl.taskmanager.exceptions.UserNotFoundException;
import com.hcl.taskmanager.services.EndUserService;

@Controller
public class MainController {

	@Autowired
	private EndUserService endUserService;

	Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@PostMapping(value = "/register")
	public String register(ModelMap model, @RequestParam("firstname") String firstName,
			@RequestParam("lastname") String lastName, @RequestParam("email") String email,
			@RequestParam("username") String username, @RequestParam("password") String password) {

		logger.info("About to register user");
		EndUser newEndUser = new EndUser();
		newEndUser.setFirstName(firstName);
		newEndUser.setLastName(lastName);
		newEndUser.setEmail(email);
		newEndUser.setUsername(username);
		newEndUser.setPassword(password);
		List <EndUser> resultList = endUserService.userSearch(username, password);
		if(resultList.size()==0) {
			endUserService.saveUser(newEndUser);
		logger.info("User registered.");
		model.addAttribute("firstname", firstName);
		model.addAttribute("lastname", lastName);
       	return "home";
		}
		else {
			logger.info("User not registered.");
			String message="An account with that username and password already exists.";
			model.addAttribute("result", message);
	       	return "register";
		}

	}
	
	@PostMapping(value="/login")
	public String login(ModelMap model, @RequestParam("username") String username, @RequestParam("password") String password) {
		logger.info("About to login user");
		List <EndUser> resultList = endUserService.userSearch(username, password);
		if(resultList.size()!=0) {
			logger.info("Logged in");
			String firstName=null;
		    String lastName=null;
			for(EndUser p:resultList) {
				firstName=p.getFirstName(); 
				lastName=p.getLastName();
			}
			model.addAttribute("firstname", firstName);
			model.addAttribute("lastname", lastName);
			return "home";
		}
		else {
			logger.info("Login fail");
			String message="Login failed.";
			model.addAttribute("message", message);
			return "login";
		}
	}
}
