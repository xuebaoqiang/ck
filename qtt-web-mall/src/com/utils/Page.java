package com.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class Page extends JdbcDaoSupport{

	public static final int NUMBERS_PER_PAGE = 20;
	
	private int isFinished;
	//一页显示的记录数
	 private int numPerPage; 
	//记录总数
	 private int totalRows; 
	//总页数
	 private int totalPages; 
	//当前页码
	 private int currentPage; 
	 //起始行数
	 private int startIndex;
	 //结束行数
	 private int lastIndex;
	 //结果集存放List
	 private Map resultList;
	 //JdbcTemplate jTemplate
	 private JdbcTemplate jTemplate;

/**
* 每页显示10条记录的构造函数,使用该函数必须先给Pagination设置currentPage，jTemplate初值
* @param sql Oracle语句
 * @return 
*/
	 public void Pagination(String sql){
	   if(jTemplate == null){
		 throw new IllegalArgumentException("com.deity.ranking.util.Pagination.jTemplate is null,please initial it first. ");
	   }else if(sql.equals("")){
		 throw new IllegalArgumentException("com.deity.ranking.util.Pagination.sql is empty,please initial it first. ");
	   }
	   new Page(sql,currentPage,NUMBERS_PER_PAGE,jTemplate);
	 }
	 
	 /**分页构造函数
	  * @param sql 根据传入的sql语句得到一些基本分页信息
	  * @param currentPage 当前页
	  * @param numPerPage 每页记录数
	  * @param jTemplate JdbcTemplate实例
	  */
	 public Page(String sql,int currentPage,int numPerPage,JdbcTemplate jTemplate){
		 
		 
		 
		// 异常处理
	   if(jTemplate == null){
		 throw new IllegalArgumentException("com.deity.ranking.util.Pagination.jTemplate is null,please initial it first. ");
	   }else if(sql == null || sql.equals("")){
		 throw new IllegalArgumentException("com.deity.ranking.util.Pagination.sql is empty,please initial it first. ");
	   }
	   setIsFinished(0);
	   //设置每页显示记录数
	   setNumPerPage(numPerPage);
	   setCurrentPage(currentPage);
	   //计算总记录数
	   StringBuffer totalSQL = new StringBuffer(" SELECT count(*) FROM ( ");
	   totalSQL.append(sql);
	   totalSQL.append(" ) totalTable ");
	   //给JdbcTemplate赋值
	   setJdbcTemplate(jTemplate);
	   //总记录数
	   setTotalRows(getJdbcTemplate().queryForObject(totalSQL.toString(), Integer.class));
	   //计算总页数
	   setTotalPages();
	   //计算结束行数
	   setLastIndex();   
	   //装入结果集
	   List<Map<String, Object>> list = getJdbcTemplate().queryForList(getMySQLPageSQL(sql,startIndex,this.getLastIndex()));
	   Map<String, Object> map = new HashMap<String, Object>();
	   map.put("IsFinished", this.getIsFinished());
	   map.put("CurrentPage",this.getCurrentPage());
	   map.put("TotalPages",this.getTotalPages());
	   Map<String, Object> map2 = new HashMap<String, Object>();
	   map2.put("Page",map);
	   map2.put("list",list);
	   setResultList(map2);
	   
	   
	 }



/**
* 构造MySQL数据分页SQL 
* @param queryString
* @param startIndex
* @param pageSize
 * @param totalPages2 
* @return
*/
	public String getMySQLPageSQL(String queryString, Integer startIndex, Integer pageSize)
	{
		String result = "";
		if (null != startIndex && null != pageSize)
		{
		result = queryString + " limit " + startIndex + "," + pageSize;
		} else if (null != startIndex && null == pageSize)
		{
		result = queryString + " limit " + startIndex;
		} else
		{
		result = queryString;
		}
		System.out.println("result===" +result);
		return result;
	}


	
	
	 
	 public int getIsFinished() {
		return isFinished;
	}
	
	public void setIsFinished(int isFinished) {
		this.isFinished = isFinished;
	}

	public int getCurrentPage() {
	   return currentPage;
	 } 


	 public void setCurrentPage(int currentPage) {
	   this.currentPage = currentPage;
	 }


	 public int getNumPerPage() {
	   return numPerPage;
	 }


	 public void setNumPerPage(int numPerPage) {
	   this.numPerPage = numPerPage;
	 }


	 public Map getResultList() {
	   return resultList;
	 }


	 public void setResultList(Map resultList) {
	   this.resultList = resultList;
	 }


	 public int getTotalPages() {
	   return totalPages;
	 }
	//计算总页数
	 public void setTotalPages() {
		  //总行数 % 每页显示数量 
	   if(totalRows % numPerPage == 0){ // 如果能整除,总页数=除法结果
		 this.totalPages = totalRows / numPerPage;
	   }else{ // 如果不能整除,总页数=除法结果+1
		 this.totalPages = (totalRows / numPerPage) + 1;
	   }
	 }


	 public int getTotalRows() {
	   return totalRows;
	 }


	 public void setTotalRows(int totalRows) {
	   this.totalRows = totalRows;
	 }


	 public int getStartIndex() {
	   return startIndex;
	 }

	 // 计算数据的偏移量
	 public void setStartIndex() {
		// currentPage 当前页码
	   this.startIndex = (currentPage - 1) * numPerPage;
	 }


	 public int getLastIndex() {
	   return lastIndex;
	 }


	 public JdbcTemplate getJTemplate() {
	   return jTemplate;
	 }


	 public void setJTemplate(JdbcTemplate template) {
	   jTemplate = template;
	 }
	  
	//计算结束时候的索引
	 public void setLastIndex() {
	   //System.out.println("totalRows="+totalRows);///////////
	  //System.out.println("numPerPage="+numPerPage);///////////
	   // 总记录数 < 一页显示记录数 
	   if( totalRows < numPerPage){
		 this.lastIndex = totalRows;
		 setIsFinished(1);
	   }else if((totalRows % numPerPage == 0) || (totalRows % numPerPage != 0 && currentPage < totalPages)){
		 this.lastIndex = currentPage * numPerPage;
		 if(totalRows % numPerPage == 0 && currentPage >= totalPages){//最后一页
		   setIsFinished(1);
		 }
	   }else if(totalRows % numPerPage != 0 && currentPage >= totalPages){//最后一页
		 this.lastIndex = totalRows ;
		 setIsFinished(1);
	   }
	 }

}
