package com.cjc.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.pojos.Candidate;


@Repository
public interface ICandidateDao extends JpaRepository<Candidate,Integer> {

	

}
