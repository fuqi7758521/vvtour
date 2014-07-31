package com.cms.web;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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

import com.cms.entity.ChipCategory;
import com.common.utils.Constants;
import com.common.utils.PublicResult;
import com.usual.utils.MakeHtml;
import com.usual.web.BaseController;
import com.vvtour.shop.entity.ProductInfo;
import com.vvtour.shop.service.ProductInfoService;

@Controller
@RequestMapping("/admin")
public class HtmlMngController extends BaseController {
	
	private final static Logger logger = Logger.getLogger(HtmlMngController.class);

	@Autowired
	private ProductInfoService productService;
	
	/**
	 * 添加相册名称 AJAX
	 * 
	 * */
	@RequestMapping(value="/generateAll",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String generateAll(HttpServletRequest request,PrintWriter printWriter){
		String msg = "";
		try{
			//获取总数量
			//小于100的一次性全部生成完
			//大于一百的分批生成完，中间隔5秒
			PublicResult<Long> coutResult = productService.queryProductCount(null, null, null, null);
			if(!coutResult.isSuccess()){
				msg = Constants.AJAX_RESULT_ERROR+"获取数据失败";
				return msg;
			}
			String basePath,rootPath,htmlUrl;
			PublicResult<ProductInfo> result = new PublicResult<ProductInfo>();
			if(coutResult.getCount()>100){
				
			}else{
				result = productService.queryProductList(0, 0, null, null,null,null);
				List<ProductInfo> list = new ArrayList<ProductInfo>();
				for(ProductInfo info:list){
					//====================生成路线HTML=====================
					basePath = request.getScheme()+"://"+request.getServerName() + request.getContextPath();
					rootPath = request.getSession().getServletContext()
		                    .getRealPath(info.getLink_url());
					htmlUrl = rootPath + result.getModel() + ".html";
					basePath = basePath + ProductInfo.ACTION_PRODUCT_URL + result.getModel();
					MakeHtml.writeHtml(basePath, htmlUrl, true);
					
					try {
			            Thread.sleep(100);
			        } catch (InterruptedException e) {
			            e.printStackTrace(); 
			        }
				}
			}
			
			msg = Constants.AJAX_RESULT_SUCCESS+"生成成功|"+coutResult.getCount();
			
			return msg; 
		} catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			//msg = Constants.AJAX_RESULT_ERROR+"获取分类失败,请联系技术人员";
			return msg;
		} 
	}
	
	/**
	 * 添加相册名称 AJAX
	 * 
	 * */
	@RequestMapping(value="/generateProHTML",method=RequestMethod.GET)
	public ModelAndView generateProHTML(@RequestParam("pro_id") String pro_id,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName(URL_REDIRECT + "/admin/products.htm");
		try{
			if(StringUtils.isBlank(pro_id)){
				mav.setViewName("doFail");
				mav.addObject(ERROR_MSG_KEY, "参数为空！");
				return mav;
			}
			PublicResult<ProductInfo> infoResult = productService.queryProductInfo(pro_id);
			if(!infoResult.isSuccess()){
				mav.setViewName("doFail");
				mav.addObject(ERROR_MSG_KEY, "获取资源失败！");
				return mav;
			}
			ProductInfo info = infoResult.getModel();
			if(info==null){
				mav.setViewName("doFail");
				mav.addObject(ERROR_MSG_KEY, "获取资源失败！");
				return mav;
			}
			//====================生成路线HTML=====================
			String basePath,rootPath,htmlUrl;
			basePath = request.getScheme()+"://"+request.getServerName() + request.getContextPath();
			rootPath = request.getSession().getServletContext()
                    .getRealPath(info.getLink_url());
			htmlUrl = rootPath + SPRIT + pro_id + ".html";
			basePath = basePath + ProductInfo.ACTION_PRODUCT_URL + pro_id;
			MakeHtml.writeHtml(basePath, htmlUrl, true);
			
			productService.updateProductStatus(pro_id, ProductInfo.PRODUCT_PUB);
			
			return mav;
			
		} catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			mav.setViewName("doFail");
			mav.addObject(ERROR_MSG_KEY, "系统错误");
			return mav;
		} 
	}
	
	/**
	 * AJAX生成产品静态页
	 * 
	 * */
	@RequestMapping(value="/generatePro",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String generatePro(@RequestParam("pro_id") String pro_id,HttpServletRequest request){
		String msg = "";
		try{
			if(StringUtils.isBlank(pro_id)){
				msg = Constants.AJAX_RESULT_ERROR+"参数为空";
				return msg;
			}
			PublicResult<ProductInfo> infoResult = productService.queryProductInfo(pro_id);
			if(!infoResult.isSuccess()){
				msg = Constants.AJAX_RESULT_ERROR+"获取数据失败";
				return msg;
			}
			ProductInfo info = infoResult.getModel();
			if(info==null){
				msg = Constants.AJAX_RESULT_ERROR+"获取数据失败";
				return msg;
			}
			//====================生成路线HTML=====================
			String basePath,rootPath,htmlUrl;
			basePath = request.getScheme()+"://"+request.getServerName() + request.getContextPath();
			rootPath = request.getSession().getServletContext()
                    .getRealPath(info.getLink_url());
			htmlUrl = rootPath + SPRIT + pro_id + ".html";
			basePath = basePath + ProductInfo.ACTION_PRODUCT_URL + pro_id;
			MakeHtml.writeHtml(basePath, htmlUrl, true);
			
			productService.updateProductStatus(pro_id, ProductInfo.PRODUCT_PUB);
			
			msg = Constants.AJAX_RESULT_SUCCESS+"生成成功";
			
			return msg; 
		} catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			msg = Constants.AJAX_RESULT_ERROR+"生成失败,请联系技术人员";
			return msg;
		} 
	}
	
	/**
	 * AJAX生成产品通用页
	 * 
	 * */
	@RequestMapping(value="/generateChannel",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String generateChannel(@RequestParam("gen_url") String gen_url,HttpServletRequest request){
		String msg = "";
		try{
			if(StringUtils.isBlank(gen_url)){
				msg = Constants.AJAX_RESULT_ERROR+"参数为空";
				return msg;
			}
			if(gen_url.indexOf(SPRIT)==0){
				gen_url = gen_url.substring(0,1);
			}
			String url_path="",fileName;
			fileName = "index";
			if(gen_url.indexOf("index.htm")<0){
				url_path = gen_url.substring(0,gen_url.indexOf('.'));
			}
			
			//====================生成路线HTML=====================
			String basePath,rootPath,htmlUrl;
			basePath = request.getScheme()+"://"+request.getServerName() + request.getContextPath();
			rootPath = request.getSession().getServletContext()
                    .getRealPath(url_path);
			htmlUrl = rootPath + SPRIT + fileName + ".html";
			basePath = basePath + SPRIT + gen_url;
			MakeHtml.writeHtml(basePath, htmlUrl, true);
			
			msg = Constants.AJAX_RESULT_SUCCESS+"生成成功";
			
			return msg; 
		} catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			msg = Constants.AJAX_RESULT_ERROR+"生成失败,请联系技术人员";
			return msg;
		} 
	}
	
}
