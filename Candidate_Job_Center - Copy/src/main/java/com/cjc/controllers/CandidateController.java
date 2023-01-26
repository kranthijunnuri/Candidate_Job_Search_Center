package com.cjc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.pojos.Candidate;
import com.cjc.pojos.JobDetails;
import com.cjc.service.IAdminService;
import com.cjc.service.ICandidateService;



@RestController
public class CandidateController {
	
	
	Logger logger = LoggerFactory.getLogger(CandidateController.class);
	
	@Autowired
	ICandidateService service;
	
	@Autowired
	IAdminService adminService;
	
	// This method is to add values into candidate
		@PostMapping("/addCandidate")
		public ResponseEntity<Candidate> addcandidate(@Valid @RequestBody Candidate candidate) {
			//Candidate information = candidate.
			Candidate information = service.addCandidate(candidate);
			return new ResponseEntity<>(information, HttpStatus.OK);
		}
		
		// This method is to update the values in candidate
		@PutMapping("/updatecandidate")
		public ResponseEntity<Candidate> updateCandidate(@RequestBody Candidate candidate){
			Candidate upinformation = service.updateCandidate(candidate);
			return new ResponseEntity<>(upinformation, HttpStatus.OK);

		}
		
		// This method is to delete candidate based in id
		@DeleteMapping("/deleteCandidate/{id}")
		public ResponseEntity<List<Candidate>> deleteCandidate(@PathVariable int id){
			List<Candidate> delcandidate = service.deleteCandidate(id);
			return new ResponseEntity<>(delcandidate, HttpStatus.OK);
		}
		
		
		@GetMapping("/getJobDetails/{id}")
		public ResponseEntity<JobDetails> getDetails(@PathVariable int id) {
			JobDetails jobDetails = adminService.getJobById(id);
			return new ResponseEntity<>(jobDetails, HttpStatus.OK);
		}
		
		@GetMapping("/getAllJobDetails")
		public ResponseEntity<List<JobDetails>> getAllJobDetails() {
			List<JobDetails> jobDetails = adminService.getAllJobDetails();
			logger.info("Fetching All Candidates");
			
			return new ResponseEntity<>(jobDetails, HttpStatus.OK);
		}
		
		@GetMapping("/getAllJobDetails/{skillNeeded}")
		public ResponseEntity<List<JobDetails>> getJobDetailsBySkill(@PathVariable String skillNeeded) {
			List<JobDetails> jobDetails = adminService.getJobBySkill(skillNeeded);

			return new ResponseEntity<>(jobDetails, HttpStatus.OK);
		}
		
		@PutMapping("/ChangePassword/{userId}/{oldPassword}/{newPassword}")
		public ResponseEntity<String> changePassword(@PathVariable String userId, @PathVariable String oldPassword,
				@PathVariable String newPassword) {
			String msg = service.changePassword(userId, oldPassword, newPassword);
			return new ResponseEntity<>(msg, HttpStatus.OK);

		}
		
		@PutMapping("/ForgotPassword/{userId}/{security}/{newPassword}")
		public ResponseEntity<String> forgotPassword(@PathVariable String userId, @PathVariable String security,
				@PathVariable String newPassword) {
			String msg = service.forgotPassword(userId,security, newPassword);
			return new ResponseEntity<>(msg, HttpStatus.OK);

		}

		
		
		@GetMapping("/getJobDetailsBySalary/{salary}")
		public ResponseEntity<List<JobDetails>> getJobDetailsBySal(@RequestParam double sal) {
			List<JobDetails> jobDetails = adminService.getJobBysal(sal);
			
			return new ResponseEntity<List<JobDetails>>(jobDetails, HttpStatus.OK);
		}
		

}
