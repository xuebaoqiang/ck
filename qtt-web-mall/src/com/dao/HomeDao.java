package com.dao;

import java.util.List;
import java.util.Map;

import com.pojo.TableDapp;

public interface HomeDao {

	public  Map ListHome(String name, int page, int pageSize, String pV_VALUE, String txNum_Value, String txValue_Value, String Cname) throws Exception;

	public void insertAPPlication(TableDapp tab) throws Exception;

	public  List<Map<String, Object>> GetNumber();

	public List<Map<String, Object>> GetListClassInFo();

	public Map<String, Object> GerGoDetails(int id);

	public Map<String, Object> getStart();

	public Map<String, Object> getEnd();

}
