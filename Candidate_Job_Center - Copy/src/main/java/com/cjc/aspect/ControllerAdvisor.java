package com.cjc.aspect;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cjc.exceptions.CandidateNotFoundException;
import com.cjc.exceptions.JobDetailsNotFoundException;
import com.cjc.exceptions.LoginNotFoundException;
import com.cjc.exceptions.PasswordIncorrectException;
import com.cjc.exceptions.SkillNotFoundException;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler{

		
		@ExceptionHandler (CandidateNotFoundException.class)
		public ResponseEntity<String> handelProductDetailsNotFoundException(CandidateNotFoundException e){
			String responseMsg= e.getMessage();
			return new ResponseEntity<>(responseMsg,HttpStatus.EXPECTATION_FAILED) ; 
		}

		@ExceptionHandler (JobDetailsNotFoundException.class)
		public ResponseEntity<String> handelProductServiceDownException(JobDetailsNotFoundException e){
			
			return new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED) ;
		}
		
		
		
		@ExceptionHandler (LoginNotFoundException.class)
		public ResponseEntity<String> handelProductServiceDownException(LoginNotFoundException e){
			String responseMsg= e.getMessage();
			return new ResponseEntity<>(responseMsg,HttpStatus.EXPECTATION_FAILED) ;
		}
		
		@ExceptionHandler (PasswordIncorrectException.class)
		public ResponseEntity<String> handelProductServiceDownException(PasswordIncorrectException e){
			String responseMsg= e.getMessage();
			return new ResponseEntity<>(responseMsg,HttpStatus.EXPECTATION_FAILED) ;
		}
		
		@ExceptionHandler (SkillNotFoundException.class)
		public ResponseEntity<String> handelProductServiceDownException(SkillNotFoundException e){
			String responseMsg= e.getMessage();
			return new ResponseEntity<>(responseMsg,HttpStatus.EXPECTATION_FAILED) ;
		}
		
		@ExceptionHandler (Exception.class)
		public ResponseEntity<String> handelProductServiceDownException(Exception e){
			String responseMsg= e.getMessage();
			return new ResponseEntity<>(responseMsg,HttpStatus.EXPECTATION_FAILED) ;
		}
		
		protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
				HttpHeaders headers, HttpStatus status, WebRequest request) {

			Map<String, String> maps = new HashMap<>();
			ex.getBindingResult().getFieldErrors()
					.forEach(map -> maps.put(map.getField(), map.getDefaultMessage()));
			return new ResponseEntity<>(maps, HttpStatus.BAD_REQUEST);
		}
		
	}



