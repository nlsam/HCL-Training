package com.hcl.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
	
	@GetMapping("/")
	public String home() {
		return("<h1> Please log in</h1>");
	}
	@GetMapping("/user")
	public String user() {
		return("<h1>welcome User</h1>");
	}
	@GetMapping("/admin")
	public String admin() {
		return("<h1>welcome Admin</h1>");
	}
}
