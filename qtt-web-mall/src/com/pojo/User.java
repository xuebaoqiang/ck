package com.pojo;

public class User {
	private Long sid;
	private String username;
	private String password;
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [sid=" + sid + ", username=" + username + ", password="
				+ password + "]";
	}
	public User(Long sid, String username, String password) {
		super();
		this.sid = sid;
		this.username = username;
		this.password = password;
	}
	public User() {
		super();
	}
	
	
	
}
