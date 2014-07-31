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
import com.vvtour.shop.entity.TourPath;
import com.vvtour.shop.entity.VisitParent;
import com.vvtour.shop.service.TourPathService;
import com.vvtour.shop.service.VisitParentService;


@Controller
@RequestMapping("/admin")
public class TourPathController extends BaseController {

	private final static Logger logger = Logger.getLogger(TourPathController.class);
	
	@Autowired
	private TourPathService tourPathService;
	
	@Autowired
	private VisitParentService vparentService;

	/**
	 * 根据目的地获取所有路线列表
	 * */
	@RequestMapping(value="/tourPathList")
	public ModelAndView tourPathList(@RequestParam(value = "p", required = false) Integer pageNo
			,@RequestParam(value = "visit_id", required = false)String visit_id){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/doFail");
		try{
			/*if(StringUtils.isBlank(visit_id)){
				mav.setViewName("admin/doFail");
				mav.addObject(ERROR_MSG_KEY, "获取visit_id参数为空");
				return mav;
			}*/
			pageNo = pageNo==null?1:pageNo;
			int start = (pageNo - 1) * PAGE_SIZE;
			PublicResult<TourPath> listResult = tourPathService.queryTourPathList(visit_id, start, 0);
			if(!listResult.isSuccess()){
				mav.addObject(ERROR_MSG_KEY, "获取列表失败！");
				return mav;
			}
			List<VisitParent> vparentList = new ArrayList<VisitParent>();
			PublicResult<VisitParent> vparentResult = vparentService.queryVisitParentList(0,0);
			if(vparentResult.isSuccess()){
				vparentList = vparentResult.getModelList();
			}
			
			mav.addObject("vparentList", vparentList);
			mav.addObject("pathList", listResult.getModelList());
			if(listResult.getModelList()!=null)mav.addObject("pathCount", listResult.getModelList().size());
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		mav.setViewName("admin/pro_tag/tourPathList");
		return mav;
	}
	
	/**
	 * 根据目的地获取所有路线
	 * */
	@RequestMapping(value="/catchTourPathList",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, Object> catchTourPathList(String ca_id){
		try{
			Map<String, Object> modelMap = new HashMap<String, Object>(3);
			if(StringUtils.isBlank(ca_id)){
				//msg = Constants.AJAX_RESULT_ERROR+"提交参数为空,请联系技术人员";
				modelMap.put("msg", Constants.AJAX_RESULT_ERROR+"提交参数为空,请联系技术人员");
				modelMap.put("data",null);
				modelMap.put("success","false");
				return modelMap;
			}
			
			//浏览
			PublicResult<TourPath> result = tourPathService.queryTourPathList(ca_id, 0, -1);
			
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
			List<TourPath> list = new ArrayList<TourPath>();
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
	 * 添加一级菜单 vparent_name 添加单个
	 * 
	 * */
	@RequestMapping(value="/addTourPath",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody String addTourPath(String path_name,String ca_id,String ca_name){
		String msg = "null";
		try{
			if(StringUtils.isBlank(path_name)){
				msg = Constants.AJAX_RESULT_ERROR+"参数为空";
				return msg;
			}
			//数组封装为List表
			Map<String,List<String>> mp = checkPathNameRepeat(ca_id,path_name);
			
			List<String> nameList = mp.get("allList");
			List<String> existList = mp.get("existList");
			if(existList.size()!=0&&nameList.size()==0){
				msg = Constants.AJAX_RESULT_FAIL+"您所输入的名称都已存在";
				return msg;
			}
			PublicResult<TourPath> encaResult = tourPathService.encaTourPathList(ca_id, ca_name, nameList);
			if(!encaResult.isSuccess()||encaResult.getModelList()==null){
				msg = Constants.AJAX_RESULT_ERROR+"系统错误，检查失败";
				return msg;
			}
			
			List<TourPath> list = new ArrayList<TourPath>();
			list = encaResult.getModelList();
			tourPathService.addTourPath(list);
			
			msg = Constants.AJAX_RESULT_SUCCESS+"添加成功" + list.size() + "个";
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
	 * 检查去重TourPath
	 * 
	 * */
	public Map<String,List<String>> checkPathNameRepeat(String visit_id,String path_name){
		try{
			List<String> allList = new ArrayList<String>();
			List<String> existList = new ArrayList<String>();
			allList = EncapsulateUtil.encaList(path_name);
			Iterator<String> iter = allList.iterator();
			while(iter.hasNext()){
				String temp = iter.next();
				PublicResult<TourPath> result = tourPathService.queryTourPathExists(visit_id, temp);
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
	
	/**
	 * 删除路线 path_id
	 * 
	 * */
	@RequestMapping(value="/delTourPath")
	public ModelAndView delTourPath(
			@RequestParam(value = "path_id", required = false) String path_id,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		try{
			PublicResult<TourPath> queryResult = tourPathService.queryTourPath(path_id, null);
			if(queryResult.isSuccess()){
				
				if(queryResult.getModel()==null){
					mav.addObject(ERROR_MSG_KEY, "不存在该路线");
					mav.setViewName("admin/doFail");
					return mav;
				}
				PublicResult<Boolean> result = tourPathService.deletelTourPath(path_id);
				
				if(!result.isSuccess()){
					mav.addObject(ERROR_MSG_KEY, "删除失败，请联系技术人员");
				}
			}
			
			mav.setViewName(URL_REDIRECT + "/admin/tourPathList.htm");
			return mav;
		}catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			
			mav.addObject(ERROR_MSG_KEY, ex.getMessage());
			
			mav.setViewName("admin/doFail");
			return mav;
		}

	}
	
	/**
	 * 编辑路线 path_id,path_name
	 * 
	 * */
	@RequestMapping(value="/editTourPath",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody String editTourPath(String visit_id,String path_id,String path_name){
		String msg = "null";
		try{
			if(StringUtils.isBlank(path_id)&&StringUtils.isBlank(visit_id)&&StringUtils.isBlank(path_name)){
				msg = Constants.AJAX_RESULT_ERROR+"参数为空";
				return msg;
			}
			
			PublicResult<TourPath> queryResult = tourPathService.queryTourPathExists(visit_id, path_name);
			if(queryResult.isSuccess()){
				
				if(queryResult.getModel()!=null){
					msg = Constants.AJAX_RESULT_ERROR+"该路线名已经存在，请重新修改";
					return msg;
				}
				PublicResult<Boolean> result = tourPathService.updateTourPathName(path_id, path_name);
				
				if(!result.isSuccess()){
					msg = Constants.AJAX_RESULT_ERROR+"系统错误，修改失败";
					return msg;
				}
			}
			
			msg = Constants.AJAX_RESULT_SUCCESS+"修改成功";
			return msg;
		}catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			msg = Constants.AJAX_RESULT_ERROR+"系统错误";
			return msg;
		}

	}
	
}
