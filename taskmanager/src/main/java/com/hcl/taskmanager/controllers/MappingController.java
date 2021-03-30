package com.hcl.taskmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MappingController {
	@GetMapping("/")
	public String showHomePage(ModelMap map) {
		return "index";
	}
	@GetMapping("/loginc")
	public String showLoginPage(ModelMap map) {
		return "login";
	}
	@GetMapping("/registerc")
	public String showRegisterPage(ModelMap map) {
		return "register";
	}
	@GetMapping("/create")
	public String showCreatePage(ModelMap map) {
		return "createtask";
	}
	@GetMapping("/delete")
	public String showDeletePage(ModelMap map) {
		return "deletetask";
	}
	@GetMapping("/update")
	public String showUpdatePage(ModelMap map) {
		return "updatetask";
	}
	@GetMapping("/logout")
	public String showLogOutPage(ModelMap map) {
		return "index";
	}
}
