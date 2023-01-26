package com.cjc.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cjc.exceptions.CandidateNotFoundException;
import com.cjc.exceptions.LoginNotFoundException;
import com.cjc.exceptions.PasswordIncorrectException;
import com.cjc.exceptions.SecurityCodeNotFoundException;
import com.cjc.pojos.Candidate;
import com.cjc.pojos.Login;
import com.cjc.pojos.Skills;
import com.cjc.service.CandidateServiceImpl;

@SpringBootTest
class CandidateServiceImplTest {

	@Autowired
	CandidateServiceImpl service;
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@AfterEach
	void tearDown() throws CandidateNotFoundException {
		System.out.println("Clean up complete");
	}
	
	//Testing for add candidate Details
  @Test
	public void addCandidateDetails(){
    	 
    	List<Skills> skillList=  new ArrayList<>();
    	Skills skill= new Skills("XML");
    	skillList.add(skill);
    	Login login= new Login("Sunkara@gmail.com","Sun#123","Sky");
    	Candidate details= new Candidate("9867568865", "Sunkara@gmail.com", skillList, login);
    	Candidate details2 = service.addCandidate(details);
    	assertEquals(details, details2);
    	System.out.println("added");
    	
		
	}
	
	//Testing for updating Job Details
    @Test
	public void updateCandidateDetails() throws CandidateNotFoundException{
    	
    	List<Skills> skillList=  new ArrayList<>();
    	Skills skill= new Skills(174,"SAP");
    	skillList.add(skill);
    	Login login= new Login("Junnuri.Sri@gmail.com","Junnuri#123","Jung");
    	Candidate details= new Candidate(173,"9848361782", "Junnuri.Sri@gmail.com", skillList, login);
    	Candidate details2 = service.addCandidate(details);
    	assertEquals(details.getPhoneNumber(), details2.getPhoneNumber());
		System.out.println("updated");

	}
	
		//Checking  the changePassword case 
	@Test
	public void changePassword(){
		String userId = "Lakshmi@gmail.com";
		String oldPassword = "Lakshmi@123";
		String newPassword = "Lakshmi#123";
		String returned = service.changePassword(userId, oldPassword, newPassword);
		assertEquals("Password Changed Successfully", returned);
		System.out.println("updated");

	}
	
			//Checking  the forgotPassword case 
	@Test
	public void forgotPassword(){
		String userId = "Kranthi@gmail.com";
		String security = "Kim";
		String newPassword = "Kranthi#123";
		String returned = service.forgotPassword(userId, security, newPassword);
		assertEquals("Password Changed Successfully", returned);
		System.out.println("updated");

	}
    
	
	//Testing for updating Job Details exception case
	 @Test
		public void ModifyCandidateDetailsException() throws CandidateNotFoundException {
	 
		 List<Skills> skillList=  new ArrayList<>();
	    	Skills skill= new Skills(111,"Java");
	    	skillList.add(skill);
	    	Login login= new Login("sri@gmail.com","sri@123");
	    	Candidate details= new Candidate(11,"9878678999", "sri12@gmail.com", skillList, login);
	    		    	
	    	assertThrows(CandidateNotFoundException.class,()->service.updateCandidate(details));
			
			
		}
	
	 //Testing for deleting  Candidate
    @Test
	public void deleteCandidateNotPresent() throws CandidateNotFoundException {
		int id = 12;
		assertThrows(CandidateNotFoundException.class, () -> service.deleteCandidate(id));
	}
    
	
	//Checking the Login Details
    @Test
	public void checkLogin() {
		String userId="Roja@gmail.com";
		String password="Roja#123";
		
		String login2=service.checklogin(userId, password);
		assertEquals("Login successful", login2);
		
	}
	
	//Testing the Login Details with Exceptions
	@Test
	public void checkLoginException() throws LoginNotFoundException {
		String userId="soiri@gmail.com";
		String password="sri@123";
		assertThrows(LoginNotFoundException.class, () -> service.checklogin(userId, password));
	}
	
	//Testing the Login Details with Incorrect Password Exceptions
	@Test
	public void checkLoginPasswordException() throws PasswordIncorrectException {
		String userId="Roja@gmail.com";
		String password="souri@123";
		assertThrows(PasswordIncorrectException.class, () -> service.checklogin(userId, password));
	}
    

	
	//Checking  the ChangePassword case with Exceptions
	@Test
	public void changePasswordException() throws LoginNotFoundException {
		String username = "rtyigh@gmail.com";
		String oldPassword="sai@789";
		String newPassword="Sai@789";
		assertThrows(LoginNotFoundException.class, () -> service.changePassword(username,oldPassword,newPassword));
	}
	
	//Checking  the ChangePassword case with Incorrect Password  Exceptions
		@Test
		public void changeIncorrectPasswordException() throws PasswordIncorrectException {
			String username = "Lakshmi@gmail.com";
			String oldPassword="sai@789";
			String newPassword="Sai@789";
			assertThrows(PasswordIncorrectException.class, () -> service.changePassword(username,oldPassword,newPassword));
		}
		
		//Checking  the forgotPassword case with Exceptions
		@Test
		public void forgotPasswordException() throws LoginNotFoundException {
			String username = "rtyigh@gmail.com";
			String security="sai@789";
			String newPassword="Sai@789";
			assertThrows(LoginNotFoundException.class, () -> service.changePassword(username,security,newPassword));
		}
		
		//Checking  theforgotPassword case with Incorrect Password  Exceptions
		@Test
		public void forgotIncorrectSecurityException() throws SecurityCodeNotFoundException {
			String username = "Lakshmi@gmail.com";
			String security="sai@789";
			String newPassword="Sai@789";
			assertThrows(SecurityCodeNotFoundException.class, () -> service.forgotPassword(username,security,newPassword));
		}


}
