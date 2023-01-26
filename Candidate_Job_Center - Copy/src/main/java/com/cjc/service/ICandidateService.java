package com.cjc.service;

import java.util.List;

import com.cjc.pojos.Candidate;

public interface ICandidateService {
	
	public String checklogin(String id, String password);

	public Candidate addCandidate(Candidate candidate);
	
	public Candidate updateCandidate(Candidate candidate);

	public List<Candidate> deleteCandidate(int id);
	
	public String changePassword(String username, String oldPassword, String newPassword);
	
	public String forgotPassword(String username,String security, String newPassword);


	
}
