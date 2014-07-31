package com.cms.web;

import java.io.PrintWriter;
import java.net.URLDecoder;

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
import com.cms.entity.ChipInfo;
import com.cms.service.ChipCategoryService;
import com.cms.service.ChipInfoService;
import com.common.utils.Constants;
import com.common.utils.PublicResult;
import com.usual.utils.Page;
import com.usual.web.BaseController;

@Controller
@RequestMapping("/admin")
public class ChipCategoryController extends BaseController {

	private final static Logger logger = Logger.getLogger(ChipCategoryController.class);
	
	
	@Autowired
	private ChipCategoryService chipCaService;
	
	@Autowired
	private ChipInfoService chipService;
	
	
	/**
	 * 检验该名词是否已经存在 AJAX
	 * */
	@RequestMapping(value="/checkChipCaName",method = RequestMethod.GET)
	public void checkAlbumName(@RequestParam("chip_ca_name") String chip_ca_name,PrintWriter printWriter){
		String msg = "null";
		try{
			if(StringUtils.isBlank(chip_ca_name)){
				msg = "碎片分类名称不能为空";
			}
			chip_ca_name = URLDecoder.decode(chip_ca_name, "UTF-8");
			PublicResult<ChipCategory> result = chipCaService.queryInfo(null, chip_ca_name);
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
	
	/**
	 * 添加相册名称 AJAX
	 * 
	 * */
	@RequestMapping(value="/addChipCA",method=RequestMethod.POST)
	public ModelAndView addChipCA(ChipCategory info){
		ModelAndView mav = new ModelAndView();
		mav.setViewName(URL_REDIRECT + "/admin/chipCategories.htm");
		try{
			PublicResult<String> result = chipCaService.addInfo(info);
			
			if(!result.isSuccess()){
				mav.setViewName("doFail");
				mav.addObject(ERROR_MSG_KEY, "添加失败！");
			}
			
			return mav;
		} catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			mav.setViewName("doFail");
			mav.addObject(ERROR_MSG_KEY, "系统错误");
			return mav;
		} 
	}
	
	/**
	 * 修改分类
	 * 
	 * */
	@RequestMapping(value="/editChipCA",method=RequestMethod.POST)
	public ModelAndView editChipCA(ChipCategory info){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/chips.htm");
		try{
			if(info==null||StringUtils.isBlank(info.getChip_ca_name())
					||StringUtils.isBlank(info.getChip_ca_id())
					||StringUtils.isBlank(info.getPage_url())){
				mav.addObject(ERROR_MSG_KEY, "参数为空，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			PublicResult<Boolean> editResult = chipCaService.updateInfo(info);
			if(editResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "修改失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			mav.setViewName(URL_REDIRECT + "/admin/chipCategories.htm");
			return mav;
		}catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			
			mav.addObject(ERROR_MSG_KEY, ex.getMessage());
			
			mav.setViewName(URL_REDIRECT + "/admin/chips.htm");
			return mav;
		}
	}
	
	
	/**
	 * 获取album列表forward
	 * */
	@RequestMapping(value="/chipCategories")
	public ModelAndView chipCategories(@RequestParam(value = "p", required = false) Integer pageNo){
		ModelAndView mav = new ModelAndView();
		try{
			pageNo = pageNo==null?1:pageNo;
			int startIndex = (pageNo - 1) * PAGE_SIZE;
			int totalPage = 0;
			PublicResult<ChipCategory> result = chipCaService.queryInfoList(startIndex, PAGE_SIZE);
			if(result!=null){
				mav.addObject("chipcaList", result.getModelList());
			}
			mav.setViewName("admin/chip/chipcaList");
			
			Page page = new Page(PAGE_SIZE,result.getCount(),pageNo);
            totalPage = page.getTotalPage();
            mav.addObject("currentPage",pageNo);
            mav.addObject("pageSize",PAGE_SIZE);
            mav.addObject("totalPage",totalPage);
            mav.addObject("totalCount",result.getCount());
			return mav;
		}catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, ex.getMessage());
			return mav;
		}

	}
	
	
	@RequestMapping(value="/delChipCa")
	public ModelAndView delChipCa(@RequestParam(value = "chip_ca_id", required = false) String chip_ca_id,
			HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName(URL_REDIRECT + "/admin/chipCategories.htm");
		try{
			PublicResult<ChipCategory> queryResult = chipCaService.queryInfo(chip_ca_id, null);
			if(queryResult.isSuccess()){
				PublicResult<Long> chipResult = chipService.queryCount(chip_ca_id);
				if(chipResult.getCount()>0){
					mav.addObject(ERROR_MSG_KEY, "分类里还有碎片，不能删除");
					mav.setViewName("/admin/doFail");
					return mav;
				}
				//检查改分类下是否有碎片
				PublicResult<Boolean> result = chipCaService.deltelInfo(chip_ca_id);
				if(!result.isSuccess()){
					mav.addObject(ERROR_MSG_KEY, "删除失败，请联系技术人员");
					mav.setViewName("/admin/doFail");
					return mav;
				}
			}
			return mav;
		}catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			
			mav.addObject(ERROR_MSG_KEY, ex.getMessage());
			
			mav.setViewName(URL_REDIRECT + "/admin/chipCategories.htm");
			return mav;
		}

	}
}
