package com.cjc.pojos;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "JobDetails")
public class JobDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int jobId;
	@NotEmpty(message = "role should not be empty")
	private String role;
	@NotEmpty(message = "Skill should not be empty")
	private String skillNeeded;
	@NotEmpty(message = "Link should not be empty")
	private String linkTOApply;
	@NotEmpty(message = "company should not be empty")
	private String company;
	
	@NotNull(message = "package should not be empty")
	private double salary;
	
	
	


	public JobDetails(@NotEmpty(message = "role should not be empty") String role,
			@NotEmpty(message = "Skill should not be empty") String skillNeeded,
			@NotEmpty(message = "Link should not be empty") String linkTOApply,
			@NotEmpty(message = "company should not be empty") String company,
			@NotEmpty(message = "package should not be empty") double salary) {
		super();
		this.role = role;
		this.skillNeeded = skillNeeded;
		this.linkTOApply = linkTOApply;
		this.company = company;
		this.salary = salary;
	}








	public JobDetails(int jobId, @NotEmpty(message = "role should not be empty") String role,
			@NotEmpty(message = "Skill should not be empty") String skillNeeded,
			@NotEmpty(message = "Link should not be empty") String linkTOApply,
			@NotEmpty(message = "company should not be empty") String company,
			@NotNull(message = "package should not be empty") double salary) {
		super();
		this.jobId = jobId;
		this.role = role;
		this.skillNeeded = skillNeeded;
		this.linkTOApply = linkTOApply;
		this.company = company;
		this.salary = salary;
	}








	public JobDetails(int jobId, @NotEmpty(message = "role should not be empty") String role,
			@NotEmpty(message = "Skill should not be empty") String skillNeeded,
			@NotEmpty(message = "Link should not be empty") String linkTOApply,
			@NotEmpty(message = "company should not be empty") String company) {
		super();
		this.jobId = jobId;
		this.role = role;
		this.skillNeeded = skillNeeded;
		this.linkTOApply = linkTOApply;
		this.company = company;
	}




















	/**@Valid
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="jobId")
	List<Skills> skills;
	
	@Valid
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="appliedJobs")
	List<Candidate> appliedCandidates;
	@Valid
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="candidateId")
	List<Candidate> appliedCandidates;**/
	
	
	
	public JobDetails() {

	}
	















	







	public String getCompany() {
		return company;
	}








	public void setCompany(String company) {
		this.company = company;
	}








	public int getJobId() {
		return jobId;
	}

	

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}






	public String getSkillNeeded() {
		return skillNeeded;
	}








	public void setSkillNeeded(String skillNeeded) {
		this.skillNeeded = skillNeeded;
	}








	public String getLinkTOApply() {
		return linkTOApply;
	}








	public void setLinkTOApply(String linkTOApply) {
		this.linkTOApply = linkTOApply;
	}








	







	public double getSalary() {
		return salary;
	}








	public void setSalary(double salary) {
		this.salary = salary;
	}








	@Override
	public String toString() {
		return "JobDetails [jobId=" + jobId + ", role=" + role + ", skillNeeded=" + skillNeeded + ", linkTOApply="
				+ linkTOApply + ", company=" + company + ", salary=" + salary + "]";
	}





	
	
}