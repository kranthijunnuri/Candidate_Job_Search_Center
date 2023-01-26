package com.cjc.pojos;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class Candidate {
	@Id
	@GeneratedValue
	private int candidateId;
	
	@NotEmpty(message = "Phone Number should not be empty")
	@Pattern(regexp="(^$|[0-9]{10})",message ="Phone number should contain only digits and should have size 10")
	private String phoneNumber;

	@Email(message ="Email should be in format abc@gmail.com")
	private String email;
	
	
	
	@Valid
	@OneToMany( cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "candidateId")
	List<Skills> skills;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	private Login login;
	
	
	public Candidate()
	{
		super();
	}


	
	
	









	public Candidate(int candidateId,
			@NotEmpty(message = "Phone Number should not be empty") @Pattern(regexp = "(^$|[0-9]{10})", message = "Phone number should contain only digits and should have size 10") String phoneNumber,
			@Email(message = "Email should be in format abc@gmail.com") String email, @Valid List<Skills> skills,
			@Valid Login login) {
		super();
		this.candidateId = candidateId;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.skills = skills;
		this.login = login;
	}




	




	public Candidate(
			@NotEmpty(message = "Phone Number should not be empty") @Pattern(regexp = "(^$|[0-9]{10})", message = "Phone number should contain only digits and should have size 10") String phoneNumber,
			@Email(message = "Email should be in format abc@gmail.com") String email, @Valid List<Skills> skills,
			@Valid Login login) {
		super();
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.skills = skills;
		this.login = login;
	}




	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	




	public String getPhoneNumber() {
		return phoneNumber;
	}






	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}






	public String getEmail() {
		return email;
	}






	public void setEmail(String email) {
		this.email = email;
	}






	public List<Skills> getSkills() {
		return skills;
	}




	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}






	public Login getLogin() {
		return login;
	}




	public void setLogin(Login login) {
		this.login = login;
	}




	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", phoneNumber=" + phoneNumber + ", email=" + email
				+", skills=" + skills + ", login=" + login + "]";
	}


	


	

}
