package com.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.RegisteredDao;
import com.service.RegisteredService;

@Service("registeredService")
public class RegisteredServiceImpl implements RegisteredService {
	
	
	@Resource(name="registereDao")	
	private RegisteredDao registeredao;

	@Override
	public int ValidationUser(String uname) {
		
		return registeredao.ValidationUser(uname);
	}

	@Override
	public int InsertRegistered(String uname, String pwd, String email, String ethurl) {
		
		return registeredao.InsertRegistered(uname,pwd,email,ethurl);
	}
}
