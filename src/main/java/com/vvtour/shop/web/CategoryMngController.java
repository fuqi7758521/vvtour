package com.vvtour.shop.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.usual.utils.EncapsulateUtil;
import com.usual.web.BaseController;
import com.vvtour.shop.entity.CategoryInfo;
import com.vvtour.shop.entity.ProductInfo;
import com.vvtour.shop.service.CategoryService;

@Controller
@RequestMapping("/admin")
public class CategoryMngController extends BaseController {

	private final static Logger logger = Logger.getLogger(CategoryMngController.class);
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 列表菜单
	 * 
	 * */
	@RequestMapping(value="/categoryList")
	public ModelAndView vparentList(@RequestParam(value = "p", required = false) Integer pageNo,
			@RequestParam(value = "pid", required = false) String parent_id
			,@RequestParam(value = "t", required = false) String ca_type){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/category/categoryList");
		try{
			pageNo = pageNo==null?1:pageNo;
			int start = (pageNo - 1) * PAGE_SIZE;
			List<CategoryInfo> list = new ArrayList<CategoryInfo>();
			
			if(StringUtils.isBlank(parent_id)){
				parent_id = "0";
			}
			PublicResult<CategoryInfo> result = categoryService.queryCategoryInfoList(ca_type,parent_id, start, PAGE_SIZE);
			
			PublicResult<CategoryInfo> selectResult = categoryService.queryCategoryInfoList(ca_type,"0", start, -1);
			
			if(result.isSuccess()){
				list = result.getModelList();
			}
			
			mav.addObject("categoryList", list);
			mav.addObject("selectList", selectResult.getModelList());
			if(list!=null)mav.addObject("categoryCount", list.size());
			else mav.addObject("categoryCount", 0);
			return mav;
		}catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, ex.getMessage());
			return mav;
		}

	}
	
	/**
	 * 添加分类  categories
	 * 
	 * */
	@RequestMapping(value="/addCategory",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody String addCategory(String ca_type,String parent_id,String ca_name){
		String msg = "null";
		try{
			if(StringUtils.isBlank(ca_name)||StringUtils.isBlank(parent_id)||StringUtils.isBlank(ca_type)){
				msg = Constants.AJAX_RESULT_ERROR+"参数为空";
				return msg;
			}
			Map<String,List<String>> mp = checkVisitTagRepeat(parent_id,ca_name);

			List<String> allList = mp.get("allList");
			List<String> existList = mp.get("existList");
			if(existList.size()!=0&&allList.size()==0){
				msg = Constants.AJAX_RESULT_FAIL+"您所输入的名称都已存在";
				return msg;
			}
			
			PublicResult<CategoryInfo> encaResult = categoryService.encaCategoryInfoList(ca_type,parent_id, allList);
			if(!encaResult.isSuccess()&&encaResult.getModelList()==null||encaResult.getModelList().size()<1){
				msg = Constants.AJAX_RESULT_FAIL+"系统错误，封装ID时失败";
				return msg;
			}
			
			PublicResult<Boolean> addResult = categoryService.addCategoryInfo(encaResult.getModelList());
			if(!addResult.isSuccess()){
				msg = Constants.AJAX_RESULT_FAIL+"系统错误，批量保存时失败";
				return msg;
			}
			
			msg = Constants.AJAX_RESULT_SUCCESS+"添加成功" + encaResult.getModelList().size() + "个";
			if(existList.size()>0){
				msg += ",您输入的以下名称已经存在：" + EncapsulateUtil.listToString(existList); 
			}
			return msg;
		} catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			msg = Constants.AJAX_RESULT_ERROR+"系统错误";
			return msg;
		} 
	}
	
	
	/**
	 * 检查去重Category
	 * 
	 * */
	public Map<String,List<String>> checkVisitTagRepeat(String parent_id,String categories){
		try{
			List<String> allList = new ArrayList<String>();
			List<String> existList = new ArrayList<String>();
			allList = EncapsulateUtil.encaList(categories);
			Iterator<String> iter = allList.iterator();
			while(iter.hasNext()){
				String temp = iter.next();
				PublicResult<CategoryInfo> result = categoryService.queryCategoryInfoExists(parent_id, temp);
				if(result.isSuccess()){
					if(result.getModel()!=null){		//该目的地已经存在
						iter.remove();
						existList.add(temp);
					}
				}else{
					logger.error("检查目的地标签visit_name是否存在时出现错误！");
					continue;
				}
			}
			Map<String,List<String>> mp = new HashMap<String,List<String>>();
			mp.put("allList", allList);
			mp.put("existList", existList);
			return mp;
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage(), ex);
			return null;
		}
	}
	
	
	@RequestMapping(value="/catchCategoryList",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, Object> catchTourPathList(String ca_type,String pid){
		try{
			Map<String, Object> modelMap = new HashMap<String, Object>(3);
			if(StringUtils.isBlank(ca_type) || StringUtils.isBlank(pid)){
				//msg = Constants.AJAX_RESULT_ERROR+"提交参数为空,请联系技术人员";
				modelMap.put("msg", Constants.AJAX_RESULT_ERROR+"提交参数为空,请联系技术人员");
				modelMap.put("data",null);
				modelMap.put("success","false");
				return modelMap;
			}
			
			//浏览
			PublicResult<CategoryInfo> result = categoryService.queryCategoryInfoList(ca_type, pid, 0, -1);
			
			if(!result.isSuccess()){
				//msg = Constants.AJAX_RESULT_ERROR+"获取分类失败,请联系技术人员";
				modelMap.put("msg", Constants.AJAX_RESULT_ERROR+"获取分类失败,请联系技术人员");
				modelMap.put("data",null);
				modelMap.put("success","false");
				return modelMap;
			}
			if(result.getModelList() == null){
				//msg = Constants.AJAX_RESULT_ERROR+"获取分类失败,请联系技术人员";
				modelMap.put("msg", Constants.AJAX_RESULT_ERROR+"获取分类失败,请联系技术人员");
				modelMap.put("data",null);
				modelMap.put("success","false");
				return modelMap;
			}
			List<CategoryInfo> list = new ArrayList<CategoryInfo>();
			list = result.getModelList();
			modelMap.put("msg", "获取成功");
			modelMap.put("data",list);
			modelMap.put("success","true");
			return modelMap; 
		} catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			//msg = Constants.AJAX_RESULT_ERROR+"获取分类失败,请联系技术人员";
			return null;
		} 
	}
	
	/**
	 * 删除分类
	 * 
	 * */
	@RequestMapping(value="/delCategory")
	public ModelAndView delVisitTag(@RequestParam(value = "pid", required = false) String parent_id
			,@RequestParam(value = "ca_id", required = false) String ca_id){
		ModelAndView mav = new ModelAndView();
		if(StringUtils.isBlank(parent_id)){
			mav.setViewName(URL_REDIRECT + "categoryList.htm");
		}else{
			mav.setViewName(URL_REDIRECT + "categoryList.htm?pid="+parent_id);
		}
		
		try{
			if(StringUtils.isBlank(ca_id))
			{
				mav.addObject(ERROR_MSG_KEY, "参数为空");
				mav.setViewName("admin/doFail");
				return mav;
			}
			
			PublicResult<Boolean> result = categoryService.deletelCategoryInfo(ca_id);
			if(!result.isSuccess()){
				mav.setViewName("admin/doFail");
				mav.addObject(ERROR_MSG_KEY, "删除失败");
				return mav;
			}
			
			return mav;
		}catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, ex.getMessage());
			return mav;
		}

	}
}
