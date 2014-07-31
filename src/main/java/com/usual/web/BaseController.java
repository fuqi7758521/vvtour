package com.usual.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.Assert;

import com.common.utils.Constants;
import com.usual.entity.AdminInfo;

public class BaseController {

	protected static final String ERROR_MSG_KEY = "errorMsg";
	
	protected static final String SUCCESS_MSG_KEY = "successMsg";
	
	protected static final String SUCCESS_DATA = "successData";
	
	protected static final String OPERATE_TYPE = "operateType";
	
	protected static final String MEMORY_URL = "memoryUrl";
	
	protected static final String URL_REDIRECT = "redirect:";
	
	protected static final String URL_FORWARD = "forward:";
	
	protected static final String DO_SUCCESS = "admin/doSuccess";
	
	protected static final String DO_FAIL = "admin/doFail";
	
	protected static final String SPRIT = "/";
	
	public static final int PAGE_SIZE = 30;
	
	protected AdminInfo getSessionAdmin(HttpServletRequest request){
		return (AdminInfo)request.getSession().getAttribute(Constants.LOGIN_ADMIN_KEY);
	}
	
	protected void setSssionAdmin(HttpServletRequest request,AdminInfo info){
		request.getSession().setAttribute(Constants.LOGIN_ADMIN_KEY, info);
	}
	
	public final String getAppbaseUrl(HttpServletRequest request,String url){
		Assert.hasLength(url,"url不能为空");
		Assert.isTrue(url.startsWith("/"),"必须以/开头");
		return request.getContextPath() + url;
	}
}
