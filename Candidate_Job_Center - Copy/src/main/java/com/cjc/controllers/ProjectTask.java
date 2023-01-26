package com.cjc.controllers;

import java.time.LocalDateTime;


import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class ProjectTask {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String projectSequence;
	@NotBlank(message="Please include project summary")
	private String summary;
	private String acceptanceCriteria;
	private String Status;
	private Integer priority;
	private String duedate;
	
	// ManytoOne Mapping with backlog
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.REFRESH)
	@JoinColumn(name="backlog_id",updatable=false,nullable=false)
	@JsonIgnore
	private Backlog backlog;
	
	@Column(updatable=false)
	private String projectIdentifier;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDateTime created_At;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDateTime updated_At;
	
	public ProjectTask() {
		super();
	}
	
	public Backlog getBacklog() {
		return backlog;
	}
	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProjectSequence() {
		return projectSequence;
	}
	public void setProjectSequence(String projectSequence) {
		this.projectSequence = projectSequence;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getAcceptanceCriteria() {
		return acceptanceCriteria;
	}
	public void setAcceptanceCriteria(String acceptanceCriteria) {
		this.acceptanceCriteria = acceptanceCriteria;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	public String getProjectIdentifier() {
		return projectIdentifier;
	}
	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
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
	//@PostUpdate
	public void onUpdate() {
		this.updated_At=LocalDateTime.now();
	}

	public ProjectTask(Long id, String projectSequence,
			@NotBlank(message = "Please include project summary") String summary, String acceptanceCriteria,
			String status, Integer priority, String duedate, Backlog backlog, String projectIdentifier,
			LocalDateTime created_At, LocalDateTime updated_At) {
		super();
		this.id = id;
		this.projectSequence = projectSequence;
		this.summary = summary;
		this.acceptanceCriteria = acceptanceCriteria;
		Status = status;
		this.priority = priority;
		this.duedate = duedate;
		this.backlog = backlog;
		this.projectIdentifier = projectIdentifier;
		this.created_At = created_At;
		this.updated_At = updated_At;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Status == null) ? 0 : Status.hashCode());
		result = prime * result + ((acceptanceCriteria == null) ? 0 : acceptanceCriteria.hashCode());
		result = prime * result + ((backlog == null) ? 0 : backlog.hashCode());
		result = prime * result + ((created_At == null) ? 0 : created_At.hashCode());
		result = prime * result + ((duedate == null) ? 0 : duedate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + ((projectIdentifier == null) ? 0 : projectIdentifier.hashCode());
		result = prime * result + ((projectSequence == null) ? 0 : projectSequence.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
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
		ProjectTask other = (ProjectTask) obj;
		if (Status == null) {
			if (other.Status != null)
				return false;
		} else if (!Status.equals(other.Status))
			return false;
		if (acceptanceCriteria == null) {
			if (other.acceptanceCriteria != null)
				return false;
		} else if (!acceptanceCriteria.equals(other.acceptanceCriteria))
			return false;
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
		if (duedate == null) {
			if (other.duedate != null)
				return false;
		} else if (!duedate.equals(other.duedate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (priority == null) {
			if (other.priority != null)
				return false;
		} else if (!priority.equals(other.priority))
			return false;
		if (projectIdentifier == null) {
			if (other.projectIdentifier != null)
				return false;
		} else if (!projectIdentifier.equals(other.projectIdentifier))
			return false;
		if (projectSequence == null) {
			if (other.projectSequence != null)
				return false;
		} else if (!projectSequence.equals(other.projectSequence))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (updated_At == null) {
			if (other.updated_At != null)
				return false;
		} else if (!updated_At.equals(other.updated_At))
			return false;
		return true;
	}
	
	

}
