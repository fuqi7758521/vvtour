package com.vvtour.shop.web;


import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.springframework.web.util.HtmlUtils;

import com.common.utils.Constants;
import com.common.utils.PublicResult;
import com.common.utils.RequestUtils;
import com.usual.entity.AdminInfo;
import com.usual.utils.EncapsulateUtil;
import com.usual.utils.MakeHtml;
import com.usual.utils.Page;
import com.usual.utils.ValidateUtil;
import com.usual.web.BaseController;
import com.vvtour.shop.entity.CategoryInfo;
import com.vvtour.shop.entity.ProductInfo;
import com.vvtour.shop.service.ProductInfoService;

@Controller
@RequestMapping("/admin")
public class ProductController extends BaseController {
	
	private final static Logger logger = Logger.getLogger(ProductController.class);

	@Autowired
	private ProductInfoService productService;
	
	/**
	 * 后台列表 删除
	 * */
	@RequestMapping(value="/delProduct",method=RequestMethod.GET)
	public ModelAndView delProduct(HttpServletRequest request,@RequestParam(value = "pro_id", required = false) String pro_id,
			@RequestParam(value = "redirect_url", required = false) String redirect_url){
		ModelAndView mav = new ModelAndView();
		mav.setViewName(URL_REDIRECT+redirect_url);
		try{
			
			//检查是否存在该产品
			PublicResult<ProductInfo> queryResult = productService.queryProductInfo(pro_id);
			if(!queryResult.isSuccess()){
				mav.addObject(ERROR_MSG_KEY, "不存在该产品");
				return mav;
			}
			
			//删除
			PublicResult<Boolean> result = productService.delProduct(pro_id);
			
			if(!result.isSuccess()){
				mav.addObject(ERROR_MSG_KEY, "删除发生错误,请联系技术人员");
				return mav;
			}
			/*
			 * ProductInfo info = queryResult.getModel();
			 * String rootPath = request.getSession().getServletContext()
                    .getRealPath(info.getLink_url());
			String deleteUrl = rootPath + info.getPro_id() + ".html";
			File deleteFile = new File(deleteUrl);
			if(!deleteFile.exists()){
				mav.addObject(ERROR_MSG_KEY, "需要删除的页面文件不存在,请联系技术人员，具体要删除的文件是:\n"+deleteUrl);
				return mav;
			}
			if(!MakeHtml.deleteFile(deleteUrl)){
				logger.info("删除Html文件失败！");
				mav.addObject(ERROR_MSG_KEY, "删除页面文件发生错误,请联系技术人员");
				return mav;
			}*/
			mav.addObject(SUCCESS_MSG_KEY, "删除成功");

		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, "提交发生错误,请联系技术人员");
			return mav;
		}
		return mav;
	}
	
	/**
	 * 后台列表 跳转编辑页面
	 * */
	@RequestMapping(value="/toEditProduct",method=RequestMethod.GET)
	public ModelAndView toEditProduct(HttpServletRequest request,@RequestParam(value = "pro_id", required = false) String pro_id,
			@RequestParam(value = "redirect_url", required = false) String redirect_url){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/product/edit_product");
		try{
			
			//检查是否存在该产品
			PublicResult<ProductInfo> queryResult = productService.queryProductInfo(pro_id);
			if(!queryResult.isSuccess()){
				mav.addObject(ERROR_MSG_KEY, "不存在该产品");
				return mav;
			}
			ProductInfo info = queryResult.getModel();
			mav.addObject("info", info);
			mav.addObject("topic_tag", EncapsulateUtil.arrayToString(info.getTopic_tag()));
			mav.addObject("feature_tag", EncapsulateUtil.arrayToString(info.getFeature_tag()));
			mav.addObject("search_tag", EncapsulateUtil.arrayToString(info.getSearch_tag()));
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, "提交发生错误,请联系技术人员");
			return mav;
		}
		return mav;
	}
	
	/**
	 * 后台列表 跳转编辑页面
	 * */
	@RequestMapping(value="/editProduct",method=RequestMethod.POST)
	public ModelAndView editProduct(HttpServletRequest request,ProductInfo info){
		ModelAndView mav = new ModelAndView();
		mav.setViewName(URL_FORWARD+"/admin/doFail");
		try{
			if(info==null||StringUtils.isBlank(info.getPro_id())){
				mav.addObject(ERROR_MSG_KEY, "参数为空");
				return mav;
			}
			
			//检查是否存在该产品
			PublicResult<ProductInfo> queryResult = productService.queryProductInfo(info.getPro_id());
			if(!queryResult.isSuccess()){
				mav.addObject(ERROR_MSG_KEY, "不存在该产品");
				return mav;
			}
			mav.setViewName(URL_REDIRECT+"/admin/products");
			ProductInfo queryInfo = queryResult.getModel();
			queryInfo = encaEditProduct(queryInfo,info);
			
			//===============修改产品========================
			PublicResult<Boolean> editResult = productService.editProductInfo(queryInfo);
			if(!editResult.isSuccess()){
				mav.addObject(ERROR_MSG_KEY, "修改失败,请联系技术人员");
				return mav;
			}
			
			mav.addObject(MEMORY_URL, "/admin/products.htm");
			mav.addObject(SUCCESS_MSG_KEY, "修改成功！");
			mav.addObject(SUCCESS_DATA, queryInfo.getPro_id());
			mav.addObject(OPERATE_TYPE, "editProduct");
			mav.setViewName("admin/doSuccess");
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, "提交发生错误,请联系技术人员");
			return mav;
		}
		return mav;
	}
	
	private ProductInfo encaEditProduct(ProductInfo queryInfo,ProductInfo editInfo){
		if(StringUtils.isNotBlank(editInfo.getCa_type())){
			queryInfo.setCa_type(editInfo.getCa_type());
		}
		if(StringUtils.isNotBlank(editInfo.getParent_id())){
			queryInfo.setParent_id(editInfo.getParent_id());
		}
		if(StringUtils.isNotBlank(editInfo.getParent_name())){
			queryInfo.setParent_name(editInfo.getParent_name());
		}
		if(StringUtils.isNotBlank(editInfo.getCa_id())){
			queryInfo.setCa_id(editInfo.getCa_id());
		}
		if(StringUtils.isNotBlank(editInfo.getCa_name())){
			queryInfo.setCa_name(editInfo.getCa_name());
		}
		if(StringUtils.isNotBlank(editInfo.getPage_descript())){
			queryInfo.setPage_descript(editInfo.getPage_descript());
		}
		if(StringUtils.isNotBlank(editInfo.getPage_keyword())){
			queryInfo.setPage_keyword(editInfo.getPage_keyword());
		}
		
		if(StringUtils.isNotBlank(editInfo.getSale_title())){
			queryInfo.setSale_title(editInfo.getSale_title());
		}
		if(StringUtils.isNotBlank(editInfo.getStart_city())){
			queryInfo.setStart_city(editInfo.getStart_city());
		}
		if(StringUtils.isNotBlank(editInfo.getTour_con())){
			queryInfo.setTour_con(editInfo.getTour_con());
		}
		if(StringUtils.isNotBlank(editInfo.getTour_feature())){
			queryInfo.setTour_feature(editInfo.getTour_feature());
		}
		//feature_tag
		if(StringUtils.isNotBlank(editInfo.getFeature_tag()[0])&&editInfo.getFeature_tag()!=null){
			if(editInfo.getFeature_tag()[0].indexOf(",")>-1){
				String[] feature_tag = editInfo.getFeature_tag()[0].split(",");
				queryInfo.setFeature_tag(feature_tag);
			}
		}
		if(StringUtils.isNotBlank(editInfo.getTour_fee())){
			queryInfo.setTour_fee(editInfo.getTour_fee());
		}
		if(StringUtils.isNotBlank(editInfo.getTour_tip())){
			queryInfo.setTour_tip(editInfo.getTour_tip());
		}
		if(StringUtils.isNotBlank(editInfo.getTour_title())){
			queryInfo.setTour_title(editInfo.getTour_title());
		}
		
		if(StringUtils.isNotBlank(editInfo.getTour_visa())){
			queryInfo.setTour_visa(editInfo.getTour_visa());
		}
		if(StringUtils.isNotBlank(editInfo.getVehicle())){
			queryInfo.setVehicle(editInfo.getVehicle());
		}
		
		if(editInfo.getDiscount_tag()!=null){
			queryInfo.setDiscount_tag(editInfo.getDiscount_tag());
		}
		queryInfo.setEdit_time(System.currentTimeMillis());
		
		if(editInfo.getMarket_price()!=0){
			queryInfo.setMarket_price(editInfo.getMarket_price());
		}
		if(editInfo.getMember_price()!=0){
			queryInfo.setMember_price(editInfo.getMember_price());
		}
		if(editInfo.getPay_form()!=null){
			queryInfo.setPay_form(editInfo.getPay_form());
		}
		
		queryInfo.setSearch_tag(encaSearchTag(editInfo));
		
		//start_dates
		if(StringUtils.isNotBlank(editInfo.getStart_dates()[0])&&editInfo.getStart_dates()!=null){
			if(editInfo.getStart_dates()[0].indexOf(",")>-1){
				String[] start_dates = editInfo.getStart_dates()[0].split(",");
				queryInfo.setStart_dates(start_dates);
			}
		}
		
		if(editInfo.getTour_days()!=0){
			queryInfo.setTour_days(editInfo.getTour_days());
		}
		
		if(editInfo.getTour_images()!=null){
			if(editInfo.getTour_images()!=null&&editInfo.getTour_images().length>0){
				String img = editInfo.getTour_images()[0];
				if(img.indexOf("http://127.0.0.1")>-1){
					img = img.replace("http://127.0.0.1", "");
				}
				queryInfo.setTour_images(img.split(","));
			}
		}
		
		if(editInfo.getViews_tag()!=null){
			queryInfo.setViews_tag(editInfo.getViews_tag());
		}
		return queryInfo;
	}
	
	/**
	 * 后台列表
	 * */
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView products(@RequestParam(value = "p", required = false) Integer pageNo,
			@RequestParam(value = "pid", required = false) String parent_id,
			@RequestParam(value = "cid", required = false) String ca_id){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/product/products");
		try{
			pageNo = pageNo==null?1:pageNo;
			int start = (pageNo - 1) * PAGE_SIZE;
			int totalPage = 0;
			//浏览
			PublicResult<ProductInfo> result = productService.queryProductList(start, PAGE_SIZE, parent_id, ca_id,null,null);
			
			Page page = new Page(PAGE_SIZE,result.getCount(),pageNo);
            totalPage = page.getTotalPage();
            mav.addObject("currentPage",pageNo);
            mav.addObject("pid",parent_id);
            mav.addObject("cid",ca_id);
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
	
	
	
	/**
	 * 后台搜索功能列表
	 * */
	@RequestMapping(value="/searchPro",method=RequestMethod.GET)
	public ModelAndView searchPro(@RequestParam(value = "p", required = false) Integer pageNo,
			@RequestParam(value = "search", required = false) String search){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/product/products");
		try{
			String pro_id=null;
			pageNo = pageNo==null?1:pageNo;
			int start = (pageNo - 1) * PAGE_SIZE;
			int totalPage = 0;
			if(ValidateUtil.isNumeric(search)){
				pro_id = search;
				search = null;
			}else{
				search = URLDecoder.decode(search, "UTF-8");
			}
			
			
			//浏览
			PublicResult<ProductInfo> result = productService.queryProductList(start, PAGE_SIZE, null, null,pro_id,search);
			
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
	
	//后台产品列表
	@RequestMapping(value="/proList",method=RequestMethod.GET)
	public ModelAndView proList(@RequestParam(value = "p", required = false) Integer pageNo,
			@RequestParam(value = "s", required = false) String sub_ca){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/doSuccess");
		try{
			if(StringUtils.isBlank(sub_ca)){
				mav.setViewName("admin/doFail");
				mav.addObject(ERROR_MSG_KEY, "参数为空，浏览失败");
				return mav;
			}
			
			//浏览
			PublicResult<ProductInfo> result = productService.queryProductInfo(sub_ca);
			
			if(!result.isSuccess()){
				mav.addObject(ERROR_MSG_KEY, "发布失败,请联系技术人员");
				return mav;
			}
			if(result.getModel() == null){
				mav.addObject(ERROR_MSG_KEY, "发布失败,请联系技术人员");
				return mav;
			}
			

			//返回成功页面
			mav.addObject(SUCCESS_MSG_KEY, "发布成功！");
			mav.addObject("proInfo", result.getModel());
			mav.setViewName("/admin/product/viewProduct");
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, "提交发生错误,请联系技术人员");
			return mav;
		}
		return mav;
	}
	
	@RequestMapping(value="/toAddProduct2",method=RequestMethod.POST)
	public ModelAndView toAddProduct2(String ca_type,
			String parent_id,
			String parent_name,
			String ca_id,
			String ca_name,
			String tour_days,
			String start_city,
			String end_city,
			HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/product/add_two");
		try{
			
			//返回成功页面
			mav.addObject("parent_id", parent_id);
			mav.addObject("parent_name", parent_name);
			mav.addObject("ca_type", ca_type);
			mav.addObject("ca_id", ca_id);
			mav.addObject("ca_name", ca_name);
			mav.addObject("tour_days", tour_days);
			mav.addObject("start_city", start_city);
			mav.addObject("end_city", end_city);
			
	        //java 获取请求 URL   
			mav.addObject("mem_url", RequestUtils.getRequestURL(request));

		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, "提交发生错误,请联系技术人员");
			return mav;
		}
		return mav;
	}
	
	@RequestMapping(value="/pubProduct",method=RequestMethod.POST)
	public ModelAndView pubProduct(HttpServletRequest request,ProductInfo info,String mem_url){
		ModelAndView mav = new ModelAndView();
		try{
			if(info == null || StringUtils.isBlank(info.getStart_city()) ||StringUtils.isBlank(info.getCa_type())){
				mav.addObject(ERROR_MSG_KEY, "提交名称为空,请联系技术人员");
				return mav;
			}
			//获取管理员信息
//			HttpSession session = request.getSession();
//			Object obj = session.getAttribute(Constants.LOGIN_ADMIN_KEY);
//			if(obj==null){
//				mav.addObject(ERROR_MSG_KEY, "您没有登录，请登录后操作");
//				mav.setViewName("admin/doFail");
//				return mav;
//			}
//			AdminInfo adminInfo = (AdminInfo)obj;
//			if(adminInfo.getRank()!=AdminInfo.RANK_ADMIN||adminInfo.getRank()!=AdminInfo.RANK_SUPER_ADMIN){
//				mav.addObject(ERROR_MSG_KEY, "您无权限操作");
//				mav.setViewName("admin/doFail");
//				return mav;
//			}
			AdminInfo adminInfo = new AdminInfo();
			adminInfo.setAdmin_name("hellowuyao");
			adminInfo.setReal_name("大麦茶");
			//封装数据
			info = fillInfo(adminInfo,info);
			//System.out.println(info.toString());
			
			StringBuffer sp = new StringBuffer();
			sp.append("/tours/").append(info.getCa_type()).append(SPRIT);
			sp.append(info.getParent_id()).append(SPRIT).append(info.getCa_id()).append(SPRIT);
			
			info.setLink_url(sp.toString());
			
			//保存
			PublicResult<String> result = productService.pubProductInfo(info);
			
			if(!result.isSuccess()){
				mav.addObject(ERROR_MSG_KEY, "发布失败,请联系技术人员");
				return mav;
			}
			if(result.getModel() == null){
				mav.addObject(ERROR_MSG_KEY, "发布失败,请联系技术人员");
				return mav;
			}
			
			//====================生成路线HTML=====================
/*			String basePath = request.getScheme()+"://"+request.getServerName() + request.getContextPath();
			String rootPath = request.getSession().getServletContext()
                    .getRealPath(info.getLink_url());
			String htmlUrl = rootPath + result.getModel() + ".html";
			basePath = basePath + ProductInfo.ACTION_PRODUCT_URL + result.getModel();
			MakeHtml.writeHtml(basePath, htmlUrl, true);*/
			
			//返回成功页面
			if(StringUtils.isBlank(mem_url)){
				mem_url="/admin/products.htm";
			}
			mav.addObject(MEMORY_URL, mem_url);
			mav.addObject(SUCCESS_MSG_KEY, "发布成功！");
			mav.addObject(SUCCESS_DATA, info.getPro_id());
			mav.addObject(OPERATE_TYPE, "pubProduct");
			mav.setViewName("admin/doSuccess");
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, "提交发生错误,请联系技术人员");
			return mav;
		}
		return mav;
	}
	
	private ProductInfo fillInfo(AdminInfo admin,ProductInfo info){
		
		if(StringUtils.isNotBlank(info.getTour_feature())){
			info.setTour_commend(MakeHtml.splitAndFilterString(info.getTour_feature(),65));
		}
		
		//tour_images
		if(info.getTour_images()!=null&&info.getTour_images().length>0){
			String img = info.getTour_images()[0];
			if(img.indexOf("http://127.0.0.1")>-1){
				img = img.replace("http://127.0.0.1", "");
			}
			info.setTour_images(img.split(","));
		}
		
		//start_dates
		if(StringUtils.isNotBlank(info.getStart_dates()[0])&&info.getStart_dates()!=null){
			if(info.getStart_dates()[0].indexOf(",")>-1){
				String[] start_dates = info.getStart_dates()[0].split(",");
				info.setStart_dates(start_dates);
			}
		}
		
		//topic_tag
		if(StringUtils.isNotBlank(info.getTopic_tag()[0])&&info.getTopic_tag()!=null){
			if(info.getTopic_tag()[0].indexOf(",")>-1){
				String[] topic_tag = info.getTopic_tag()[0].split(",");
				info.setTopic_tag(topic_tag);
			}
		}
		
		//feature_tag
		if(StringUtils.isNotBlank(info.getFeature_tag()[0])&&info.getFeature_tag()!=null){
			if(info.getFeature_tag()[0].indexOf(",")>-1){
				String[] feature_tag = info.getFeature_tag()[0].split(",");
				info.setFeature_tag(feature_tag);
			}
		}
		
		//discount_tag
		if(StringUtils.isNotBlank(info.getDiscount_tag()[0])&&info.getDiscount_tag()!=null){
			if(info.getDiscount_tag()[0].indexOf(",")>-1){
				String[] discount_tag = info.getDiscount_tag()[0].split(",");
				info.setDiscount_tag(discount_tag);
			}
		}
		
		//pay_form
		if(StringUtils.isNotBlank(info.getPay_form()[0])&&info.getPay_form()!=null){
			if(info.getPay_form()[0].indexOf(",")>-1){
				String[] pay_form = info.getPay_form()[0].split(",");
				info.setDiscount_tag(pay_form);
			}
		}
		
		//views_form
		if(StringUtils.isNotBlank(info.getViews_tag()[0])&&info.getViews_tag()!=null){
			if(info.getViews_tag()[0].indexOf(",")>-1){
				String[] views_tag = info.getViews_tag()[0].split(",");
				info.setViews_tag(views_tag);
			}
		}
		
		
		String[] str = encaSearchTag(info);
		info.setSearch_tag(str);
		info.setContinent("");
		info.setCountry("");
		info.setProvince("");
		info.setCity("");
		info.setTour_path("");
		info.setPub_time(System.currentTimeMillis());
		info.setEdit_time((long)0);
		info.setStatus(ProductInfo.PRODUCT_UNPUB);
		info.setPub_user(admin.getAdmin_name());
		info.setPub_nick(admin.getReal_name());
		return info;
	}
	
	private String[] encaSearchTag(ProductInfo info){
		//封装标签
		StringBuffer sp = new StringBuffer();
		sp.append(info.getParent_name()).append(",");
		sp.append(info.getCa_name()).append(",");
		if(StringUtils.isNotBlank(info.getTour_path())){
			sp.append(info.getTour_path()).append(",");
		}
		sp.append(info.getEnd_city()).append(",");
		if(info.getViews_tag().length>0){
			for(int i=0;i<info.getViews_tag().length;i++){
				sp.append(info.getViews_tag()[i]).append(",");
			}
		}
		String[] str = sp.toString().split(",");
		str = EncapsulateUtil.getDistinct(str);
		return str;
	}
	
	//后台浏览页
	@RequestMapping(value="/viewProduct",method=RequestMethod.GET)
	public ModelAndView viewProduct(HttpServletRequest request,
			@RequestParam(value = "pro_id", required = false) String pro_id){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/doFail");
		try{
			if(StringUtils.isBlank(pro_id)){
				mav.addObject(ERROR_MSG_KEY, "参数为空，浏览失败");
				return mav;
			}
			
			//浏览
			PublicResult<ProductInfo> result = productService.queryProductInfo(pro_id);
			
			if(!result.isSuccess()){
				mav.addObject(ERROR_MSG_KEY, "浏览失败!");
				return mav;
			}
			if(result.getModel() == null){
				mav.addObject(ERROR_MSG_KEY, "没有该产品,浏览失败!");
				return mav;
			}
			

			//返回成功页面
			mav.addObject(SUCCESS_MSG_KEY, "发布成功！");
			mav.addObject("proInfo", result.getModel());
			mav.setViewName("product/detail");
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, "提交发生错误,请联系技术人员");
			return mav;
		}
		return mav;
	}
	
	
	@RequestMapping(value="/catchProducts",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, Object> catchProducts(@RequestParam(value = "p", required = false) Integer pageNo,
			@RequestParam(value = "pid", required = false) String parent_id,
			@RequestParam(value = "cid", required = false) String ca_id){
		try{
			Map<String, Object> modelMap = new HashMap<String, Object>(3);
			pageNo = pageNo==null?1:pageNo;
			int start = (pageNo - 1) * PAGE_SIZE;
			int totalPage = 0;
			//浏览
			PublicResult<ProductInfo> result = productService.queryProductList(start, PAGE_SIZE, parent_id, ca_id,null,null);
			
			if(!result.isSuccess()){
				//msg = Constants.AJAX_RESULT_ERROR+"获取分类失败,请联系技术人员";
				modelMap.put("msg", Constants.AJAX_RESULT_ERROR+"获取产品失败,请联系技术人员");
				modelMap.put("data",null);
				modelMap.put("success","false");
				return modelMap;
			}
			if(result.getModelList() == null){
				//msg = Constants.AJAX_RESULT_ERROR+"获取分类失败,请联系技术人员";
				modelMap.put("msg", Constants.AJAX_RESULT_ERROR+"获取产品失败,请联系技术人员");
				modelMap.put("data",null);
				modelMap.put("success","false");
				return modelMap;
			}
			List<ProductInfo> list = new ArrayList<ProductInfo>();
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
	
	
}

