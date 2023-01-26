package com.cjc.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ConsumeControllers {
	
	
	   @Autowired
	   RestTemplate restTemplate;

	   @RequestMapping(value = "/template/getIssues",method = RequestMethod.GET)
	   public String getIssuesList() {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("http://localhost:9191/ocs2/getAllIssues", HttpMethod.GET, entity, String.class).getBody();
	   }
	   
	   @RequestMapping(value = "/template/addIssue", method = RequestMethod.POST)
	   public String createIssues(@RequestBody Issue issue) {
		      HttpHeaders headers = new HttpHeaders();
		      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		      HttpEntity<Issue> entity = new HttpEntity<Issue>(issue,headers);
		      
		      return restTemplate.exchange(
		         "http://localhost:9191/ocs2/addCustomerIssue", HttpMethod.POST, entity, String.class).getBody();
		   }
	   
	
	   @RequestMapping(value = "/template/updateIssue", method = RequestMethod.PUT)
	   public String updateProduct(@RequestBody Issue issue) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Issue> entity = new HttpEntity<Issue>(issue,headers);
	      
	      return restTemplate.exchange(
	         "http://localhost:9191/ocs2/modifyCustomerIssue", HttpMethod.PUT, entity, String.class).getBody();
	   }
	   
	  /** @RequestMapping(value = "/template/deleteOperator/{id}", method = RequestMethod.DELETE)
	   public String deleteProduct(@PathVariable("id") String id) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Product> entity = new HttpEntity<Product>(headers);
	      
	      return restTemplate.exchange(
	         "http://localhost:8080/products/"+id, HttpMethod.DELETE, entity, String.class).getBody();
	   }**/
}
