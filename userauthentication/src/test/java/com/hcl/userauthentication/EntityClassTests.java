package com.hcl.userauthentication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import com.hcl.userauthentication.entities.Euser;

import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;



@DataJpaTest
public class EntityClassTests {
    
	@Test
	public void nameTest() {
		String name="Test";
		String username="test@gmail.com";
		String password="testpassword";
		Euser testUser= new Euser();
		testUser.setName(name);
		testUser.setUsername(username);
		testUser.setPassword(password);
		assertEquals(testUser.getName(),name);
	}
	@Test 
	public void usernameTest() {
		String name="Test";
		String username="test@gmail.com";
		String password="testpassword";
		Euser testUser= new Euser();
		testUser.setName(name);
		testUser.setUsername(username);
		testUser.setPassword(password);
		assertEquals(testUser.getUsername(),username);	
	}
	
	@Test
	public void passwordTest() {
		String name="Test";
		String username="test@gmail.com";
		String password="testpassword";
		Euser testUser= new Euser();
		testUser.setName(name);
		testUser.setUsername(username);
		testUser.setPassword(password);
		assertEquals(testUser.getPassword(),password);
	}
   
    

}
