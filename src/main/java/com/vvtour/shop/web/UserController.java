package com.vvtour.shop.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.common.utils.PublicResult;
import com.usual.utils.Page;
import com.usual.web.BaseController;
import com.vvtour.shop.entity.ProductInfo;
import com.vvtour.shop.entity.User;
import com.vvtour.shop.service.UserService;

/**
 * 用户controller
 * @author fuqi
 * @date 2014-08-02 16:34
 */
@Controller
@RequestMapping("/admin")
public class UserController extends BaseController {
	
	private final static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	
	/**
	 * 修改用户状态,包括： 删除用户，屏蔽用户，恢复用户为正常状态
	 * */
	@RequestMapping(value="/modifyUserStatus",method=RequestMethod.GET)
	public ModelAndView modifyUserStatus(@RequestParam(value = "status", required = false) Integer status, HttpServletRequest request,@RequestParam(value = "userId", required = false) String userId,
			@RequestParam(value = "redirect_url", required = false) String redirect_url){
		ModelAndView mav = new ModelAndView();
		mav.setViewName(URL_REDIRECT+redirect_url);
		try{
			//检查是否存在该用户
			PublicResult<User> queryResult = userService.queryUser(userId);
			if(!queryResult.isSuccess()){
				mav.addObject(ERROR_MSG_KEY, "不存在该用户");
				return mav;
			}
			User to = new User();
			to.setUserId(userId);
			to.setStatus(status);
			//更新用户状态
			PublicResult<Boolean> result = userService.editUser(to);
			if(!result.isSuccess()){
				mav.addObject(ERROR_MSG_KEY, "更新发生错误,请联系技术人员");
				return mav;
			}
			mav.addObject(SUCCESS_MSG_KEY, "操作成功");

		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, "提交发生错误,请联系技术人员");
			return mav;
		}
		return mav;
	}
	
	
	
	/**
	 * 用户列表
	 * */
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public ModelAndView products(@RequestParam(value = "p", required = false) Integer pageNo){
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/user/list");
		try{
			pageNo = pageNo==null?1:pageNo;
			int start = (pageNo - 1) * PAGE_SIZE;
			int totalPage = 0;
			//浏览
			PublicResult<ProductInfo> result = userService.queryUserList(start, PAGE_SIZE);
			
			Page page = new Page(PAGE_SIZE,result.getCount(),pageNo);
            totalPage = page.getTotalPage();
            mav.addObject("currentPage",pageNo);
            mav.addObject("pageSize",PAGE_SIZE);
            mav.addObject("totalPage",totalPage);
            mav.addObject("totalCount",result.getCount());
            
            mav.addObject("proList",result.getModelList());
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, "提交发生错误,请联系技术人员");
			return mav;
		}
		return mav;
	}
	
	
	
}

