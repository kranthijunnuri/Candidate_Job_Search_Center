package com.cjc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjc.exceptions.CandidateNotFoundException;
import com.cjc.exceptions.LoginNotFoundException;
import com.cjc.exceptions.PasswordIncorrectException;
import com.cjc.exceptions.SecurityCodeNotFoundException;
import com.cjc.pojos.Candidate;
import com.cjc.pojos.Login;
import com.cjc.repositories.ICandidateDao;
import com.cjc.repositories.ILoginDao;



@Service
@Transactional
public class CandidateServiceImpl implements ICandidateService{

	@Autowired
	ICandidateDao icandidateDao;
	
	@Autowired
	ILoginDao iLoginDao;
	
	@Override
	public Candidate addCandidate(Candidate candidate) {
		return icandidateDao.save(candidate);
		
	}

	@Override
	public Candidate updateCandidate(Candidate candidate) {
		int id = candidate.getCandidateId();
		Optional<Candidate> optional = icandidateDao.findById(id);
		if (!optional.isPresent()) {
			throw new CandidateNotFoundException("No Candidate found with this " +id);
		}
		return icandidateDao.save(candidate);
	
		
	}

	@Override
	public List<Candidate> deleteCandidate(int id) {
		Optional<Candidate> optional = icandidateDao.findById(id);
		if (!optional.isPresent()) {
			throw new CandidateNotFoundException("No candidate found with this id " + id);
		}
		icandidateDao.deleteById(id);
		return icandidateDao.findAll();
	}

	@Override
	public String checklogin(String id, String password) {

		Login login = iLoginDao.findById(id).orElse(null);
		if (login != null) {
			String id1 = login.getId();
			String password2 = login.getPassword();
			
			if (id .equals(id1)  && password.equals(password2)) {
				return "Login successful";
			} 
			throw new PasswordIncorrectException("Given password is incorrect");
		}
		throw new LoginNotFoundException("No account found with this id " + id);
	}

	@Override
	public String changePassword(String userId, String oldPassword, String newPassword)
 {
		Login login = iLoginDao.findById(userId).orElse(null);
		if (login != null) {
			String userId1 = login.getId();
			String password2 = login.getPassword();
			if (userId1 .equals( userId) && oldPassword.equals(password2)) {
				login.setPassword(newPassword);
				return "Password Changed Successfully";
			} 
			throw new PasswordIncorrectException("Given Password is incorrect");
		}
		throw new LoginNotFoundException("No User found with this id" + userId);

	}

	@Override
	public String forgotPassword(String userId, String security,String newPassword) {
		Login login = iLoginDao.findById(userId).orElse(null);
		if (login != null) {
			String userId1 = login.getId();
			String securitycode= login.getSecurity();
			if(userId1.equals(userId) && securitycode.equals(security)) {
			login.setPassword(newPassword);
			return "Password Changed Successfully";
			}
			throw new SecurityCodeNotFoundException("Given Security code is incorrect");

		}
		throw new LoginNotFoundException("No User found with this id " + userId);
	}
	
}
