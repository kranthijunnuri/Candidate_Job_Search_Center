package com.cjc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjc.exceptions.JobDetailsNotFoundException;
import com.cjc.exceptions.SkillNotFoundException;
import com.cjc.pojos.JobDetails;
import com.cjc.repositories.ICandidateDao;
import com.cjc.repositories.IJobDetailsDao;




@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	IJobDetailsDao iJobDetailsDao;
	
	@Autowired
	ICandidateDao iCandidateDao;
	
	@Override
	public JobDetails addJobDetails(JobDetails jobDetails) {
		return iJobDetailsDao.save(jobDetails);
		
	}

	@Override
	public JobDetails updateJobDetails(JobDetails jobDetails) {
		int id = jobDetails.getJobId() ;
		Optional<JobDetails> optional = iJobDetailsDao.findById(id);
		if (!optional.isPresent()) {
			throw new JobDetailsNotFoundException("No Job found with this " +id);
		}
		return iJobDetailsDao.save(jobDetails);
	}

	@Override
	public List<JobDetails> deleteJob(int id) {
		Optional<JobDetails> optional = iJobDetailsDao.findById(id);
		if (!optional.isPresent()) {
			throw new JobDetailsNotFoundException("No Job found with this id " + id);
		}
		iJobDetailsDao.deleteById(id);
		return iJobDetailsDao.findAll();
	}

	@Override
	public JobDetails getJobById(int id) {
		Optional<JobDetails> optional = iJobDetailsDao.findById(id);
		if (!optional.isPresent()) {
			throw new JobDetailsNotFoundException("No JOb found with this id " + id);
		}
		return optional.get();

	}

	@Override
	public List<JobDetails> getAllJobDetails() {
		return iJobDetailsDao.findAll();
	}

	@Override
	public List<JobDetails> getJobBySkill(String skillNeeded) {
		List<JobDetails> details= iJobDetailsDao.findByskillNeeded(skillNeeded);
		if (details.isEmpty()) {
			throw new SkillNotFoundException("No Job found with this skill " + skillNeeded);
		}
		return details;
		
		
	}

	

	@Override
	public List<JobDetails> getJobBysal(double sal) {
		
							
			List<JobDetails> details= iJobDetailsDao.findBysalary(sal);
						
					
					if(details.isEmpty())
					{
						throw new JobDetailsNotFoundException("No Job found");
					}
					
					return details;
	}


	

}
