package com.cjc.service;

import java.util.List;

import com.cjc.pojos.JobDetails;


public interface IAdminService {

    public JobDetails addJobDetails(JobDetails jobDetails);
	
    public JobDetails updateJobDetails(JobDetails jobDetails);
    
	public List<JobDetails> deleteJob(int id);
	
	public JobDetails getJobById(int id);
	
	public List<JobDetails> getAllJobDetails();
	
	public List<JobDetails> getJobBySkill(String skill);
	
	
	public List<JobDetails> getJobBysal(double sal);
	 
}

