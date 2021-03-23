package com.hcl.userauthentication.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hcl.userauthentication.entities.Euser;
import com.hcl.userauthentication.exceptions.UserNotFoundException;
import com.hcl.userauthentication.services.EuserService;

@Controller
public class LoginController {
	
	@Autowired
	EuserService euserservice;

	@GetMapping("/")
    public String showHomePage(ModelMap map) {
        return "home";
    }


    @PostMapping("/home")
    public String submitLogin(ModelMap model, @RequestParam("username") String username, @RequestParam("password") String password){
         String message=euserservice.loginUser(username,password);
         model.addAttribute("name", message);  
        return "success";
}
}
