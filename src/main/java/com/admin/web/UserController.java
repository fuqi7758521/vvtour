package com.admin.web;

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
@RequestMapping("/admin")
public class UserController extends BaseController {
	
	private final static Logger logger = Logger.getLogger(UserController.class);

	//用户详情页
	private static final String USER_DETAIL = "admin/user/detail.jsp";
	
	//用户列表页
	private static final String USER_LIST = "admin/user/list.jsp";
	
	//用户每页显示数量
	private static final Integer USER_LIST_PAGESIZE = 20;
	
	@Autowired
	private UserService userService;
	
	//用户列表页
	@RequestMapping("/admin/user/list")
	public ModelAndView getUserList(User user, HttpServletRequest request, HttpServletResponse response){
		
		Integer pageNum=RequestUtil.getInteger(request, "pageNum");
		UserCriteria criteria = new UserCriteria();
		SearchPagerModel<User> searchPagerModel = new SearchPagerModel<User>(null == pageNum ? 1 : pageNum, USER_LIST_PAGESIZE);
		
		criteria.setUserId(user.getUserId());
		criteria.setUsername(user.getUsername());
		criteria.setEmail(user.getEmail());
		criteria.setMobilePhone(user.getMobilePhone());
		criteria.setStatus(user.getStatus());
		criteria.setPageModel(searchPagerModel);
		SearchPagerModel<User> users = userService.getUsers(criteria);
		request.setAttribute("users", users);
		return new ModelAndView(USER_LIST);
		
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
		userService.addUpdateUser(to);
		return new ModelAndView(Constant.JSON_VIEW, Constant.JSON_ROOT, JsonUtil.getOkStatusMsg(null));
	}
		
}

