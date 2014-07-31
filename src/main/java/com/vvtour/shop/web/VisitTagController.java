package com.vvtour.shop.web;

import java.io.PrintWriter;
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
import com.vvtour.shop.entity.VisitParent;
import com.vvtour.shop.entity.VisitTag;
import com.vvtour.shop.service.VisitParentService;

@Controller
@RequestMapping("/admin")
public class VisitTagController extends BaseController {
	
	private final static Logger logger = Logger.getLogger(VisitTagController.class);
	
	@Autowired
	private VisitParentService vparentService;
	
	/**
	 * 列表一级菜单
	 * 
	 * */
	@RequestMapping(value="/vparentList")
	public ModelAndView vparentList(@RequestParam(value = "p", required = false) Integer pageNo){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/pro_tag/visitParentList");
		try{
			pageNo = pageNo==null?1:pageNo;
			int start = (pageNo - 1) * PAGE_SIZE;
			List<VisitParent> list = new ArrayList<VisitParent>();
			PublicResult<VisitParent> result = vparentService.queryVisitParentList(start, PAGE_SIZE);
			
			if(result.isSuccess()){
				list = result.getModelList();
			}
			
			mav.addObject("vparentList", list);
			if(list!=null)mav.addObject("vparentCount", list.size());
			else mav.addObject("vparentCount", 0);
			return mav;
		}catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, ex.getMessage());
			return mav;
		}

	}
	
	/**
	 * 列表二级目的地
	 * 
	 * */
	@RequestMapping(value="/visitTagList")
	public ModelAndView visitTagList(@RequestParam(value = "p", required = false) Integer pageNo
			,@RequestParam(value = "vparent_id", required = false) String vparent_id){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/pro_tag/visitTagList");
		try{
			if(StringUtils.isBlank(vparent_id))
			{
				mav.addObject(ERROR_MSG_KEY, "参数为空");
				mav.setViewName("admin/doFail");
				return mav;
			}
			pageNo = pageNo==null?1:pageNo;
			int start = (pageNo - 1) * PAGE_SIZE;
			List<VisitTag> list = new ArrayList<VisitTag>();
			PublicResult<VisitParent> result = vparentService.queryVisitParentByVParentId(vparent_id);
			VisitParent vparent = new VisitParent();
			if(result.isSuccess()){
				
				vparent = result.getModel();
				list = vparent.getVisit_tag();
			}
			
			mav.addObject("tagList", list);
			mav.addObject("vparent_id", vparent_id);
			mav.addObject("vparent_name", vparent.getVparent_name());
			if(list!=null)mav.addObject("vparentCount", list.size());
			else mav.addObject("vparentCount", 0);
			
			return mav;
		}catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, ex.getMessage());
			return mav;
		}

	}

	/**
	 * 添加一级菜单 vparent_name 添加单个
	 * 
	 * */
	@RequestMapping(value="/addVParentTag",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody String addVParentTag(String vparent_name,String vparent_type){
		String msg = "null";
		try{
			if(StringUtils.isBlank(vparent_name)){
				msg = Constants.AJAX_RESULT_ERROR+"参数为空";
				return msg;
			}
			//数组封装为List表
			Map<String,List<String>> mp = checkVisitParentRepeat(vparent_name);
			//封装为对象列表
			List<String> allList = mp.get("allList");
			List<String> existList = mp.get("existList");
			if(existList.size()!=0&&allList.size()==0){
				msg = Constants.AJAX_RESULT_FAIL+"您所输入的名称都已存在";
				return msg;
			}
			PublicResult<VisitParent> encaResult = vparentService.encaVisitParentList(allList, vparent_type);
			if(!encaResult.isSuccess()&&encaResult.getModelList()==null||encaResult.getModelList().size()<1){
				msg = Constants.AJAX_RESULT_FAIL+"系统错误，封装ID时失败";
				return msg;
			}
			//批量插入
			PublicResult<Boolean> result = vparentService.addVisitParentBatch(encaResult.getModelList());
			if(!result.isSuccess()){
				msg = Constants.AJAX_RESULT_FAIL+"系统错误，批量保存时失败";
				return msg;
			}
			msg = Constants.AJAX_RESULT_SUCCESS+"添加成功" + allList.size() + "个";
			
			return msg;
		} catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			msg = Constants.AJAX_RESULT_ERROR+"系统错误";
			return msg;
		} 
	}
	
	/**
	 * 添加目的地标签  visit_name
	 * 
	 * */
	@RequestMapping(value="/addVisitTag",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody String addVisitTag(String vparent_id,String visit_name){
		String msg = "null";
		try{
			if(StringUtils.isBlank(visit_name)&&StringUtils.isBlank(vparent_id)){
				msg = Constants.AJAX_RESULT_ERROR+"参数为空";
				return msg;
			}
			Map<String,List<String>> mp = checkVisitTagRepeat(vparent_id,visit_name);
			/*PublicResult<VisitParent> result = vparentService.queryVisitTagByVisitName(vparent_id,visit_name);
			if(result.isSuccess()){
				if(result.getModel()!=null){
					msg = Constants.AJAX_RESULT_FAIL+"该名称已经存在";
					return msg;
				}
			}else{
				msg = Constants.AJAX_RESULT_ERROR+"系统错误，检查失败";
				return msg;
			}*/
			List<String> allList = mp.get("allList");
			List<String> existList = mp.get("existList");
			if(existList.size()!=0&&allList.size()==0){
				msg = Constants.AJAX_RESULT_FAIL+"您所输入的名称都已存在";
				return msg;
			}
			PublicResult<List<String>> addResult = vparentService.addVisitTags(vparent_id, allList);
			if(!addResult.isSuccess()||addResult.getModel()==null){
				msg = Constants.AJAX_RESULT_ERROR+"系统错误，检查失败";
				return msg;
			}
			
			allList = addResult.getModel();
			msg = Constants.AJAX_RESULT_SUCCESS+"添加成功" + allList.size() + "个";
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
	 * 检查去重VisitParent
	 * 
	 * */
	public Map<String,List<String>> checkVisitParentRepeat(String vparent_name){
		try{
			List<String> allList = new ArrayList<String>();
			List<String> existList = new ArrayList<String>();
			//将带有逗号字符串转换成list列表
			allList = EncapsulateUtil.encaList(vparent_name);
			Iterator<String> iter = allList.iterator();
			while(iter.hasNext()){
				String temp = iter.next();
				PublicResult<VisitParent> result = vparentService.queryVisitParentByVParentName(temp);
				if(result.isSuccess()){
					if(result.getModel()!=null){		//该目的地已经存在
						iter.remove();
						existList.add(temp);
					}
				}else{
					logger.error("检查目的地标签vparent_name是否存在时出现错误！");
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
	 * 检查去重VisitTag
	 * 
	 * */
	public Map<String,List<String>> checkVisitTagRepeat(String vparent_id,String visitTags){
		try{
			List<String> allList = new ArrayList<String>();
			List<String> existList = new ArrayList<String>();
			allList = EncapsulateUtil.encaList(visitTags);
			Iterator<String> iter = allList.iterator();
			while(iter.hasNext()){
				String temp = iter.next();
				PublicResult<VisitParent> result = vparentService.queryVisitTagByVisitName(vparent_id,temp);
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
	 * 修改二级目的地标签 visit_name
	 * 
	 * */
	@RequestMapping(value="/editVisitTag",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody String editVisitTag(String visit_id,String visit_name,String vparent_id){
		String msg = "null";
		try{
			if(StringUtils.isBlank(visit_name)&&StringUtils.isBlank(visit_id)&&StringUtils.isBlank(vparent_id)){
				msg = Constants.AJAX_RESULT_ERROR+"参数为空";
				return msg;
			}
			
			PublicResult<Boolean> editResult = vparentService.editVisitTag(vparent_id, visit_id, visit_name);
			if(!editResult.isSuccess()){
				msg = Constants.AJAX_RESULT_ERROR+"系统错误，修改失败";
				return msg;
			}
			
			msg = Constants.AJAX_RESULT_SUCCESS+"修改成功";
			return msg;
		} catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			msg = Constants.AJAX_RESULT_ERROR+"系统错误";
			return msg;
		} 
	}
	
	/**
	 * 删除二级目的地标签
	 * 
	 * */
	@RequestMapping(value="/delVisitTag")
	public ModelAndView delVisitTag(@RequestParam(value = "vparent_id", required = true) String vparent_id
			,@RequestParam(value = "visit_id", required = true) String visit_id){
		ModelAndView mav = new ModelAndView();
		mav.setViewName(URL_REDIRECT + "visitTagList.htm?vparent_id="+vparent_id);
		try{
			if(StringUtils.isBlank(vparent_id)&&StringUtils.isBlank(visit_id))
			{
				mav.addObject(ERROR_MSG_KEY, "参数为空");
				mav.setViewName("admin/doFail");
				return mav;
			}
			
			PublicResult<Boolean> result = vparentService.deltelVisitTag(vparent_id, visit_id);
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
	
	/**
	 * 删除一级菜单 vparent_id
	 * 
	 * */
	@RequestMapping(value="/delVParentTag")
	public ModelAndView delVParentTag(@RequestParam(value = "p", required = false) Integer pageNo,
			@RequestParam(value = "vparent_id", required = false) String vparent_id,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		try{
			PublicResult<VisitParent> queryResult = vparentService.queryVisitParentByVParentId(vparent_id);
			if(queryResult.isSuccess()){
				
				VisitParent vparent = queryResult.getModel();
				if(vparent.getVisit_tag().size()<1){
					
				}
				PublicResult<Boolean> result = vparentService.deltelVisitParent(vparent_id);
				
				if(!result.isSuccess()){
					mav.addObject(ERROR_MSG_KEY, "删除失败，请联系技术人员");
				}
			}
			
			mav.setViewName(URL_REDIRECT + "/admin/vparent_list.htm");
			return mav;
		}catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			
			mav.addObject(ERROR_MSG_KEY, ex.getMessage());
			
			mav.setViewName(URL_FORWARD + "/admin/vparent_list.htm");
			return mav;
		}

	}
	
	/**
	 * 修改一级菜单 vparent_name vparent_id
	 * 
	 * */
	
	
	/**
	 * 检验该名词是否已经存在 AJAX
	 * */
	@RequestMapping(value="/checkVParentName",method = RequestMethod.GET)
	public void checkAlbumName(@RequestParam("vparent_name") String vparent_name,PrintWriter printWriter){
		String msg = "null";
		try{
			if(StringUtils.isBlank(vparent_name)){
				msg = "菜单名称不能为空";
			}
			PublicResult<VisitParent> result = vparentService.queryVisitParentByVParentName(vparent_name);
			if(result.isSuccess()){
				if(result.getModel()==null){
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
}
