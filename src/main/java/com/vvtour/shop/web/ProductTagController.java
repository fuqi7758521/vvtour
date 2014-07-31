package com.vvtour.shop.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.common.utils.Constants;
import com.common.utils.PublicResult;
import com.common.utils.UnicodeUtils;
import com.usual.entity.AlbumInfo;
import com.usual.utils.FileToolkit;
import com.usual.web.BaseController;
import com.vvtour.shop.entity.ProductType;
import com.vvtour.shop.entity.VisitParent;

@Controller
@RequestMapping("/admin")
public class ProductTagController extends BaseController {
	
	private final static Logger logger = Logger.getLogger(ProductTagController.class);
	
	private final static String PRO_TYPE = "var proType = ";
	
	
	@RequestMapping(value="/proTypeList")
	public ModelAndView proTypeList(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		try{
			String tagPath = request.getSession().getServletContext()
	                .getRealPath("/js/pro_tag/proTypeData.js");
			
			List<ProductType> list = new ArrayList<ProductType>();
			String proTypeJSON = FileToolkit.readFileContent(tagPath);
			proTypeJSON = UnicodeUtils.fromEncodedUnicode(proTypeJSON.toCharArray(), 0, proTypeJSON.length());
			if(proTypeJSON.indexOf(PRO_TYPE)>-1){
				proTypeJSON = proTypeJSON.replace(PRO_TYPE, "");
				list = (List<ProductType>)JSONArray.parseArray(proTypeJSON, ProductType.class);
			}
			mav.addObject("typeList", list);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		mav.setViewName("admin/pro_tag/proTypeList");
		return mav;
	}
	
	/**
	 * 添加产品名称
	 * 
	 * */
	@RequestMapping(value="/addProType",method=RequestMethod.POST)
	public ModelAndView addProType(ProductType info,HttpServletRequest request) throws FileNotFoundException{
		ModelAndView mav = new ModelAndView();
		mav.setViewName(URL_REDIRECT + "/admin/proTypeList.htm");
		try{
			if(info == null || StringUtils.isBlank(info.getPtype_name())){
				mav.addObject(ERROR_MSG_KEY, "提交名称为空,请联系技术人员");
				return mav;

			}
			
			String tagPath = request.getSession().getServletContext()
	                .getRealPath("/js/pro_tag/proTypeData.js"); 
			
			try{
				File file = new File(tagPath);
				if(!file.isFile()){
					mav.addObject(ERROR_MSG_KEY, "提交名称为空,请联系技术人员");
					return mav;
				}
			}catch(Exception ex){
				ex.printStackTrace();
				logger.error(ex.getMessage(), ex);
				mav.addObject(ERROR_MSG_KEY, "提交发生错误,请联系技术人员");
				return mav;
			}
			
			 
			try{
				List<ProductType> list = new ArrayList<ProductType>();
				String proTypeJSON = FileToolkit.readFileContent(tagPath);
				proTypeJSON = UnicodeUtils.fromEncodedUnicode(proTypeJSON.toCharArray(), 0, proTypeJSON.length());
				
				
				int nextID = 10001;
				if(proTypeJSON.indexOf(PRO_TYPE)>-1){
					proTypeJSON = proTypeJSON.replace(PRO_TYPE, "");
					list = (List<ProductType>)JSONArray.parseArray(proTypeJSON, ProductType.class);
					if(list.size() > 0){
						ProductType typeTemp = new ProductType();
						typeTemp = list.get(list.size()-1);
						nextID = Integer.parseInt(typeTemp.getPtype_id()) + 1;
					}
				}
				ProductType addType = new ProductType();
				addType.setPtype_id(nextID+"");
				addType.setPtype_name(info.getPtype_name());
				list.add(addType);
				
				String jsonString = JSON.toJSONString(list);
				jsonString = UnicodeUtils.toEncodedUnicode(jsonString, true);
				if(jsonString.indexOf("\\:")>-1) jsonString = jsonString.replace("\\:",":");
				
				FileToolkit.writeContentInFile(PRO_TYPE+jsonString, tagPath, false);
				
				
			}catch(Exception ex){
				ex.printStackTrace();
				logger.error(ex.getMessage(), ex);
				mav.addObject(ERROR_MSG_KEY, "提交发生错误,请联系技术人员");
				return mav;
			}
			
		} catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, "提交发生错误,请联系技术人员");
		}
		
		return mav;
	}
	
	
	/**
	 * 添加产品名称
	 * 
	 * */
	@RequestMapping(value="/addVisitParent",method=RequestMethod.POST)
	public ModelAndView addVisitParent(VisitParent info,HttpServletRequest request) throws FileNotFoundException{
		ModelAndView mav = new ModelAndView();
		mav.setViewName(URL_REDIRECT + "/admin/visitParentList.htm");
		try{
			if(info == null || StringUtils.isBlank(info.getVparent_name())){
				mav.addObject(ERROR_MSG_KEY, "提交名称为空,请联系技术人员");
				return mav;

			}
			
			String tagPath = request.getSession().getServletContext()
	                .getRealPath("/js/pro_tag/visitTagData.js"); 
			
			try{
				File file = new File(tagPath);
				if(!file.isFile()){
					mav.addObject(ERROR_MSG_KEY, "提交名称为空,请联系技术人员");
					return mav;
				}
			}catch(Exception ex){
				ex.printStackTrace();
				logger.error(ex.getMessage(), ex);
				mav.addObject(ERROR_MSG_KEY, "提交发生错误,请联系技术人员");
				return mav;
			}
			
			 
			try{
				List<VisitParent> list = new ArrayList<VisitParent>();
				String visiTagJSON = FileToolkit.readFileContent(tagPath);
				visiTagJSON = UnicodeUtils.fromEncodedUnicode(visiTagJSON.toCharArray(), 0, visiTagJSON.length());
				
				
				int nextID = 10001;
				if(visiTagJSON.indexOf(PRO_TYPE)>-1){
					visiTagJSON = visiTagJSON.replace(PRO_TYPE, "");
					list = (List<VisitParent>)JSONArray.parseArray(visiTagJSON, VisitParent.class);
					if(list.size() > 0){
						VisitParent tagTemp = new VisitParent();
						tagTemp = list.get(list.size()-1);
						nextID = Integer.parseInt(tagTemp.getVparent_id()) + 1;
					}
				}
				VisitParent addType = new VisitParent();
				addType.setVparent_id(nextID+"");
				addType.setVparent_name(info.getVparent_name());
				list.add(addType);
				
				String jsonString = JSON.toJSONString(list);
				jsonString = UnicodeUtils.toEncodedUnicode(jsonString, true);
				if(jsonString.indexOf("\\:")>-1) jsonString = jsonString.replace("\\:",":");
				
				FileToolkit.writeContentInFile(PRO_TYPE+jsonString, tagPath, false);
				
				
			}catch(Exception ex){
				ex.printStackTrace();
				logger.error(ex.getMessage(), ex);
				mav.addObject(ERROR_MSG_KEY, "提交发生错误,请联系技术人员");
				return mav;
			}
			
		} catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, "提交发生错误,请联系技术人员");
		}
		
		return mav;
	}
	/*
	@RequestMapping(value="/addProType",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody String addProType(ProductType info,HttpServletRequest request){
		String msg = "null";
		try{
			if(info == null || StringUtils.isBlank(info.getPtype_name())){
				msg = Constants.AJAX_RESULT_ERROR+"提交名称为空,请联系技术人员";
				return msg;
			}
			
			
			String tagPath = request.getSession().getServletContext()
	                .getRealPath("/js/pro_tag/proTypeData.js"); 
			
			try{
				File file = new File(tagPath);
				if(!file.isFile()){
					msg = Constants.AJAX_RESULT_ERROR+"提交名称为空,请联系技术人员";
					return msg;
				}
			}catch(Exception ex){
				ex.printStackTrace();
				logger.error(ex.getMessage(), ex);
				msg = Constants.AJAX_RESULT_ERROR+"提交名称为空,请联系技术人员";
				return msg;
			}
			
			 
			try{
				List<ProductType> list = new ArrayList<ProductType>();
				String proTypeJSON = FileToolkit.readFileContent(tagPath);
				proTypeJSON = UnicodeUtils.fromEncodedUnicode(proTypeJSON.toCharArray(), 0, proTypeJSON.length());
				
				
				int nextID = 10001;
				if(proTypeJSON.indexOf(PRO_TYPE)>-1){
					proTypeJSON = proTypeJSON.replace(PRO_TYPE, "");
					list = (List<ProductType>)JSONArray.parseArray(proTypeJSON, ProductType.class);
					if(list.size() > 0){
						ProductType typeTemp = new ProductType();
						typeTemp = list.get(list.size()-1);
						nextID = Integer.parseInt(typeTemp.getPtype_id()) + 1;
					}
				}
				ProductType addType = new ProductType();
				addType.setPtype_id(nextID+"");
				addType.setPtype_name(info.getPtype_name());
				list.add(addType);
				
				String jsonString = JSON.toJSONString(list);
				jsonString = UnicodeUtils.toEncodedUnicode(jsonString, true);
				if(jsonString.indexOf("\\:")>-1) jsonString = jsonString.replace("\\:",":");
					
				FileToolkit.writeContentInFile(PRO_TYPE+jsonString, tagPath, false);
				msg = Constants.AJAX_RESULT_SUCCESS+"添加成功";
				
			}catch(Exception ex){
				ex.printStackTrace();
				logger.error(ex.getMessage(), ex);
				msg = Constants.AJAX_RESULT_ERROR+"获取产品类型资源失败,请联系技术人员";
			}
			
			return msg;
		} catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			msg = Constants.AJAX_RESULT_ERROR+"系统错误";
			return msg;
		} 
	}
	
	@RequestMapping("/proTypeList")
	public ModelAndView proTypeList(HttpServletRequest request) throws FileNotFoundException{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/pro_tag/proTypeList");
		List<ProductType> list = new ArrayList<ProductType>();
		String tagPath = request.getSession().getServletContext()
                .getRealPath("/js/pro_tag/proType.js"); 
		try{
			File file = new File(tagPath);
			if(!file.isFile()){
				mav.addObject(ERROR_MSG_KEY, "获取标签资源失败！请联系技术人员");
				return mav;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, "系统出错："+ex.getMessage());
		}
		
		try{
			String proTypeJSON = FileToolkit.readFileContent(tagPath);
			proTypeJSON = UnicodeUtils.fromEncodedUnicode(proTypeJSON.toCharArray(), 0, proTypeJSON.length());
			
			if(proTypeJSON.indexOf(PRO_TYPE)>-1){
				proTypeJSON = proTypeJSON.replace(PRO_TYPE, "");
			}
			
			list = (List<ProductType>)JSONArray.parseArray(proTypeJSON, ProductType.class);
			mav.addObject("proTypeList",list);
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, "系统出错："+ex.getMessage());
		}
		
		return mav;
	}*/
	
	
	

}
