package com.dao;

public interface RegisteredDao {

	int ValidationUser(String uname);

	int InsertRegistered(String uname, String pwd, String email, String ethurl);

}
