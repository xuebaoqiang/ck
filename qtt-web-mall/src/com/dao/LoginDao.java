package com.dao;

import java.util.Map;

public interface LoginDao {
	
	Map<String,Object> Login(String names) throws Exception;

}
