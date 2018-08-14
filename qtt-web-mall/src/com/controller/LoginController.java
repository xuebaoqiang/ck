package com.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.LoginService;
import com.utils.MD5;


/**
 * 登录页面
 * @ClassName:  LoginController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author:   
 * @date:   2018年8月6日 上午9:16:54   
 *     
 * @Copyright: 2018 www.qtt.com Inc. All rights reserved. 
 * 注意：本内容仅限于 北京全天通信息咨询服务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
	
	@Resource(name = "loginService")
	private LoginService loginService;
		
	@RequestMapping("/GoLogin")
	public String GoLogin(){
		return "login";
	}
	
	/**
	 * 登录
	 * @Title: Login   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @date:   2018年8月6日 下午2:36:51   
	 * @param: @param model
	 * @param: @param request
	 * @param: @param response
	 * @param: @param user
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	@RequestMapping("/Login")
	public void Login(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "name", required = true)String name,
			@RequestParam(value = "pwd", required = true)String pwd) throws Exception{
		/*response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
		response.setContentType("text/html;charset=utf-8");*/
		HttpSession session = request.getSession();
		String password = MD5.getMd5(pwd);
		List list = loginService.Login(name,password);
		Map<String,Object> map = (Map<String, Object>) list.get(0);
		if(map.get("type") == "1"){
			this.returnJson(1, "用户不存在!", response);
		}
		if(map.get("type") == "2"){
			this.returnJson(2, "密码错误!", response);
		}
		if(map.get("type") == "3"){
			session.setAttribute("name", name);
			this.returnJson(3, name, response);
		}
	}

	
}
