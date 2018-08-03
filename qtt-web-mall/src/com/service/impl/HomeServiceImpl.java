package com.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.HomeDao;
import com.pojo.TableDapp;
import com.service.HomeService;
@Service("homeService")
public class HomeServiceImpl implements HomeService {
	@Resource(name="homeDao")
	private HomeDao homeDao;
	
	public void setUserDao(HomeDao userDao) {
		this.homeDao = userDao;
	}


	@Override
	public Map ListHome(String name,int page, int pageSize,String pV_VALUE, String txNum_Value, String txValue_Value,String Cname) throws Exception{
		return homeDao.ListHome(name,page,pageSize,pV_VALUE,txNum_Value,txValue_Value,Cname);
	}


	@Override
	public void insertAPPlication(TableDapp tab) throws Exception {
		homeDao.insertAPPlication(tab);
	}


	@Override
	public List<Map<String, Object>> GetNumber() {
		return homeDao.GetNumber();
	}


	@Override
	public List<Map<String, Object>> GetListClassInFo() {
		return homeDao.GetListClassInFo();
	}


	public Map<String, Object> GerGoDetails(int id) {
		return homeDao.GerGoDetails(id);
	}


	@Override
	public Map<String, Object> getStart() {
		return homeDao.getStart();
	}


	@Override
	public Map<String, Object> getEnd() {
		return homeDao.getEnd();
	}


}
