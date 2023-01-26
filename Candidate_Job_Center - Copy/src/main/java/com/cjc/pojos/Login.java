package com.cjc.pojos;




import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;


@Entity
@Table(name = "Login")
public class Login {
	@Id
	@Email(message ="Email should be in format abc@gmail.com")
	private String id;
	@Column(nullable=false,unique=true)
	private String password;
	@Column(nullable=false,unique=true)
	private String security;
	
	

	
	
	public Login() {
		super();
	}

	


	@Override
	public String toString() {
		return "Login [id=" + id + ", password=" + password + ", security=" + security + "]";
	}




	public String getSecurity() {
		return security;
	}




	public void setSecurity(String security) {
		this.security = security;
	}




	public Login(@Email(message = "Email should be in format abc@gmail.com") String id, String password,
			String security) {
		super();
		this.id = id;
		this.password = password;
		this.security = security;
	}




	public Login(@Email(message = "Email should be in format abc@gmail.com") String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
