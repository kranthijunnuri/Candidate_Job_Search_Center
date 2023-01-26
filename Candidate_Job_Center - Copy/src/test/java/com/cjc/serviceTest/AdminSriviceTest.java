package com.cjc.serviceTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.cjc.pojos.JobDetails;
import com.cjc.repositories.IJobDetailsDao;
import com.cjc.service.IAdminService;

class AdminSriviceTest {
	
	
	@InjectMocks
	IJobDetailsDao jobDetailsRepository;
	@Mock
	IAdminService adminService = org.mockito.Mockito.mock(IAdminService.class);
	

	@Test
	public void addJobDetails() {
		

		JobDetails jobDetails = new JobDetails(1,"SAP Developer", "SAP", "http://localhost:9190/swagger-ui.html#/", "Barclays",4.2);
		
			Mockito.when(adminService.addJobDetails(jobDetails)).thenReturn(jobDetails);
			JobDetails returnjobDetails = adminService.addJobDetails(jobDetails);
			assertEquals(jobDetails, returnjobDetails);
			System.out.println("Added Job Dteails : "+returnjobDetails);
			

		}
	
	@Test
	public void updateJobDetailsTest() {
		
		JobDetails jobDetails = new JobDetails(1,"SAP Developer", "SAP", "http://localhost:9190/swagger-ui.html#/", "Capgemini",4.2);
		
		Mockito.when(adminService.updateJobDetails(jobDetails)).thenReturn(jobDetails);
		JobDetails returnjobDetails = adminService.updateJobDetails(jobDetails);
		assertEquals(jobDetails, returnjobDetails);
		System.out.println("Updated feild : "+returnjobDetails);
		
	}
	
	@Test
	public void getAllJobDetailsTest() {
		
		JobDetails jobDetails1 = new JobDetails(1,"SAP Developer", "SAP", "http://localhost:9190/swagger-ui.html#/", "Capgemini",4.2);
		
		JobDetails jobDetails2 = new JobDetails(2,"Automation Tester", "Selenium", "http://localhost:9190/swagger-ui.html#/", "Barclays",3.2);
		
		JobDetails jobDetails3 = new JobDetails(3,"JAVA Developer", "Java", "http://localhost:9190/swagger-ui.html#/", "Capgemini",4.0);
		
			List<JobDetails> jobDetails = new ArrayList<JobDetails>();
			jobDetails.add(jobDetails1);
			jobDetails.add(jobDetails2);
			jobDetails.add(jobDetails3);
		
			Mockito.when(adminService.getAllJobDetails()).thenReturn(jobDetails);

			List<JobDetails> returnedJobDetails = adminService.getAllJobDetails();
			assertEquals(jobDetails, returnedJobDetails);
			System.out.println("All Job Details : " +returnedJobDetails);
		
		
	}
		
	@Test
	public void getJobDetailsById()  {
		
		JobDetails jobDetails1 = new JobDetails(1,"SAP Developer", "SAP", "http://localhost:9190/swagger-ui.html#/", "Capgemini",4.2);
		
		
		Mockito.when(adminService.getJobById(jobDetails1.getJobId())).thenReturn(jobDetails1);
		
		JobDetails jobDetails=adminService.getJobById(jobDetails1.getJobId());
		assertEquals(jobDetails1,jobDetails);
		System.out.println("job details for requested id : "+jobDetails);
	}	

	@Test
	public void getJobDetailsBySkills()  {
		
		JobDetails jobDetails1 = new JobDetails(1,"SAP Developer", "SAP", "http://localhost:9190/swagger-ui.html#/", "Capgemini",4.2);
		
		JobDetails jobDetails2 = new JobDetails(2,"Automation Tester", "Selenium", "http://localhost:9190/swagger-ui.html#/", "Barclays",3.2);
		
		JobDetails jobDetails3 = new JobDetails(3,"JAVA Developer", "Java", "http://localhost:9190/swagger-ui.html#/", "Capgemini",4.0);
		
			List<JobDetails> jobDetails = new ArrayList<JobDetails>();
			jobDetails.add(jobDetails1);
			jobDetails.add(jobDetails2);
			jobDetails.add(jobDetails3);
			
			
		
		Mockito.when(adminService.getJobBySkill("java")).thenReturn(jobDetails);
		List<JobDetails> returnedList = new ArrayList<JobDetails>();
		returnedList.addAll( adminService.getJobBySkill("java"));
		assertNotNull(returnedList);
		System.out.println("job details for requested JAVA : "+returnedList);
		
		
	}	

	@Test
	public void getJobDetailsBySalary()  {
		
		JobDetails jobDetails1 = new JobDetails(1,"SAP Developer", "SAP", "http://localhost:9190/swagger-ui.html#/", "Capgemini",4.2);
		
		JobDetails jobDetails2 = new JobDetails(2,"Automation Tester", "Selenium", "http://localhost:9190/swagger-ui.html#/", "Barclays",3.2);
		
		JobDetails jobDetails3 = new JobDetails(3,"JAVA Developer", "Java", "http://localhost:9190/swagger-ui.html#/", "Capgemini",4.0);
		
			List<JobDetails> jobDetails = new ArrayList<JobDetails>();
			jobDetails.add(jobDetails1);
			jobDetails.add(jobDetails2);
			jobDetails.add(jobDetails3);
		
		Mockito.when(adminService.getJobBysal(3.8)).thenReturn(jobDetails);
		
		List<JobDetails> returnedList = adminService.getJobBysal(3.8);
		assertNotNull(returnedList);
		System.out.println("job details for requested Salary : "+returnedList);
		
		
	}	

	
}
