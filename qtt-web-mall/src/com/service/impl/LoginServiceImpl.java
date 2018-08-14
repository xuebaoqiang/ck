package com.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.LoginDao;
import com.service.LoginService;
@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Resource(name="loginDao")	
	private LoginDao logindao;
	
	public List Login(String name, String password) throws Exception{
		Map<String,Object> map = logindao.Login(name);
		 List list = new ArrayList<String>();
		if(map == null){
			 map.put("type", "1");
		 }else{
			 if(!password.equals(map.get("password"))){
				 map.put("type", "2");
			 }else{
				 map.put("type", "3");
			 }
		 }
		list.add(map);
		return list;
	}

}
