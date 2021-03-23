package com.hcl.userauthentication;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;


import com.hcl.userauthentication.entities.Euser;
import com.hcl.userauthentication.services.EuserService;
import com.hcl.userauthentication.controllers.LoginController;
import com.hcl.userauthentication.exceptions.UserNotFoundException;

import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@Import({EuserService.class,Euser.class,UserNotFoundException.class})
public class ServiceMethodTests {
	
	@Autowired
	private EuserService euserService;
	
	@Test
	public void userSearchTest_ValidInput() {
		
		String name="Test";
		String username="test@gmail.com";
		String password="testpassword";
		Euser testUser= new Euser();
		testUser.setName(name);
		testUser.setUsername(username);
		testUser.setPassword(password);
		euserService.saveUser(testUser);
		String testName=euserService.loginUser(username,password);
		assertEquals(testName,name);	
	}
	
	@Test
     public void userSearchTest_InvalidInput() {
		assertThrows(UserNotFoundException.class,() ->{
		String name="Test";
		String username="test@gmail.com";
		String password="testpassword";
		String wrongUsername="wrong";
		String wrongPassword="wrongpass";
		Euser testUser= new Euser();
		testUser.setName(name);
		testUser.setUsername(username);
		testUser.setPassword(password);
		euserService.saveUser(testUser);
		String testName=euserService.loginUser(wrongUsername,wrongPassword);
		});
	}

}
