package com.cjc.exceptions;

public class JobDetailsNotFoundException extends  RuntimeException  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JobDetailsNotFoundException() {

	}
	
	public JobDetailsNotFoundException(String msg) {

		super(msg);
	}
	
	

}
