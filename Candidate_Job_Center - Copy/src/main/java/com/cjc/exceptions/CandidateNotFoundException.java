package com.cjc.exceptions;

@SuppressWarnings("serial")
public class CandidateNotFoundException extends RuntimeException {
	
	public CandidateNotFoundException() {
	}

	public CandidateNotFoundException(String message) {
		super(message);
	}

}
