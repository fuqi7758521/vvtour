package com.vvtour.shop.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.usual.web.BaseController;
import com.vvtour.shop.criteria.SearchPagerModel;
import com.vvtour.shop.criteria.UserCriteria;
import com.vvtour.shop.entity.User;
import com.vvtour.shop.utils.RequestUtil;

/**
 * 用户controller
 * @author fuqi
 * @date 2014-08-02 16:34
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	
	private final static Logger logger = Logger.getLogger(UserController.class);

	//邮箱注册页面
	private static final String USER_SIGN_UP_BY_EMAIL = "front/user/signUpByEmail";
	
	//电话注册页面
	private static final String USER_SIGN_UP_BY_PHONE = "front/user/signUpByPhone";
	
	//登录页面
	private static final String USER_SIGN_IN = "front/user/signin";
	
	//首页
	private static final String INDEX = "";
	
	//用户中心
	private static final String USER_INFO_CENTER = "front/user/userInfoCenter";
	
	//修改密码
	private static final String USER_CHANGE_PASSWORD = "front/user/changePassword";
	
	//用户信息详情
	private static final String USER_DETAIL = "front/user/userDetail";
	
	//邮箱验证页面
	private static final String USER_VERIFY_EMAIL = "";
	
	//找回密码页面
	private static final String USER_FIND_PASSWORD = "front/user/findPassword";
	
	//邮箱找回密码页面
	private static final String USER_FIND_PASSWORD_BY_EMAIL = "findPasswordByEmail";
	
	//手机号找回密码页面
	private static final String USER_FIND_PASSWORD_BY_MOBILE_PHONE = "";
	
	@Autowired
	private UserService userService;
	
	//进入邮箱注册页面
	@RequestMapping("/goSignUpByEmail.htm")
	public ModelAndView goSignUpByEmail(User user, HttpServletRequest request, HttpServletResponse response){
		
		
		return new ModelAndView(USER_SIGN_UP_BY_EMAIL);
		
	}
	
	//进入手机注册页面
	@RequestMapping("/goSignUpByPhone.htm")
	public ModelAndView goSignUpByPhone(User user, HttpServletRequest request, HttpServletResponse response){
		
		
		return new ModelAndView(USER_SIGN_UP_BY_PHONE);
		
	}
	
	//注册
	@RequestMapping("/signUp")
	public ModelAndView signUp(User user, HttpServletRequest request, HttpServletResponse response){
		userService.addUpdateUser(user);
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
	
	
	//用户信息详情
	@RequestMapping("/goUserDetail")
	public ModelAndView goUserDetail(HttpServletRequest request, HttpServletResponse response){
		
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
		return new ModelAndView(USER_DETAIL);
	}
	
	//更新个人信息
	@RequestMapping("/updateUserInfo")
	public ModelAndView updateUserInfo(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView(USER_DETAIL);
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
	
	//判断所填邮箱是否已经被注册
	@RequestMapping("checkEmailExisted.htm")
	public @ResponseBody Map<String, String> checkEmailExisted(HttpServletRequest request, HttpServletResponse response){
		String email = RequestUtil.getString(request, "email");
		UserCriteria criteria = new UserCriteria();
		criteria.setEmail(email);
//		SearchPagerModel<User> users = userService.getUsers(criteria);
		SearchPagerModel<User> users = new SearchPagerModel<User>();
		users.setTotal(1);
		
		Map<String, String> result = new HashMap<String, String>();
		if(users == null || users.getTotal() == 0){
			result.put("success", "false");
			result.put("msg", "邮箱不存在，可以注册");
		}else{
			result.put("success", "true");
			result.put("msg", "邮箱已存在，不可以注册");
		}
		return result;
	}
	
}

