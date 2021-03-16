package com.hcl.userinfo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hcl.userinfo.entity.UserInfo;
import com.hcl.userinfo.services.UserInfoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class FindController {
	
	@Autowired
	private UserInfoService userInfoService;
		
    Logger logger = LoggerFactory.getLogger(FindController.class);

	
	@RequestMapping(value= "/users", method=RequestMethod.GET)
	public String updateUsers(ModelMap model,@RequestParam("id") int id, @RequestParam("name") String name, 
			@RequestParam("email") String email,@RequestParam("color") String favColor) {
			
		logger.info("About to update user");
		UserInfo userupdate = userInfoService.GetUserById(id);
		userupdate.setName(name);
		userupdate.setEmail(email);
		userupdate.setFavColor(favColor);
		userInfoService.UpdateUser(userupdate);
		String result="Successfully Updated"; 
		logger.info("User Updated");
	    model.addAttribute("result", result);     
		
        return "update";
	

}
}
