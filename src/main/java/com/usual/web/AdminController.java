package com.usual.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.common.utils.PublicResult;
import com.common.utils.RequestUtils;
import com.usual.entity.AdminInfo;
import com.usual.service.AdminInfoService;
import com.usual.utils.ValidateUtil;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController{
	
	private final static Logger logger = Logger.getLogger(AdminController.class);
	
	@Autowired
	private AdminInfoService adminInfoService;
	
	@RequestMapping("/register")
	public String register(){
		return "admin/register";
	}
	
	@RequestMapping("/login")
	public String toLogin(){
		return "admin/login";
	}
	
	@RequestMapping("/index")
	public String toIndex(){
		return "admin/index";
	}
	
	@RequestMapping("/webinfo")
	public String webinfo(){
		return "admin/webinfo";
	}
	
	@RequestMapping("/admininfo")
	public String admininfo(){
		return "admin/admininfo";
	}
	
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public ModelAndView registAdminUser(HttpServletRequest request,AdminInfo info){
		ModelAndView mav = new ModelAndView();
		/**
		 * 验证数据
		 * 1. admin_name
		 * 2. password
		 * 3. real_name
		 * */
		PublicResult<Boolean> validateResult = ValidateUtil.checkRegistAdmin((AdminInfo) info);
		if(!validateResult.isSuccess()){
			mav.setViewName("admin/register");
			mav.addObject("validateMsg",validateResult.getCnErrorMsg());
			return mav;
		}
		info.setLast_ip(RequestUtils.getRemoteAddr(request));
		info.setStatus(AdminInfo.USER_UNAUDITED);
		
		info.setRegist_time(System.currentTimeMillis());
		/**
		 * 调用注册方法
		 * */
		PublicResult<String> result = adminInfoService.registAdmin(info);
		if(result.isSuccess()){
			if(!StringUtils.isBlank(result.getModel())){
				info.setAdmin_id(result.getModel());
			}
			mav.addObject("admin",info);
		}else{
			mav.addObject(ERROR_MSG_KEY,"注册失败！");
		}
		mav.setViewName("admin/registSuccess");
		return mav;
	}
	
	@RequestMapping(value="/doLogin",method=RequestMethod.POST)
	public ModelAndView login(@RequestParam("pinCode") String pinCode,HttpServletRequest request,AdminInfo info){
		PublicResult<AdminInfo> result = adminInfoService.queryAdminInfoByUserName(info.getAdmin_name());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(URL_FORWARD + "/admin/login.htm");
		if(!result.isSuccess()){
			mav.addObject(ERROR_MSG_KEY, result.getCnErrorMsg());
		} else {
			AdminInfo dbInfo = result.getModel();
			if(!dbInfo.getPassword().equals(info.getPassword())){
				mav.addObject(ERROR_MSG_KEY, "用户密码不正确");
			} else if (dbInfo.getStatus() == AdminInfo.USER_LOCK) {
				mav.addObject(ERROR_MSG_KEY, "用户已经被屏蔽，不能登录。");
			} else if (dbInfo.getStatus() == AdminInfo.USER_UNAUDITED) {
				mav.addObject(ERROR_MSG_KEY, "用户还未审核，不能登录。");
			} else{
				dbInfo.setLast_ip(RequestUtils.getRemoteAddr(request));
				dbInfo.setLast_login(System.currentTimeMillis());
				setSssionAdmin(request,dbInfo);
				
			  /*String toUrl = (String)request.getSession().getAttribute(Constants.LOGIN_TO_URL);
				request.getSession().removeAttribute(Constants.LOGIN_TO_URL);
				//如果当前会话中没有保存登录之前的请求URL，则直接跳转到主页
				if(StringUtils.isEmpty(toUrl)){
					toUrl = "/index.html";
				}*/
				
				mav.setViewName(URL_REDIRECT + "/admin/index.htm");
			}
			
		}
		return mav;
	}
	
	@RequestMapping(value="/admin_list")
	public ModelAndView adminList(@RequestParam(value = "p", required = false) Integer pageNo){
		ModelAndView mav = new ModelAndView();
		pageNo = pageNo==null?1:pageNo;
		int startIndex = (pageNo - 1) * PAGE_SIZE;
		
		PublicResult<AdminInfo> result = adminInfoService.queryAdminInfoList(startIndex, PAGE_SIZE);
		if(result.isSuccess()){
			mav.addObject("adminList", result.getModelList());
		}
		
		mav.setViewName("admin/adminList");
		return mav;
	}
	
	
	/**
	 * 屏蔽普通管理员
	 * */
	@RequestMapping(value="/lockAdmin")
	public ModelAndView lockAdmin(@RequestParam(value = "id", required = false) String id){
		ModelAndView mav = new ModelAndView();
		mav.setViewName(URL_FORWARD + "/admin/admin_list.htm");
		try {
			if (StringUtils.isBlank(id)) {
				mav.addObject(ERROR_MSG_KEY, "参数不能为空，请联系技术人员");
			}else {
				PublicResult<Boolean> result = adminInfoService.updateAdminInfoStatus(id, AdminInfo.USER_LOCK);
				if(!result.isSuccess()){
					mav.addObject(ERROR_MSG_KEY, result.getCnErrorMsg());
				}else{
					mav.setViewName(URL_REDIRECT + "/admin/admin_list.htm");
				}
			}
			
			return mav;
		}catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, ex.getMessage());
			return mav;
		}
	}
	
	/**
	 * 审核普通管理员
	 * */
	@RequestMapping(value="/authAdmin")
	public ModelAndView authAdmin(@RequestParam(value = "id", required = false) String id){
		ModelAndView mav = new ModelAndView();
		mav.setViewName(URL_FORWARD + "/admin/admin_list.htm");
		try {
			if (StringUtils.isBlank(id)) {
				mav.addObject(ERROR_MSG_KEY, "参数不能为空，请联系技术人员");
			}else {
				PublicResult<Boolean> result = adminInfoService.updateAdminInfoStatus(id, AdminInfo.USER_OPEN);
				if(!result.isSuccess()){
					mav.addObject(ERROR_MSG_KEY, result.getCnErrorMsg());
				}else{
					mav.setViewName(URL_REDIRECT + "/admin/admin_list.htm");
				}
			}
			
			return mav;
		}catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, ex.getMessage());
			return mav;
		}
	}
	

}
