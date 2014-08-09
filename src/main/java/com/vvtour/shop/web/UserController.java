package com.vvtour.shop.web;

import java.util.Date;
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
import com.vvtour.shop.entity.Email;
import com.vvtour.shop.entity.User;
import com.vvtour.shop.utils.AcsUtil;
import com.vvtour.shop.utils.EmailUtil;
import com.vvtour.shop.utils.MessageDigestUtil;
import com.vvtour.shop.utils.PasswordGeneratorUtil;
import com.vvtour.shop.utils.PropUtil;
import com.vvtour.shop.utils.RequestUtil;
import com.vvtour.shop.service.UserService;
import com.vvtour.shop.Constant;

/**
 * 用户controller
 * @author fuqi
 * @date 2014-08-02 16:34
 */
@Controller
public class UserController extends BaseController implements Constant{
	
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
	
	//修改密码结果
	private static final String USER_CHANGE_PASSWORD_RESULT = "front/user/changePasswordResult";
	
	//用户信息详情
	private static final String USER_DETAIL = "front/user/userDetail";
	
	//邮箱验证页面
	private static final String USER_VERIFY_EMAIL = "";
	
	//找回密码页面
	private static final String USER_FIND_PASSWORD = "front/user/findPassword";
	
	//邮箱找回密码页面
	private static final String USER_FIND_PASSWORD_BY_EMAIL = "front/user/findPasswordByEmail";
	
	//邮箱找回密码结果
	private static final String USER_FIND_PASSWORD_BY_EMAIL_RESULT = "front/user/findPasswordByEmailResult";
	
	//手机号找回密码页面
	private static final String USER_FIND_PASSWORD_BY_MOBILE_PHONE = "";
	
	@Autowired
	private UserService userService;
	
	//进入邮箱注册页面
	@RequestMapping("/user/goSignUpByEmail.htm")
	public ModelAndView goSignUpByEmail(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView(USER_SIGN_UP_BY_EMAIL);
	}
	
	//进入手机注册页面
	@RequestMapping("/user/goSignUpByPhone.htm")
	public ModelAndView goSignUpByPhone(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView(USER_SIGN_UP_BY_PHONE);
	}
	
	//注册
	@RequestMapping("/user/signUp.htm")
	public ModelAndView signUp(User user, HttpServletRequest request, HttpServletResponse response){
		if(StringUtils.isEmpty(user.getUsername())){
			return new ModelAndView("forword:/user/goSignUpByEmail.htm");
		}
		user.setPassword(MessageDigestUtil.getMD5(user.getPassword() + Constant.PASSWORD_SALT_KEY));
		user.setStatus(USER_STATUS_NORMAL);
		user.setSignUpDate(new Date());
		userService.addUser(user);
		AcsUtil.addLoginUserToSession(request, user);
		updateSignInTime(user.getUserId());
		Map<String, String> result = new HashMap<String, String>();
		if(StringUtils.isNotEmpty(user.getEmail())){
			result.put("email", user.getEmail());
			sendVerifyEmailByThread(user);
			return new ModelAndView(USER_SIGN_UP_BY_EMAIL_SUCCESS,result);
		}
		if(StringUtils.isNotEmpty(user.getMobile())){
			result.put("mobile", user.getMobile());
			return new ModelAndView(USER_SIGN_UP_BY_MOBILE_SUCCESS,result);
		}
		return null;
		
	}
	
	//进入登录页面
	@RequestMapping("/user/goSignIn.htm")
	public ModelAndView goSignIn(HttpServletRequest request, HttpServletResponse response){
		User loginUser = AcsUtil.getLoginUser(request);
		if(loginUser != null){
			return new ModelAndView(USER_INFO_CENTER);
		}
		return new ModelAndView("redirect:/user/goUserInfoCenter.htm");
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
		if(user != null && user.getStatus().equals(USER_STATUS_NORMAL)){
			AcsUtil.addLoginUserToSession(request, user);
			updateSignInTime(user.getUserId());
			return new ModelAndView("redirect:/user/goUserInfoCenter.htm");
		}
		
		criteria = new UserCriteria();
		criteria.setEmail(identity);
		criteria.setPassword(password);
		user = userService.getUser(criteria);
		if(user != null && user.getStatus().equals(USER_STATUS_NORMAL)){
			AcsUtil.addLoginUserToSession(request, user);
			updateSignInTime(user.getUserId());
			return new ModelAndView("redirect:/user/goUserInfoCenter.htm");
		}
		
		criteria = new UserCriteria();
		criteria.setMobile(identity);
		criteria.setPassword(password);
		user = userService.getUser(criteria);
		if(user != null && user.getStatus().equals(USER_STATUS_NORMAL)){
			AcsUtil.addLoginUserToSession(request, user);
			updateSignInTime(user.getUserId());
			return new ModelAndView("redirect:/user/goUserInfoCenter.htm");
		}
		return new ModelAndView("redirect:/user/goSignIn.htm");
		
	}
	//更新最新登录时间
	private void updateSignInTime(String userId){
		User userTmp = new User();
		userTmp.setUserId(userId);
		userTmp.setLastLoginDate(new Date());
		userService.updateUser(userTmp);
	}
	
	//退出
	@RequestMapping("/user/signOut.htm")
	public ModelAndView signOut(HttpServletRequest request, HttpServletResponse response){
		AcsUtil.removeLoginUserFromSession(request);
		return new ModelAndView("redirect:/user/goSignIn.htm");
	}
	
	//用户信息中心
	@RequestMapping("/user/goUserInfoCenter.htm")
	public ModelAndView goUserInfoCenter(HttpServletRequest request, HttpServletResponse response){
		User loginUser = AcsUtil.getLoginUser(request);
		if(loginUser == null){
			return new ModelAndView(USER_SIGN_IN);
		}
		return new ModelAndView(USER_INFO_CENTER);
		
	}
	
	//进入密码修改页面
	@RequestMapping("/user/goChangePassword.htm")
	public ModelAndView goChangePassword(HttpServletRequest request, HttpServletResponse response){
		User loginUser = AcsUtil.getLoginUser(request);
		if(loginUser == null){
			return new ModelAndView(USER_SIGN_IN);
		}
		return new ModelAndView(USER_CHANGE_PASSWORD);
	}
	
	//修改密码 
	@RequestMapping("/uer/changePassword.htm")
	public ModelAndView chagePassword(HttpServletRequest request, HttpServletResponse response){
		User loginUser = AcsUtil.getLoginUser(request);
		if(loginUser == null){
			return new ModelAndView(USER_SIGN_IN);
		}
		String orgPassword = RequestUtil.getString(request, "orgPassword");
		String newPassword = RequestUtil.getString(request, "password");
		Map<String, String> result = new HashMap<String, String>();
		if(!loginUser.getPassword().equals(MessageDigestUtil.getMD5(orgPassword + Constant.PASSWORD_SALT_KEY))){
			String msg = "您的密码与原密码不符！";
			result.put("msg", msg);
			return new ModelAndView(USER_CHANGE_PASSWORD_RESULT,result);
		}
		User to = new User();
		to.setUserId(loginUser.getUserId());
		to.setPassword(MessageDigestUtil.getMD5(newPassword + Constant.PASSWORD_SALT_KEY));
		userService.updateUser(to);
		String msg = "恭喜！登录密码修改成功！";
		result.put("msg", msg);
		return new ModelAndView(USER_CHANGE_PASSWORD_RESULT,result);
	}
	
	//用户个人信息详情
	@RequestMapping("/user/goUserDetail.htm")
	public ModelAndView goUserDetail(HttpServletRequest request, HttpServletResponse response){
		User loginUser = AcsUtil.getLoginUser(request);
		if(loginUser == null){
			return new ModelAndView(USER_SIGN_IN);
		}
		return new ModelAndView(USER_DETAIL);
	}
	
	//更新个人信息
	@RequestMapping("/user/updateUserInfo.htm")
	public ModelAndView updateUserInfo(User user, HttpServletRequest request, HttpServletResponse response){
		User loginUser = AcsUtil.getLoginUser(request);
		if(loginUser == null){
			return new ModelAndView(USER_SIGN_IN);
		}
		user.setUserId(loginUser.getUserId());
		userService.updateUser(user);
		AcsUtil.reAddLoginUserToSession(request,loginUser.getUserId(),userService);
		return new ModelAndView("redirect:/user/goUserDetail.htm");
	}
	
	//更新个人邮箱
	@RequestMapping( value = "/user/updateUserEmail.htm", produces = {"application/json;charset=UTF-8"})
	public @ResponseBody Map<String, String> updateUserEmail(HttpServletRequest request, HttpServletResponse response){
		User loginUser = AcsUtil.getLoginUser(request);
		Map<String, String> result = new HashMap<String, String>();
		if(loginUser == null){
			result.put("msg", "登录已超时，请重新登录");
			return result;
		}
		User user = new User();
		user.setUserId(loginUser.getUserId());
		String email = RequestUtil.getString(request, "email");
		//查询修改的email,是否被其他用户占用
		UserCriteria criteria = new UserCriteria();
		criteria.setEmail(email);
		User userTmp = userService.getUser(criteria);
		if(userTmp != null && !userTmp.getUserId().equals(loginUser.getUserId())){
			
			result.put("msg", "该邮箱已被占用，请选择其他邮箱");
			return result;
		}
		user.setEmail(email);
		user.setValidateEmail(Constant.EMAIL_UNCHECKED);
		userService.updateUser(user);
		result.put("msg", "修改成功");
		AcsUtil.reAddLoginUserToSession(request,loginUser.getUserId(),userService);
		return result;
	}
	
	//解除注册邮箱绑定
	@RequestMapping( value = "/user/removeEmailBind.htm", produces = {"application/json;charset=UTF-8"})
	public @ResponseBody Map<String, String> removeEmailBind(HttpServletRequest request, HttpServletResponse response){
		User loginUser = AcsUtil.getLoginUser(request);
		Map<String, String> result = new HashMap<String, String>();
		if(loginUser == null){
			result.put("msg", "登录已超时，请重新登录");
			return result;
		}
		User user = new User();
		user.setUserId(loginUser.getUserId());
		user.setValidateEmail(Constant.EMAIL_UNCHECKED);
		userService.updateUser(user);
		result.put("msg", "解除绑定");
		AcsUtil.reAddLoginUserToSession(request,loginUser.getUserId(),userService);
		return result;
	}
	
	//发送验证邮箱邮件
	@RequestMapping(value = "/user/sendVerifyEmail.htm" , produces = {"application/json;charset=UTF-8"})
	public @ResponseBody Map<String, String> verifyEmail(HttpServletRequest request, HttpServletResponse response){
		final User loginUser = AcsUtil.getLoginUser(request);
		Map<String, String> result = new HashMap<String, String>();
		if(loginUser == null){
			result.put("msg", "登录已超时，请重新登录");
			return result;
		}
		
		sendVerifyEmailByThread(loginUser);
		
		result.put("msg", "请登录您的邮箱，点击验证链接进行验证！");
		return result;
	}

	private void sendVerifyEmailByThread(final User loginUser) {
		class SendVerifyEmailThread extends Thread{

			@Override
			public void run() {
				Email email = new Email();
				email.setTitle("诚途旅游网----验证邮箱");
				email.setContent("请点击该链接地址，进行邮箱验证： " + PropUtil.get("domain") + "/user/verifyEmail.htm?userId=" + loginUser.getUserId() + "&email=" +
				loginUser.getEmail());
				email.setTo(loginUser.getEmail());
				email.setFrom(PropUtil.get("email.send.from"));
				try {
					EmailUtil.sendEmail(email);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		Thread emailThread = new SendVerifyEmailThread();
		emailThread.start();
	}
	
	//验证邮箱
	@RequestMapping("/user/verifyEmail.htm")
	public ModelAndView verifyEmail(HttpServletRequest request){
		String userId = RequestUtil.getString(request, "userId");
		String email = RequestUtil.getString(request, "email");
		User to = new User();
		to.setEmail(email);
		to.setUserId(userId);
		to.setValidateEmail(Constant.EMAIL_CHECKED);
		userService.updateUser(to);
		AcsUtil.reAddLoginUserToSession(request, userId, userService);
		return new ModelAndView("redirect:/user/goUserDetail.htm");
	}
	
	//邮箱解除绑定
	@RequestMapping("/user/removeEmailBind.htm")
	public @ResponseBody Map<String, String> removeEmailBind(HttpServletRequest request){
		 User loginUser = AcsUtil.getLoginUser(request);
		Map<String, String> result = new HashMap<String, String>();
		if(loginUser == null){
			result.put("msg", "登录已超时，请重新登录");
			return result;
		}
		User to = new User();
		to.setUserId(loginUser.getUserId());
		to.setValidateEmail(Constant.EMAIL_UNCHECKED);
		userService.updateUser(to);
		AcsUtil.reAddLoginUserToSession(request, loginUser.getUserId(), userService);
		result.put("msg", "邮箱已经解除绑定");
		return result;
	}
	
	//找回密码
	@RequestMapping("/user/goFindPassword.htm")
	public ModelAndView goFindPassword(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView(USER_FIND_PASSWORD);
	}
	
	//进入通过邮箱找回密码页面
	@RequestMapping("/user/goFindPasswordByEmail.htm")
	public ModelAndView goFindPasswordByEmail(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView(USER_FIND_PASSWORD_BY_EMAIL);
	}
	
	//发送邮件，在邮件里面有新的密码
	@RequestMapping("/user/findPasswordByEmail.htm")
	public ModelAndView findPasswordByEmail(HttpServletRequest request, HttpServletResponse response){
		Map<String, String> result = new HashMap<String, String>();
		String email = RequestUtil.getString(request, "email");
		UserCriteria criteria = new UserCriteria();
		criteria.setEmail(email);
		User user = userService.getUser(criteria);
		if(user == null ){
			result.put("msg", "该邮箱不存在，请填写正确的邮箱！");
			return new ModelAndView(USER_FIND_PASSWORD_BY_EMAIL_RESULT, result);
		}
		if(user != null && Constant.EMAIL_UNCHECKED.equals(user.getValidateEmail())){
			//邮箱没有验证，不能找回密码
			result.put("msg", "邮箱没有验证，不能找回密码");
			return new ModelAndView(USER_FIND_PASSWORD_BY_EMAIL_RESULT, result);
		}
		Email mail = new Email();
		mail.setTo(email);
		mail.setFrom(PropUtil.get("email.send.from"));
		mail.setTitle("您的诚途帐号密码找回");
		String newPwd = PasswordGeneratorUtil.getRandomPassword();
		mail.setContent("您的诚途帐号新密码为：" + newPwd + ", 请及时修改成你自己熟悉的密码！");
		
		//更新密码
		String md5Pwd = MessageDigestUtil.getMD5(newPwd + Constant.PASSWORD_SALT_KEY);
		User userTmp = new User();
		userTmp.setUserId(user.getUserId());
		userTmp.setPassword(md5Pwd);
		userService.updateUser(userTmp);
		try {
			//发送新密码邮件
			EmailUtil.sendEmail(mail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.put("msg", "密码已经发往你的邮箱，请查收！");
		return new ModelAndView(USER_FIND_PASSWORD_BY_EMAIL_RESULT,result);
	}
	
	//进入通过手机找回密码页面
	@RequestMapping("/user/goFindPasswordByPhone.htm")
	public ModelAndView goFindPasswordByPone(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView(USER_FIND_PASSWORD_BY_MOBILE_PHONE);
	}
	
	//通过手机找回密码页面
	@RequestMapping("/user/findPasswordByPhone.htm")
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
		criteria.setMobile(mobile);
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
	private static final String ADMIN_USER_DETAIL = "admin/user/detail";
	
	//用户列表页
	private static final String ADMIN_USER_LIST = "admin/user/list";
	
	//用户每页显示数量
	private static final Integer ADMIN_USER_LIST_PAGESIZE = 5;
	
	@RequestMapping("/admin/user/list.htm")
	public ModelAndView getUserList(UserCriteria criteria, HttpServletRequest request, HttpServletResponse response){
		if(criteria.getStatus() == null){
			criteria.setStatus(USER_STATUS_NORMAL);
		}
		Integer pageNum=RequestUtil.getInteger(request, "pageNum");
		if(pageNum == null){
			pageNum = 1;
			request.setAttribute("pageNum", pageNum);
		}
		SearchPagerModel<User> searchPagerModel = new SearchPagerModel<User>((pageNum-1)*ADMIN_USER_LIST_PAGESIZE, ADMIN_USER_LIST_PAGESIZE);
		criteria.setPageModel(searchPagerModel);
		SearchPagerModel<User> users = userService.getUsers(criteria);
		
		long totalItems = searchPagerModel.getTotal();
		long pageItems = 0;
		if(totalItems % ADMIN_USER_LIST_PAGESIZE != 0){
			pageItems = totalItems / ADMIN_USER_LIST_PAGESIZE + 1;
		}else{
			pageItems = totalItems / ADMIN_USER_LIST_PAGESIZE;
		}
		request.setAttribute("pageItems", pageItems);
		
		request.setAttribute("users", users);
		return new ModelAndView(ADMIN_USER_LIST);
		
	}
	
	//用户详情页面
	@RequestMapping("/admin/user/goEdit.htm")
	public ModelAndView goEdit(HttpServletRequest request, HttpServletResponse response){
		
		String userId = RequestUtil.getString(request, "userId");
		if(StringUtils.isNotEmpty(userId)){
			User user = userService.getUser(userId);
			request.setAttribute("user", user);
		}
		return new ModelAndView(ADMIN_USER_DETAIL);
		
	}
	
	
	//修改用户状态,包括： 删除用户，屏蔽用户，恢复用户为正常状态
	@RequestMapping("/admin/user/modifyStatus.htm")
	public @ResponseBody Map<String, String> modifyUserStatus(HttpServletRequest request, HttpServletResponse response){
		Map<String, String> result = new HashMap<String, String>();
		String userId = RequestUtil.getString(request, "userId");
		Integer status = RequestUtil.getInteger(request, "status");
		User to = new User();
		to.setUserId(userId);
		to.setStatus(status);
		userService.updateUser(to);
		result.put("msg", "操作成功");
		return result;
	}
	
}



