package com.cjc.exceptions;

public class LoginNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6316311770477959140L;

	public LoginNotFoundException() {

	}

	public LoginNotFoundException(String message) {
		super(message);
	}
}
