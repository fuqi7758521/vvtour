package com.usual.web;

import java.io.PrintWriter;







import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.common.utils.Constants;
import com.common.utils.PublicResult;
import com.usual.entity.Authority;
import com.usual.entity.ManageMenu;
import com.usual.service.MngMenuService;

@Controller
@RequestMapping("/admin")
public class ManageMenuController extends BaseController {

	private final static Logger logger = Logger.getLogger(ManageMenuController.class);
	
	@Autowired
	private MngMenuService menuMngService;
	
	@RequestMapping("/menu_list")
	public ModelAndView menuList(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/menu/menuList");
		return mav;
	}
	
	/**
	 * 检验该名词是否已经存在 AJAX
	 * */
	@RequestMapping(value="/checkMenuName",method = RequestMethod.GET)
	public void checkMenuName(@RequestParam("menu_name") String menu_name,PrintWriter printWriter){
		String msg = "null";
		try{
			if(StringUtils.isBlank(menu_name)){
				msg = "菜单名称不能为空";
			}
			PublicResult<Boolean> result = menuMngService.checkMenuNameExist(menu_name);
			if(result.isSuccess()){
				if(!result.getModel()){
					msg = Constants.AJAX_RESULT_SUCCESS+"可以添加";
				}else{
					msg = Constants.AJAX_RESULT_FAIL+"该名称已经存在";
				}
			}else{
				msg = Constants.AJAX_RESULT_ERROR+"系统错误，检查失败";
			}
			printWriter.write(msg);
		} catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			printWriter.write(Constants.AJAX_RESULT_ERROR+"系统错误");
		} finally{
			if(printWriter != null){
				printWriter.flush();
				printWriter.close();
			}
		}
		
	}
	
	/**
	 * 添加菜单名称 AJAX
	 * 
	 * */
	@RequestMapping(value="/addMenu",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody String addMenu(ManageMenu menuInfo){
		String msg = "null";
		try{
			/*if(StringUtils.isBlank(menuInfo.getMenu_name())||StringUtils.isBlank(menuInfo.getMenu_cnname())){
				msg = Constants.AJAX_RESULT_ERROR+"参数为空，添加失败！";
			}else{
				menuInfo.setAuth(new Authority());
				menuInfo.setComments("");
				PublicResult<String> result = menuMngService.addManageMenu(menuInfo);
				
				if(!result.isSuccess()){
					msg = Constants.AJAX_RESULT_ERROR+"系统异常，添加失败";
				} else {
					msg = Constants.AJAX_RESULT_SUCCESS+"添加成功";
				}
			}*/
			msg = Constants.AJAX_RESULT_SUCCESS+"添加成功";
			return msg;
		} catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			msg = Constants.AJAX_RESULT_ERROR+"系统错误";
			return msg;
		} 
	}
	
	
	
	/**
	 * 展示菜单列表
	 * */
	
	/**
	 * 修改菜单名称
	 * */
	
	/**
	 * 在具体的菜单里添加权限
	 * */
	
	/**
	 * 展示菜单里具体的权限
	 * */
	
	/**
	 * 修改具体菜单里的具体权限
	 * */
	
	
}
