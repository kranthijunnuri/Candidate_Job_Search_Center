package com.cjc.controllers;




import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class ConsumeProjectController {

	
	
	   @Autowired
	   RestTemplate restTemplate;

	   
	   @RequestMapping(value = "/template/postProject", method = RequestMethod.POST)
	   public String createIssues(@RequestBody Project project) {
		      HttpHeaders headers = new HttpHeaders();
		      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		      HttpEntity<Project> entity = new HttpEntity<Project>(project,headers);
		      
		      return restTemplate.exchange(
		         "http://localhost:8080/api/projects", HttpMethod.POST, entity, String.class).getBody();
		   }
	   
	   @RequestMapping(value = "/template/getProject/{projectIdentifier}",method = RequestMethod.GET)
	   public String getIssuesList(@PathVariable("projectIdentifier") String projectIdentifier) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("http://localhost:8080/api/projects/"+projectIdentifier, HttpMethod.GET, entity, String.class).getBody();
	   }
	 


	   @RequestMapping(value = "/template/getAllProjects",method = RequestMethod.GET)
	   public String getProjectList() {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("http://localhost:8080/api/projects/all", HttpMethod.GET, entity, String.class).getBody();
	   }
	   
	   
	  
	   
	   @RequestMapping(value = "/template/deleteProject/{id}", method = RequestMethod.DELETE)
	   public String deleteProduct(@PathVariable("id") String id) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Project> entity = new HttpEntity<Project>(headers);
	      
	      return restTemplate.exchange(
	         "http://localhost:8080/api/projects/"+id, HttpMethod.DELETE, entity, String.class).getBody();
	   }
	   
	  
}
