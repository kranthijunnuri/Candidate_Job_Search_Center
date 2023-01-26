package com.cjc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class Backlog {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Integer PTSequence=0;
	private String projectIdentifier;
	
	//OnetoOne Mapping with project
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="project_id",nullable=false)
	@JsonIgnore
	private Project project;
	
	//OneToMany mapping with ProjectTask
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="backlog")
	private List<ProjectTask> projectTasks=new ArrayList<>();
	public Backlog() {
	
	}
	
	
	public List<ProjectTask> getProjectTasks() {
		return projectTasks;
	}


	public void setProjectTasks(List<ProjectTask> projectTasks) {
		this.projectTasks = projectTasks;
	}


	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getPTSequence() {
		return PTSequence;
	}
	public void setPTSequence(Integer pTSequence) {
		PTSequence = pTSequence;
	}
	public String getProjectIdentifier() {
		return projectIdentifier;
	}
	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}


	public Backlog(Long id, Integer pTSequence, String projectIdentifier, Project project,
			List<ProjectTask> projectTasks) {
		super();
		this.id = id;
		PTSequence = pTSequence;
		this.projectIdentifier = projectIdentifier;
		this.project = project;
		this.projectTasks = projectTasks;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PTSequence == null) ? 0 : PTSequence.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((projectIdentifier == null) ? 0 : projectIdentifier.hashCode());
		result = prime * result + ((projectTasks == null) ? 0 : projectTasks.hashCode());
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
		Backlog other = (Backlog) obj;
		if (PTSequence == null) {
			if (other.PTSequence != null)
				return false;
		} else if (!PTSequence.equals(other.PTSequence))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (projectIdentifier == null) {
			if (other.projectIdentifier != null)
				return false;
		} else if (!projectIdentifier.equals(other.projectIdentifier))
			return false;
		if (projectTasks == null) {
			if (other.projectTasks != null)
				return false;
		} else if (!projectTasks.equals(other.projectTasks))
			return false;
		return true;
	}
	
	
	
}
