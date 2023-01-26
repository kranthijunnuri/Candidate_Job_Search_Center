package com.cjc.controllers;

import java.time.LocalDateTime;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@NotBlank(message="Project Name Required")
	private String projectName;
	@NotBlank(message="Project Identifier Required")
	@Size(min=4,max=5,message="Size must be 4 to 5 charecters")
	@Column(unique=true,updatable=false)
	private String projectIdentifier;
	@NotBlank(message="Project description Required")
	private String description;
	private String start_date;
	private String end_date;
	private LocalDateTime created_At;
	private LocalDateTime updated_At;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="project")
	private Backlog backlog;
	
	
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Project(long id, @NotBlank(message = "Project Name Required") String projectName,
			@NotBlank(message = "Project Identifier Required") @Size(min = 4, max = 5, message = "Size must be 4 to 5 charecters") String projectIdentifier,
			@NotBlank(message = "Project description Required") String description, String start_date, String end_date,
			LocalDateTime created_At, LocalDateTime updated_At, Backlog backlog) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.projectIdentifier = projectIdentifier;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.created_At = created_At;
		this.updated_At = updated_At;
		this.backlog = backlog;
	}



	public Backlog getBacklog() {
		return backlog;
	}
	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectIdentifier() {
		return projectIdentifier;
	}
	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public LocalDateTime getCreated_At() {
		return created_At;
	}
	public void setCreated_At(LocalDateTime created_At) {
		this.created_At = created_At;
	}
	public LocalDateTime getUpdated_At() {
		return updated_At;
	}
	public void setUpdated_At(LocalDateTime updated_At) {
		this.updated_At = updated_At;
	}
	//@PrePersist
	public void onCreate() {
		this.created_At=LocalDateTime.now();
	}
	//@PreUpdate
	public void onUpdate() {
		this.updated_At=LocalDateTime.now();
	}



	@Override
	public String toString() {
		return "Project [id=" + id + ", projectName=" + projectName + ", projectIdentifier=" + projectIdentifier
				+ ", description=" + description + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", created_At=" + created_At + ", updated_At=" + updated_At + ", backlog=" + backlog + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((backlog == null) ? 0 : backlog.hashCode());
		result = prime * result + ((created_At == null) ? 0 : created_At.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((end_date == null) ? 0 : end_date.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((projectIdentifier == null) ? 0 : projectIdentifier.hashCode());
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
		result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
		result = prime * result + ((updated_At == null) ? 0 : updated_At.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (backlog == null) {
			if (other.backlog != null)
				return false;
		} else if (!backlog.equals(other.backlog))
			return false;
		if (created_At == null) {
			if (other.created_At != null)
				return false;
		} else if (!created_At.equals(other.created_At))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (end_date == null) {
			if (other.end_date != null)
				return false;
		} else if (!end_date.equals(other.end_date))
			return false;
		if (id != other.id)
			return false;
		if (projectIdentifier == null) {
			if (other.projectIdentifier != null)
				return false;
		} else if (!projectIdentifier.equals(other.projectIdentifier))
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		if (start_date == null) {
			if (other.start_date != null)
				return false;
		} else if (!start_date.equals(other.start_date))
			return false;
		if (updated_At == null) {
			if (other.updated_At != null)
				return false;
		} else if (!updated_At.equals(other.updated_At))
			return false;
		return true;
	}
	
	
		
	
}
