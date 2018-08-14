package com.dao.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dao.LoginDao;
import com.pojo.User;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {
	
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	

	/**
	 * 登录
	 * <p>Title: Login</p>   
	 * <p>Description: </p>   
	 * @param name
	 * @return   
	 * @see com.dao.LoginDao#Login(java.lang.String)
	 */
	public Map<String,Object> Login(String name) throws Exception{
		String sql = "select * from type_user where name = '"+name+"'";
		try {
			Map<String, Object> map = jdbcTemplate.queryForMap(sql);
	        return map;
	    } catch (EmptyResultDataAccessException e) {
	        return null;//当查询记录为0时，会抛出EmptyResultDataAccessException异常，所以可以捕获它并做适当的处理，如返回null
	    }
	}

}
