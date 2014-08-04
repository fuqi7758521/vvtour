package com.vvtour.shop.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.admin.Constant;
import com.admin.criteria.SearchPagerModel;
import com.admin.criteria.UserCriteria;
import com.admin.entity.User;
import com.admin.service.UserService;
import com.admin.utils.JsonUtil;
import com.admin.utils.RequestUtil;
import com.usual.web.BaseController;

/**
 * 用户controller
 * @author fuqi
 * @date 2014-08-02 16:34
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	
	private final static Logger logger = Logger.getLogger(UserController.class);

	//注册页面
	private static final String USER_SIGN_UP = "";
	
	//登录页面
	private static final String USER_SIGN_IN = "";
	
	//首页
	private static final String INDEX = "";
	
	//用户中心
	private static final String USER_INFO_CENTER = "";
	
	//修改密码
	private static final String USER_CHANGE_PASSWORD = "";
	
	//用户信息详情
	private static final String USER_UPDATE_INFO_DETAIL = "";
	
	//邮箱验证页面
	private static final String USER_VERIFY_EMAIL = "";
	
	//找回密码页面
	private static final String USER_FIND_PASSWORD = "";
	
	//邮箱找回密码页面
	private static final String USER_FIND_PASSWORD_BY_EMAIL = "";
	
	//手机号找回密码页面
	private static final String USER_FIND_PASSWORD_BY_MOBILE_PHONE = "";
	
	@Autowired
	private UserService userService;
	
	//进入注册页面
	@RequestMapping("/goSignUp")
	public ModelAndView goSignUp(User user, HttpServletRequest request, HttpServletResponse response){
		
		
		return new ModelAndView(USER_SIGN_UP);
		
	}
	
	//注册
	@RequestMapping("/signUp")
	public ModelAndView signUp(HttpServletRequest request, HttpServletResponse response){
		
		return new ModelAndView(INDEX);
		
	}
	
	//进入登录页面
	@RequestMapping("/goSignIn")
	public ModelAndView goSignIn(User user, HttpServletRequest request, HttpServletResponse response){
		
		return new ModelAndView(USER_SIGN_IN);
		
	}
	
	//登录
	@RequestMapping("/signIn")
	public ModelAndView signIn(HttpServletRequest request, HttpServletResponse response){
		
		return new ModelAndView(INDEX);
		
	}
	
	
	//用户中心
	@RequestMapping("/goUserCenter")
	public ModelAndView goUserCenter(HttpServletRequest request, HttpServletResponse response){
		
		return new ModelAndView(USER_INFO_CENTER);
		
	}
	
	//进入密码修改页面
	@RequestMapping("/goChangePassword")
	public ModelAndView goChangePassword(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView(USER_CHANGE_PASSWORD);
	}
	
	//修改密码 
	@RequestMapping("/changePassword")
	public ModelAndView chagePassword(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView(USER_INFO_CENTER);
	}
	
	//用户个人信息详情
	@RequestMapping("/goUpdateUserInfo")
	public ModelAndView goUpdateUserInfo(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView(USER_UPDATE_INFO_DETAIL);
	}
	
	//更新个人信息
	@RequestMapping("/updateUserInfo")
	public ModelAndView updateUserInfo(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView(USER_UPDATE_INFO_DETAIL);
	}
	
	//进入邮箱验证页面
	@RequestMapping("/goVerifyEmail")
	public ModelAndView goVerifyEmail(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView(USER_VERIFY_EMAIL);
	}
	
	//验证邮箱
	@RequestMapping("/verifyEmail")
	public ModelAndView verifyEmail(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView();
	}
	
	//找回密码
	@RequestMapping("/goFindPassword")
	public ModelAndView goFindPassword(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView(USER_FIND_PASSWORD);
	}
	
	//进入通过邮箱找回密码页面
	@RequestMapping("/goFindPasswordByEmail")
	public ModelAndView goFindPasswordByEmail(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView(USER_FIND_PASSWORD_BY_EMAIL);
	}
	
	//发送邮件，在邮件里面有新的密码
	@RequestMapping("/findPasswordByEmail")
	public ModelAndView findPasswordByEmail(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView();
	}
	
	//进入通过手机找回密码页面
	@RequestMapping("/goFindPasswordByPhone")
	public ModelAndView goFindPasswordByPone(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView(USER_FIND_PASSWORD_BY_MOBILE_PHONE);
	}
	
	//通过手机找回密码页面
	@RequestMapping("/findPasswordByPhone")
	public ModelAndView findPasswordByPone(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView();
	}
	
}

