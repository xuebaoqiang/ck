package com.service;

public interface RegisteredService {

	int ValidationUser(String uname);

	int InsertRegistered(String uname, String pwd, String email, String ethurl);

}
