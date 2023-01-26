package com.cjc.exceptions;

public class PasswordIncorrectException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PasswordIncorrectException() {

	}

	public PasswordIncorrectException(String message) {
		super(message);
	}
}
