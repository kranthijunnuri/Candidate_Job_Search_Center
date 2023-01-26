package com.cjc.controllers;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.pojos.JobDetails;
import com.cjc.service.IAdminService;
import com.cjc.service.ICandidateService;


@RestController
public class AdminController {
	@Autowired
	IAdminService service;
	
	@Autowired
	ICandidateService icservice;
	
	// This method is to add values into job
			@PostMapping("/addJobDetails")
			public ResponseEntity<JobDetails> addJob(@Valid @RequestBody JobDetails details) {
			    JobDetails information = service.addJobDetails(details);
				return new ResponseEntity<>(information, HttpStatus.OK);
			}
			
			// This method is to update the values in job
			@PutMapping("/updateJob")
			public ResponseEntity<JobDetails> updateJob(@RequestBody JobDetails jobDetails){
				JobDetails upinformation = service.updateJobDetails(jobDetails);
				return new ResponseEntity<>(upinformation, HttpStatus.OK);

			}
			
			// This method is to delete candidate based in id
			@DeleteMapping("/deleteJob/{id}")
			public ResponseEntity<List<JobDetails>> deleteJob(@PathVariable int id){
				List<JobDetails> delcandidate = service.deleteJob(id);
				return new ResponseEntity<>(delcandidate, HttpStatus.OK);
			}
			
		
		
			
			
			
			


}
