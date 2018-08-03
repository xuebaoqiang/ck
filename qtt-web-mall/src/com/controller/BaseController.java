/**
 * 
 */
package com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.utils.BaseResultVo;

/**
 * 基础controller ClassName: BaseController
 * 
 * @Description: TODO
 * @author 吴澍(shu.wu@youyujinfu.com)
 * @date 2015年11月21日上午10:51:26
 */
public class BaseController {
	private static final Log LOGGER = LogFactory.getLog(BaseController.class);

	SerializerFeature[] feature = { SerializerFeature.DisableCircularReferenceDetect,
			SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty,
			SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.WriteMapNullValue };

	/**
	 * 构造成功返回结果
	 * 
	 * @Description: TODO
	 * @param @param
	 *            resultData
	 * @param @return
	 * @return BaseResultVo
	 * @throws @author
	 *             吴澍(shu.wu@youyujinfu.com)
	 * @date 2015年11月21日上午10:51:35
	 */
	protected BaseResultVo buildSuccessResultInfo(Object resultData) {
		LOGGER.debug(String.format("enter function, %s", resultData));
		BaseResultVo resultVo = new BaseResultVo();
		resultVo.setResultData(resultData);
		resultVo.setResultMessage("success");
		return resultVo;
	}

	/**
	 * 构造失败返回结果
	 * 
	 * @Description: TODO
	 * @param @param
	 *            resultCode
	 * @param @param
	 *            failedMsg
	 * @param @return
	 * @return BaseResultVo
	 * @throws @author
	 *             吴澍(shu.wu@youyujinfu.com)
	 * @date 2015年11月21日上午10:51:42
	 */
	protected BaseResultVo buildFailedResultInfo(int resultCode, String failedMsg) {
		BaseResultVo resultVo = new BaseResultVo(resultCode, failedMsg);
		return resultVo;
	}
	/********************** 通用返回未登录提示 开始 ***************************/
	protected void getNotLogin(String resultMessage,  HttpServletResponse response)
			throws IOException {
		returnJson(-1, resultMessage, null, response);
	}  
	/********************** 通用返回未登录提示 结束 ***************************/
	/********************** 通用返回失败 开始 ***************************/
	protected void getError(String resultMessage,  HttpServletResponse response)
			throws IOException {
		returnJson(1, resultMessage, null, response);
	} 
	/********************** 通用返回失败 结束 ***************************/
	/********************** 通用返回成功 开始 ***************************/
	protected void getSuccess(String resultMessage, Object resultData, HttpServletResponse response)
			throws IOException {
		returnJson(0, resultMessage, resultData, response);
	}

	protected void getSuccess(String resultMessage, HttpServletResponse response) throws IOException {
		getSuccess(resultMessage, null, response);
	}

	protected void getSuccess(Object resultData, HttpServletResponse response) throws IOException {
		getSuccess(null, resultData, response);
	} 

	/********************** 通用返回成功 结束 ***************************/	
	/********************** 通用数据返回AJAX 开始 ***************************/
	/**
	 * 以json格式返回数据给前端
	 * 
	 * @Description: 以json格式返回数据给前端
	 * @param @param
	 *            resultVo
	 * @param @param
	 *            response
	 * @param @throws
	 *            IOException
	 * @return void
	 * @throws @author
	 *             吴澍(shu.wu@youyujinfu.com)
	 * @date 2015年11月23日下午3:02:13
	 */
	protected void returnJson(BaseResultVo resultVo, HttpServletResponse response) throws IOException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("resultVo", resultVo);
		returnJson(jsonObject, response);
	}
	protected void returnJson(JSONObject jsonObject, HttpServletResponse response) throws IOException { 
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().print(jsonObject);
	}
	protected void returnJson(int resultCode, String resultMessage, Object resultData, HttpServletResponse response)
			throws IOException {
		BaseResultVo resultVo = new BaseResultVo();
		resultVo.setResultCode(resultCode);
		if (resultData != null)
			resultVo.setResultData(resultData);
		if (resultMessage != null)
			resultVo.setResultMessage(resultMessage);
		returnJson(resultVo, response);
	}

	protected void returnJson(int resultCode, HttpServletResponse response) throws IOException {
		returnJson(resultCode, null, null, response);
	}

	protected void returnJson(int resultCode, String resultMessage, HttpServletResponse response) throws IOException {
		returnJson(resultCode, resultMessage, null, response);
	}

	protected void returnJson(int resultCode, Object resultData, HttpServletResponse response) throws IOException {
		returnJson(resultCode, null, resultData, response);
	}
	/********************** 通用数据返回AJAX 结束 ***************************/
	public static void main(String[] args) {
		JSONObject jsonObject = new JSONObject();
		BaseResultVo v = new BaseResultVo();
		v.setResultCode(1);
		v.setResultData("存放的数据");
		v.setResultMessage("操作居功");
		v.setResultMessage("操作失败");
		jsonObject.put("resultVo", v);
		System.out.println(jsonObject);
	}
}
