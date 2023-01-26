package com.cjc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjc.pojos.Login;

public interface ILoginDao extends JpaRepository<Login, String>{
	
	public	Optional<Login> findById(String id);
}
