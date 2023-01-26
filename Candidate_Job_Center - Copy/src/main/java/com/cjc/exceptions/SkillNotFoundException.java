package com.cjc.exceptions;

public class SkillNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SkillNotFoundException() {

	}
	
	public SkillNotFoundException(String msg) {

		super(msg);
	}

}
