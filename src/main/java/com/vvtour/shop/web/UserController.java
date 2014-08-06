package com.vvtour.shop.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
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
import com.vvtour.shop.utils.MessageDigestUtil;
import com.vvtour.shop.utils.RequestUtil;
import com.vvtour.shop.service.UserService;
import com.vvtour.shop.Constant;
import com.vvtour.shop.utils.JsonUtil;

/**
 * 用户controller
 * @author fuqi
 * @date 2014-08-02 16:34
 */
@Controller
public class UserController extends BaseController {
	
	private final static Logger logger = Logger.getLogger(UserController.class);

	//邮箱注册页面
	private static final String USER_SIGN_UP_BY_EMAIL = "front/user/signUpByEmail";
	
	//电话注册页面
	private static final String USER_SIGN_UP_BY_PHONE = "front/user/signUpByPhone";
	
	//邮箱注册成功页面
	private static final String USER_SIGN_UP_BY_EMAIL_SUCCESS = "front/user/signUpByEmailSuccess";
	
	//手机注册成功页面
	private static final String USER_SIGN_UP_BY_MOBILE_SUCCESS = "front/user/signUpByMobileSuccess";
	
	//登录页面
	private static final String USER_SIGN_IN = "front/user/signIn";
	
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
	@RequestMapping("/user/goSignUpByEmail.htm")
	public ModelAndView goSignUpByEmail(User user, HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView(USER_SIGN_UP_BY_EMAIL);
	}
	
	//进入手机注册页面
	@RequestMapping("/user/goSignUpByPhone.htm")
	public ModelAndView goSignUpByPhone(User user, HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView(USER_SIGN_UP_BY_PHONE);
	}
	
	//注册
	@RequestMapping("/user/signUp.htm")
	public ModelAndView signUp(User user, HttpServletRequest request, HttpServletResponse response){
		if(StringUtils.isEmpty(user.getUsername())){
			return new ModelAndView("forword:/user/goSignUpByEmail.htm");
		}
		user.setPassword(MessageDigestUtil.getMD5(user.getPassword() + Constant.PASSWORD_SALT_KEY));
		userService.addUser(user);
		Map<String, String> result = new HashMap<String, String>();
		if(StringUtils.isNotEmpty(user.getEmail())){
			result.put("email", user.getEmail());
			return new ModelAndView(USER_SIGN_UP_BY_EMAIL_SUCCESS,result);
		}
		if(StringUtils.isNotEmpty(user.getMobilePhone())){
			result.put("mobile", user.getMobilePhone());
			return new ModelAndView(USER_SIGN_UP_BY_MOBILE_SUCCESS,result);
		}
		return null;
		
	}
	
	//进入登录页面
	@RequestMapping("/user/goSignIn.htm")
	public ModelAndView goSignIn(User user, HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView(USER_SIGN_IN);
	}
	
	//登录
	@RequestMapping("/user/signIn.htm")
	public ModelAndView signIn(HttpServletRequest request, HttpServletResponse response){
		String identity = RequestUtil.getString(request, "identity");
		String password = RequestUtil.getString(request, "password");
		password=MessageDigestUtil.getMD5(password + Constant.PASSWORD_SALT_KEY);
		UserCriteria criteria = new UserCriteria();
		criteria.setPassword(password);
		criteria.setUsername(identity);
		User user = userService.getUser(criteria);
		if(user != null){
			
			return new ModelAndView(INDEX);
		}
		
		criteria = new UserCriteria();
		criteria.setEmail(identity);
		user = userService.getUser(criteria);
		if(user != null){
			return new ModelAndView(INDEX);
		}
		
		criteria = new UserCriteria();
		criteria.setMobilePhone(identity);
		user = userService.getUser(criteria);
		if(user != null){
			return new ModelAndView(INDEX);
		}
		return new ModelAndView("forword:/user/goSignIn.htm");
		
	}
	
	
	//用户信息详情
	@RequestMapping("/user/goUserDetail")
	public ModelAndView goUserDetail(HttpServletRequest request, HttpServletResponse response){
		
		return new ModelAndView(USER_INFO_CENTER);
		
	}
	
	//进入密码修改页面
	@RequestMapping("/user/goChangePassword")
	public ModelAndView goChangePassword(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView(USER_CHANGE_PASSWORD);
	}
	
	//修改密码 
	@RequestMapping("/uer/changePassword")
	public ModelAndView chagePassword(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView(USER_INFO_CENTER);
	}
	
	//用户个人信息详情
	@RequestMapping("/user/goUpdateUserInfo")
	public ModelAndView goUpdateUserInfo(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView(USER_DETAIL);
	}
	
	//更新个人信息
	@RequestMapping("/user/updateUserInfo")
	public ModelAndView updateUserInfo(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView(USER_DETAIL);
	}
	
	//进入邮箱验证页面
	@RequestMapping("/user/goVerifyEmail")
	public ModelAndView goVerifyEmail(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView(USER_VERIFY_EMAIL);
	}
	
	//验证邮箱
	@RequestMapping("/user/verifyEmail")
	public ModelAndView verifyEmail(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView();
	}
	
	//找回密码
	@RequestMapping("/user/goFindPassword")
	public ModelAndView goFindPassword(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView(USER_FIND_PASSWORD);
	}
	
	//进入通过邮箱找回密码页面
	@RequestMapping("/user/goFindPasswordByEmail")
	public ModelAndView goFindPasswordByEmail(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView(USER_FIND_PASSWORD_BY_EMAIL);
	}
	
	//发送邮件，在邮件里面有新的密码
	@RequestMapping("/user/findPasswordByEmail")
	public ModelAndView findPasswordByEmail(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView();
	}
	
	//进入通过手机找回密码页面
	@RequestMapping("/user/goFindPasswordByPhone")
	public ModelAndView goFindPasswordByPone(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView(USER_FIND_PASSWORD_BY_MOBILE_PHONE);
	}
	
	//通过手机找回密码页面
	@RequestMapping("/user/findPasswordByPhone")
	public ModelAndView findPasswordByPone(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView();
	}
	
	//判断所填邮箱是否已经被注册
	@RequestMapping("/user/checkEmailExisted.htm")
	public @ResponseBody Map<String, String> checkEmailExisted(HttpServletRequest request, HttpServletResponse response){
		String email = RequestUtil.getString(request, "email");
		UserCriteria criteria = new UserCriteria();
		criteria.setEmail(email);
		User user = userService.getUser(criteria);
		
		Map<String, String> result = new HashMap<String, String>();
		if(user == null){
			result.put("success", "false");
			result.put("msg", "邮箱不存在，可以注册");
		}else{
			result.put("success", "true");
			result.put("msg", "邮箱已存在，不可以注册");
		}
		return result;
	}
	
	//判断所填用户名是否已经被注册
	@RequestMapping("/user/checkUsernameExisted.htm")
	public @ResponseBody Map<String, String> checkUsernameExisted(HttpServletRequest request, HttpServletResponse response){
		String username = RequestUtil.getString(request, "username");
		UserCriteria criteria = new UserCriteria();
		criteria.setUsername(username);
		User user = userService.getUser(criteria);
		
		Map<String, String> result = new HashMap<String, String>();
		if(user == null){
			result.put("success", "false");
			result.put("msg", "用户名不存在，可以注册");
		}else{
			result.put("success", "true");
			result.put("msg", "用户名已存在，不可以注册");
		}
		return result;
	}
	
	//判断所填手机号是否已经被注册
	@RequestMapping("/user/checkMobileExisted.htm")
	public @ResponseBody Map<String, String> checkMobileExisted(HttpServletRequest request, HttpServletResponse response){
		String mobile = RequestUtil.getString(request, "mobile");
		UserCriteria criteria = new UserCriteria();
		criteria.setMobilePhone(mobile);
		User user = userService.getUser(criteria);
		
		Map<String, String> result = new HashMap<String, String>();
		if(user == null){
			result.put("success", "false");
			result.put("msg", "手机号不存在，可以注册");
		}else{
			result.put("success", "true");
			result.put("msg", "手机号已存在，不可以注册");
		}
		return result;
	}
	
	
	/////////////////////////////////////////下面的代码是管理后台用户相关/////////////////////////////////////////////////////////////
	
	
	//后台管理中用户详情页
	private static final String ADMIN_USER_DETAIL = "admin/user/detail.jsp";
	
	//用户列表页
	private static final String ADMIN_USER_LIST = "admin/user/list.jsp";
	
	//用户每页显示数量
	private static final Integer ADMIN_USER_LIST_PAGESIZE = 20;
	
	@RequestMapping("/admin/user/list")
	public ModelAndView getUserList(User user, HttpServletRequest request, HttpServletResponse response){
		
		Integer pageNum=RequestUtil.getInteger(request, "pageNum");
		UserCriteria criteria = new UserCriteria();
		SearchPagerModel<User> searchPagerModel = new SearchPagerModel<User>(null == pageNum ? 1 : pageNum, ADMIN_USER_LIST_PAGESIZE);
		
		criteria.setUserId(user.getUserId());
		criteria.setUsername(user.getUsername());
		criteria.setEmail(user.getEmail());
		criteria.setMobilePhone(user.getMobilePhone());
		criteria.setStatus(user.getStatus());
		criteria.setPageModel(searchPagerModel);
		SearchPagerModel<User> users = userService.getUsers(criteria);
		request.setAttribute("users", users);
		return new ModelAndView(ADMIN_USER_DETAIL);
		
	}
	
	//用户详情页面
	@RequestMapping("/admin/user/goEdit")
	public ModelAndView goEdit(HttpServletRequest request, HttpServletResponse response){
		
		String userId = RequestUtil.getString(request, "userId");
		if(StringUtils.isNotEmpty(userId)){
			User user = userService.getUser(userId);
			request.setAttribute("user", user);
		}
		return new ModelAndView(USER_DETAIL);
		
	}
	
	
	//修改用户状态,包括： 删除用户，屏蔽用户，恢复用户为正常状态
	@RequestMapping("/admin/user/modifyStatus")
	public ModelAndView modifyUserStatus(HttpServletRequest request, HttpServletResponse response){
		String userId = RequestUtil.getString(request, "userId");
		Integer status = RequestUtil.getInteger(request, "status");
		User to = new User();
		to.setUserId(userId);
		to.setStatus(status);
		userService.updateUser(to);
		return new ModelAndView(Constant.JSON_VIEW, Constant.JSON_ROOT, JsonUtil.getOkStatusMsg(null));
	}
	
}

