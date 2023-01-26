package com.cjc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.pojos.Login;
import com.cjc.service.ICandidateService;
import com.cjc.service.ILoginService;


@RestController
public class LoginController {
	
	@Autowired
	ICandidateService iCandidateService;
	
	@Autowired
	ILoginService iLoginService;
	
	@PostMapping("/addlogin")
	public ResponseEntity<Login> login(@RequestBody Login login){
		Login login1 = iLoginService.addlogin(login);
		return new ResponseEntity<>(login1,HttpStatus.OK);
	}
	
	@PostMapping("/login/{userId}/{password}")
	public ResponseEntity<String> login(@PathVariable String userId,@PathVariable String password){
		String result=null;
		
			result = iCandidateService.checklogin(userId,password);
		
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	/**@GetMapping("/checklogin/{id}/{password}")
	public ResponseEntity<String> checklogin(@PathVariable String id,@PathVariable String password){
		String login1 = iLoginService.checklogin(id,password);
		return new ResponseEntity<>(login1,HttpStatus.OK);
	}**/
	
	

}
