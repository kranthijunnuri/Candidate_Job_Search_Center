package com.cjc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjc.pojos.Login;
import com.cjc.repositories.ILoginDao;

@Service
@Transactional
public class LoginServiceImpl implements ILoginService{
	
	Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	ILoginDao loginrepository;
	
	@Override
	public Login addlogin(Login login) {
		return loginrepository.save(login);
	}
    
	@Override
	public String checklogin(String id,String password) {
		Login login=loginrepository.findById(id).get();
		
		
		if(login.getId().equals(id)&& login.getPassword().equals(password))
		{
			logger.info(id+" "+password);
		return "successful" ;
		}else
		{
			logger.info(id+" "+password);
			return "fail";
		}
	}
}
        
	