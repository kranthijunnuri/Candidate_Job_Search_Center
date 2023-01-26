package com.cjc.service;

import com.cjc.pojos.Login;

public interface ILoginService {

	Login addlogin(Login login);
	public String checklogin(String id,String password);
}
