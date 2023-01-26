package com.cjc.controllers;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;



//@Entity
//@Table(name = "Issue")
public class Issue {

	@Id
	@GeneratedValue
	@Column(name ="issueId_Pk")
	private int id;

	@NotEmpty(message ="Issue Type should not be empty")
	private String type;
    
	private String description;
    
	@NotEmpty(message ="Issue status should not be empty")
	private String status;

	
	
	public Issue() {
		super();
	}

	public Issue(int id,String issueType, String issueDesc, String issueStatus) {
		super();
		this.id = id;
		this.type = issueType;
		this.description = issueDesc;
		this.status = issueStatus;
		
	}
	

	public Issue( String type, String description, String status) {
		super();
		this.type = type;
		this.description = description;
		this.status = status;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}
