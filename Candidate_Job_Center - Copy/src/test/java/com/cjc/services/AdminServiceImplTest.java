package com.cjc.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cjc.exceptions.JobDetailsNotFoundException;
import com.cjc.exceptions.SkillNotFoundException;
import com.cjc.pojos.JobDetails;
import com.cjc.service.AdminServiceImpl;


@SpringBootTest
class AdminServiceImplTest {

	
	@Autowired
	AdminServiceImpl service;
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@AfterEach
	void tearDown() throws JobDetailsNotFoundException {
		System.out.println("Clean up complete");
	}
	
	
	//Testing for add Job Details
    @Test
	public void addJobDetails(){
    	 
    	
    	JobDetails details= new JobDetails("Automation Tester","Selenium","http://localhost:9190/cja/swagger-ui.html","Barclays",4);
    	
    	JobDetails details2 = service.addJobDetails(details);
    	assertEquals(details, details2);
    	System.out.println(details2);
    	
		
	}
    
  
    
  
    
  //Testing for getting  Job Details by id
    @Test
	public void ViewJobDetailById() {
		int id = 1;
		JobDetails details = service.getJobById(id);
		assertEquals(id, details.getJobId());
	}
	
  //Testing for getting  Job Details by skills
    @Test
	public void ViewJobDetailBySkill() {
		String skillNeeded="Selenium";
		List<JobDetails> details = service.getJobBySkill(skillNeeded);
		for(JobDetails details2 : details) {
			System.out.println(details2);
		}
		assertNotNull(details);
	}
    
  //Testing for getting  Job Details
    @Test
	public void ViewAllJobDetails() {
		List<JobDetails> details = service.getAllJobDetails();
		assertTrue(!details.isEmpty());
		System.out.println("printing all JOb details");
	}
    
    // exceptions testcases
    
    
    @Test
	public void ViewJobDetailsByIdException() throws JobDetailsNotFoundException {
		int id = 900;
		assertThrows(JobDetailsNotFoundException.class, () -> service.getJobById(id));
	}
    
    //Testing for deleting  Job Details
    @Test
	public void deleteJObDetailsNotPresent() throws JobDetailsNotFoundException {
		int id = 129;
		assertThrows(JobDetailsNotFoundException.class, () -> service.deleteJob(id));
	}
    
    @Test
	public void ViewJobDetailsBySkillException() throws SkillNotFoundException {
		String skill = "html";
		assertThrows(SkillNotFoundException.class, () -> service.getJobBySkill(skill));
	}
    
    @Test
	public void ModifyJobDetailsException() throws JobDetailsNotFoundException {
 
    	
    	JobDetails details= new JobDetails(11,"Java Devloper","Java","http://localhost:9190/cja/swagger-ui.html","Barclays");
    	assertThrows(JobDetailsNotFoundException.class,()->service.updateJobDetails(details));
		
		
	}

  //Testing for updating Job Details
    @Test
	public void updateJobDetails() throws JobDetailsNotFoundException{
    	
    	JobDetails details= new JobDetails(1,"Automation Tester","Selenium","http://localhost:9190/cja/swagger-ui.html","Capgemini",4);
    	JobDetails details2 = service.updateJobDetails(details);
    	assertEquals(details.getCompany(), details2.getCompany());
		
		System.out.println("updated");

	}
}
