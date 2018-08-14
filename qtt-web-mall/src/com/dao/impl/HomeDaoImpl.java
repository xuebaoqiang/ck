package com.dao.impl;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.dao.HomeDao;
import com.pojo.TableDapp;
import com.utils.Page;

@Repository("homeDao")
public class HomeDaoImpl implements HomeDao {
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 查询展示
	 * <p>
	 * Title: ListHome
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 * @see com.dao.HomeDao#ListHome(java.lang.String)
	 */
	public Map ListHome(String name, int page, int pageSize, String pV_VALUE, String txNum_Value, String txValue_Value,String Cname)
			throws Exception {
		String sql = "select * from dappinfo where 1=1";

		if (name == "" || name == null) {
			sql += "";
		} else {
			sql += " and DappName like '%" + name + "%' ";
		}
		
		if (Cname == "" || Cname == null) {
			
			if (pV_VALUE == "" || pV_VALUE == null) {
				
				if (txNum_Value == "" || txNum_Value == null) {
					
					sql += "";
				} else {
					
					sql += " order by TxNum_Value desc";
				}
				
			} else {
				sql += " order by PV_VALUE desc";
			}
			
		} else {
			sql += " and ClassName like '%" + Cname + "%' ";
		}

		

		

		if (txValue_Value == "" || txValue_Value == null) {
			sql += "";
		} else {
			sql += " order by TxValue_Value desc";
		}

		Page repage = new Page(sql, page, pageSize, jdbcTemplate);
		return repage.getResultList();

	}

	/**
	 * 统计数量
	 * <p>
	 * Title: GetNumber
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @see com.dao.HomeDao#GetNumber()
	 */
	public List<Map<String, Object>> GetNumber() {
		String sql = "SELECT count(*) AS cn,(SELECT count(*) FROM table_dapp WHERE DappCreateDate >= (select date_format(now(),'%y-%m-%d'))) AS coun FROM table_dapp";
		return jdbcTemplate.queryForList(sql);
	}

	/**
	 * 添加
	 * <p>
	 * Title: insertAPPlication
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param tab
	 * @return 
	 * @throws Exception
	 * @see com.dao.HomeDao#insertAPPlication(com.pojo.TableDapp)
	 */
	public int insertAPPlication(TableDapp tab) throws Exception {
		int i = 0;
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		String date = df.format(new Date());
		PreparedStatementCreator preparedStatementCreator = con -> {
			PreparedStatement ps = con.prepareStatement(
					"insert into table_dapp(DappName,DappEmail,DappResume,DappExplain,DappWeb,DappLogo,DappOwner,DappAddress,"
							+ "DappWeiBo,DappTelegram,DappWeChat,DappChainInfo,DappGit,DappStates,DappClassInfo,DappCreateDate,DappUpdateDate)  values('"
							+ tab.getDappname() + "','" + tab.getDappemail() + "','" + tab.getDappresume() + "','"
							+ tab.getDappexplain() + "','" + tab.getDappweb() + "','" + tab.getDapplogo() + "','"
							+ tab.getDappowner() + "','" + tab.getDappaddress() + "','" + tab.getDappweibo() + "','"
							+ tab.getDapptelegram() + "','" + tab.getDdappwechat() + "','" + tab.getDappchaininfo()
							+ "','" + tab.getDappgit() + "'," + tab.getDappstates() + "," + tab.getDappclassinfo()
							+ ",'" + date + "','" + date + "')",
					Statement.RETURN_GENERATED_KEYS);
			return ps;
		};

		// System.out.println("添加sql===" + preparedStatementCreator);
		jdbcTemplate.update(preparedStatementCreator, keyHolder);
		// System.out.println("添加id==="+keyHolder.getKey().longValue());
		long id = keyHolder.getKey().longValue();
		if (id != 0 && id > 0) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");// 设置日期格式
			String dateform = formatter.format(new Date());
			String selectSql = "update table_dapp set DappIndex = "+id+" where RowId = " + id; 
			//System.out.println(selectSql);
			jdbcTemplate.update(selectSql);
			String addInfo = "insert into table_info(DappId,DappName,DappInsertTime) values("+id+",'"+tab.getDappname()+"','"+dateform+"')";
			//System.out.println(addInfo);
			jdbcTemplate.update(addInfo);
			i = 1;
		}
		return i;

	}

	/**
	 * 取添加页面返回标签列表
	 * <p>
	 * Title: GetListClassInFo
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @see com.dao.HomeDao#GetListClassInFo()
	 */
	public List<Map<String, Object>> GetListClassInFo() {
		String sql = "select * from table_dapp_classinfo";
		return jdbcTemplate.queryForList(sql);
	}

	/**
	 * 查询详情信息
	 * <p>Title: GerGoDetails</p>   
	 * <p>Description: </p>   
	 * @param id
	 * @return   
	 * @see com.dao.HomeDao#GerGoDetails(int)
	 */
	public Map<String, Object> GerGoDetails(int id) {
		String sql = "SELECT dapp.RowID,dapp.DappName,dapp.DappResume,dapp.DappExplain,dapp.DappWeb,dapp.DappOwner,dapp.DappAddress,dapp.DappCreateDate,dapp.DappUpdateDate,sta.StateName,cal.ClassName FROM"
				+ " table_dapp AS dapp,table_dapp_state AS sta,table_dapp_classinfo cal WHERE dapp.DappStates=sta.Id AND dapp.DappClassInfo=cal.Id AND dapp.RowID = " + id;
		
		return jdbcTemplate.queryForMap(sql);
	}

	/**
	 * 获取第一条记录
	 * <p>Title: getStart</p>   
	 * <p>Description: </p>   
	 * @return   
	 * @see com.dao.HomeDao#getStart()
	 */
	public Map<String, Object> getStart() {
		String sql = "select * from table_dapp limit 1";
		return jdbcTemplate.queryForMap(sql);
	}

	/**
	 * 获取最后一条记录
	 * <p>Title: getEnd</p>   
	 * <p>Description: </p>   
	 * @return   
	 * @see com.dao.HomeDao#getEnd()
	 */
	public Map<String, Object> getEnd() {
		String sql = "select * from table_dapp order by RowID DESC limit 1";
		return jdbcTemplate.queryForMap(sql);
	}
}
