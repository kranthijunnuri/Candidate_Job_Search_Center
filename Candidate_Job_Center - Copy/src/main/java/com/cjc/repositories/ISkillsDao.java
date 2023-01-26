package com.cjc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.pojos.Skills;


@Repository
public interface ISkillsDao extends JpaRepository<Skills,Integer> {


}
