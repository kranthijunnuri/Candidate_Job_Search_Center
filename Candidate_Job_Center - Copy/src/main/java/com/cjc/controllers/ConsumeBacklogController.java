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
public class ConsumeBacklogController {
	
	
	   @Autowired
	   RestTemplate restTemplate;
	   
	   
	   
	   @RequestMapping(value = "/template/postBacklog/{backlog_id}", method = RequestMethod.POST)
	   public String createBackLog(@RequestBody ProjectTask projectTask,BindingResult result,@PathVariable String backlog_id) {
		      HttpHeaders headers = new HttpHeaders();
		      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		      HttpEntity<ProjectTask> entity = new HttpEntity<ProjectTask>(projectTask,headers);
		      
		      return restTemplate.exchange(
		    		  "http://localhost:8080/api/backlog/"+backlog_id, HttpMethod.POST, entity, String.class).getBody();
		   }
	   
	   
	   
	   
	   
	   @RequestMapping(value = "/template/getProjectBackLog/{projectIdentifier}",method = RequestMethod.GET)
	   public String getProjectBacklog(@PathVariable("projectIdentifier") String projectIdentifier) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("http://localhost:8080/api/backlog/"+projectIdentifier, HttpMethod.GET, entity, String.class).getBody();
	   }
	   
	   
	   
	   @RequestMapping(value = "/template/getProjectBackLog/{backlog_id}/{pt_id}",method = RequestMethod.GET)
	   public String getProjectTask(@PathVariable("backlog_id") String backlog_id,@PathVariable("pt_id") String pt_id) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("http://localhost:8080/api/backlog/"+backlog_id+"/"+pt_id, HttpMethod.GET, entity, String.class).getBody();
	   }
	   

	  
	   @RequestMapping(value = "/template/deleteProjectBacklog/{backlog_id}/{pt_id}", method = RequestMethod.DELETE)
	   public String deleteProjectBackLog(@PathVariable("backlog_id")  String backlog_id,@PathVariable("pt_id") String pt_id) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Backlog> entity = new HttpEntity<Backlog>(headers);
	      
	      return restTemplate.exchange(
	         "http://localhost:8080/api/backlog/"+backlog_id+"/"+pt_id, HttpMethod.DELETE, entity, String.class).getBody();
	   }
	   
	   @RequestMapping(value = "/template/updateProjectTask/{backlog_id}/{pt_id}", method = RequestMethod.PUT)
	   public String updateProjectTask(@RequestBody ProjectTask projectTask, BindingResult result, @PathVariable String backlog_id,@PathVariable String pt_id) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<ProjectTask> entity = new HttpEntity<ProjectTask>(projectTask,headers);
	      
	      return restTemplate.exchange(
	         "http://localhost:8080/api/backlog/"+backlog_id +"/" + pt_id, HttpMethod.PUT, entity, String.class).getBody();
	   }
	   
	   
}
