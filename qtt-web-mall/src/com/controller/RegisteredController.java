package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.RegisteredService;
import com.utils.MD5;


@Controller
@RequestMapping("/registered")
public class RegisteredController extends BaseController{
	
	@Resource(name = "registeredService")
	private RegisteredService registeredService;
	
	@RequestMapping("/GoRegistered")
	public String GoLogin(){
		return "registered";
	}
	
	/**
	 * 验证用户名是否存在
	 * @Title: ValidationUser   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @date:   2018年8月9日 下午2:14:19   
	 * @param: @param model
	 * @param: @param request
	 * @param: @param response
	 * @param: @param uname
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	@RequestMapping("/ValidationUser")
	public void ValidationUser(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "uname", required = true)String uname) throws Exception{
		int  i = registeredService.ValidationUser(uname);
		this.returnJson(0, i, response);
		
	}
	
	/**
	 * 注册
	 * @Title: InsertRegistered   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @date:   2018年8月9日 下午5:53:07   
	 * @param: @param model
	 * @param: @param request
	 * @param: @param response
	 * @param: @param uname
	 * @param: @param password
	 * @param: @param email
	 * @param: @param ethurl
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	@RequestMapping("/InsertRegistered")
	public void InsertRegistered(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "uname", required = true)String uname,
			@RequestParam(value = "password", required = true)String password,
			@RequestParam(value = "email", required = true)String email,
			@RequestParam(value = "ethurl", required = true)String ethurl) throws Exception{
			String pwd = MD5.getMd5(password);
			int i= registeredService.InsertRegistered(uname,pwd,email,ethurl);
			//System.out.println(i);
			this.returnJson(0, i, response);
		
	}


	
}
