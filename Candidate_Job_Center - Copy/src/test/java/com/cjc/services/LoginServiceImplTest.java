package com.cjc.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cjc.exceptions.LoginNotFoundException;
import com.cjc.pojos.Login;
import com.cjc.service.LoginServiceImpl;

@SpringBootTest
class LoginServiceImplTest {

	@Autowired
	LoginServiceImpl service;
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@AfterEach
	void tearDown() throws LoginNotFoundException {
		System.out.println("Clean up complete");
	}
	
	@Test
	 void addLogin() {
		Login login = new Login("Sushma@gmail.com","Sushma@123");
		Login login2 = service.addlogin(login);
		assertEquals(login, login2);
	}
}
