package com.cjc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cjc.pojos.JobDetails;

@Repository
public interface IJobDetailsDao extends JpaRepository<JobDetails,Integer> {
	
	public	List<JobDetails> findByskillNeeded(String skillNeeded);
	
	
	
	@Query(value = "from JobDetails j where salary>=:salary")
	public	List<JobDetails> findBysalary(@Param("salary")double salary);
	
	
}
