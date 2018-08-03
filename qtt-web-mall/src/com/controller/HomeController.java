package com.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pojo.TableDapp;
import com.service.HomeService;

/**
 * 应用商城首页
 * 
 * @ClassName: HomeController
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 薛宝强 (xuebaoqiang@qq.com)
 * @date: 2018年7月24日 上午11:29:43
 * 
 * @Copyright: 2018 www.qtt.com Inc. All rights reserved. 注意：本内容仅限于
 *             北京全天通信息咨询服务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
@RequestMapping("/home")
public class HomeController extends BaseController {

	@Resource(name = "homeService")
	private HomeService homeService;

	public void setHomeService(HomeService homeService) {
		this.homeService = homeService;
	}

	/**
	 * @throws Exception 
	 * 查询展示方法
	 * @Title: ListHome   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @author: 薛宝强 (xuebaoqiang@qq.com)     
	 * @date:   2018年7月24日 上午11:29:59   
	 * @param: @param model
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	@RequestMapping("/ListHome")
	public String ListHome(ModelMap model,HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "name", required = false) String username,
			@RequestParam(value = "Classname", required = false) String Classname,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			@RequestParam(value = "pageSize", defaultValue = "20", required = false) int pageSize,
			@RequestParam(value = "PV_VALUE", required = false) String PV_VALUE,
			@RequestParam(value = "TxNum_Value", required = false) String TxNum_Value,
			@RequestParam(value = "TxValue_Value", required = false) String TxValue_Value) throws Exception{
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("username");
		String Cname = request.getParameter("Classname");
		Map list = homeService.ListHome(name,page,pageSize,PV_VALUE,TxNum_Value,TxValue_Value,Cname);
		List<Map<String, Object>> con = homeService.GetNumber();
		model.put("list", list);
		model.put("con", con);
		return "App_home";
	}

	/**
	 * 去添加页面 @Title: GoAdd @Description: TODO(这里用一句话描述这个方法的作用) @author: 薛宝强
	 * (xuebaoqiang@qq.com) @date: 2018年7月25日 上午9:20:53 @param: @param
	 * model @param: @param request @param: @param
	 * response @param: @return @return: String @throws
	 */
	@RequestMapping("/GoAdd")
	public String GoAdd(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		List<Map<String, Object>> list = homeService.GetListClassInFo();
		System.out.println(list);
		model.put("list", list);
		return "Add_application";

	}

	/**
	 * 添加 @Title: InsertApplication @Description: TODO(这里用一句话描述这个方法的作用) @author:
	 * 薛宝强 (xuebaoqiang@qq.com) @date: 2018年7月25日 上午11:39:31 @param: @param
	 * model @param: @param request @param: @param response @param: @param
	 * tab @param: @return @param: @throws Exception @return: String @throws
	 */
	@RequestMapping("/InsertApplication")
	public void InsertApplication(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			TableDapp tab) throws Exception {
		homeService.insertAPPlication(tab);

	}
	
	/**
	 * 查询详情
	 * @Title: GerGoDetails   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @author: 薛宝强 (xuebaoqiang@qq.com)     
	 * @date:   2018年8月1日 上午9:50:36   
	 * @param: @param model
	 * @param: @param request
	 * @param: @param response
	 * @param: @param id
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: String      
	 * @throws
	 */
	@RequestMapping("/GerGoDetails")
	public String GerGoDetails(ModelMap model,HttpServletRequest request, HttpServletResponse response,int id)throws Exception{
		Map<String,Object> map = homeService.GerGoDetails(id);
		Map<String,Object> mapstart = homeService.getStart();
		Map<String,Object> mapend = homeService.getEnd();
		model.put("map", map);
		model.put("mapstart", mapstart);
		model.put("mapend", mapend);
		return "details";
	}
}
