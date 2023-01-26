package com.cjc.exceptions;

public class SecurityCodeNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SecurityCodeNotFoundException() {
	}
	public SecurityCodeNotFoundException(String message) {
		super(message);
	}
}