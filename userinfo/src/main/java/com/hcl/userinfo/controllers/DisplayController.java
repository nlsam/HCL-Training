package com.hcl.userinfo.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hcl.userinfo.entity.UserInfo;
import com.hcl.userinfo.services.UserInfoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class DisplayController {

	@Autowired
	private UserInfoService userInfoService;
	private 
	
    Logger logger = LoggerFactory.getLogger(DisplayController.class);

	
	@RequestMapping(value= "/index", method=RequestMethod.GET)
	public String showUser(ModelMap model,@RequestParam("id") int id) {
		
		
		logger.info("Getting User by Id");
		UserInfo users = userInfoService.GetUserById(id);
		List<UserInfo> userlist=new ArrayList<>();
		userlist.add(users);
				
		logger.info("Passing user to view");
	    model.addAttribute("users", userlist);    
		
        return "users";
    }
}
