package com.dao.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dao.RegisteredDao;

@Repository("registereDao")
public class RegisteredDaoImpl implements RegisteredDao {
	
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/**
	 * 验证用户名是否存在
	 * <p>Title: ValidationUser</p>   
	 * <p>Description: </p>   
	 * @param uname   
	 * @return 
	 * @see com.dao.RegisteredDao#ValidationUser(java.lang.String)
	 */
	public int ValidationUser(String uname) {
		String sql = "select count(*) from type_user where name = '"+uname+"'";
		
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	/**
	 * 注册
	 * <p>Title: InsertRegistered</p>   
	 * <p>Description: </p>   
	 * @param uname
	 * @param password
	 * @param email
	 * @param ethurl   
	 * @return 
	 * @see com.dao.RegisteredDao#InsertRegistered(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public int InsertRegistered(String uname, String pwd, String email, String ethurl) {
		String sql = "insert into type_user(name,password,email,ethurl) values('"+uname+"','"+pwd+"','"+email+"','"+ethurl+"')";
		return jdbcTemplate.update(sql);
	}
}
