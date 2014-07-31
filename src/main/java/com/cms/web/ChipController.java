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
public class ChipController extends BaseController {

private final static Logger logger = Logger.getLogger(ChipController.class);
	
	
	@Autowired
	private ChipInfoService chipService;
	
	@Autowired
	private ChipCategoryService chipCaService;
	
	
	/**
	 * 检验该名词是否已经存在 AJAX
	 * */
	@RequestMapping(value="/checkChipName",method = RequestMethod.GET)
	public void checkAlbumName(@RequestParam("chip_var") String chip_var,@RequestParam("chip_name") String chip_name,PrintWriter printWriter){
		String msg = "null";
		try{
			if(StringUtils.isBlank(chip_name)&&StringUtils.isBlank(chip_var)){
				msg = "碎片名称不能为空";
			}
			if(StringUtils.isNotBlank(chip_name)){
				chip_name = URLDecoder.decode(chip_name, "UTF-8");
			}
			
			PublicResult<ChipInfo> result = chipService.queryInfo(null, chip_name,chip_var);
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
	@RequestMapping(value="/toAddChip")
	public ModelAndView toAddChip(@RequestParam(value = "chip_ca_id", required = false) String chip_ca_id){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/addChip.htm");
		try{
			PublicResult<ChipCategory> queryResult = chipCaService.queryInfo(chip_ca_id, null);
			if(!queryResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			mav.addObject("caInfo", queryResult.getModel());
			mav.setViewName("/admin/chip/addChip");
			return mav;
		}catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			
			mav.addObject(ERROR_MSG_KEY, ex.getMessage());
			
			mav.setViewName(URL_REDIRECT + "/admin/chips.htm");
			return mav;
		}
	}
	
	/**
	 * 添加碎片
	 * 
	 * */
	@RequestMapping(value="/addChip",method=RequestMethod.POST)
	public ModelAndView addChip(ChipInfo info){
		ModelAndView mav = new ModelAndView();
		mav.setViewName(URL_REDIRECT + "/admin/chips.htm?chip_ca_id="+info.getChip_ca_id());
		try{
			if(info==null&&StringUtils.isBlank(info.getChip_name())
					&&StringUtils.isBlank(info.getChip_ca_id())
					&&StringUtils.isBlank(info.getChip_con())){
				mav.addObject(ERROR_MSG_KEY, "参数为空，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			PublicResult<String> queryResult = chipService.addInfo(info);
			if(!queryResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "添加失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			return mav;
		}catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			
			mav.addObject(ERROR_MSG_KEY, ex.getMessage());
			
			mav.setViewName(URL_REDIRECT + "/admin/chips.htm");
			return mav;
		}
	}
	
	/**
	 * 修改碎片
	 * 
	 * */
	@RequestMapping(value="/toEditChip")
	public ModelAndView toEditChip(@RequestParam(value = "chip_id", required = false) String chip_id){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/editChip.htm");
		try{
			PublicResult<ChipInfo> queryResult = chipService.queryInfo(chip_id, null,null);
			if(!queryResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo info = queryResult.getModel();
			mav.addObject("chipInfo", info);
			
			PublicResult<ChipCategory> caResult = chipCaService.queryInfo(info.getChip_ca_id(), null);
			if(!caResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			
			mav.addObject("caInfo", caResult.getModel());
			mav.setViewName("/admin/chip/editChip");
			return mav;
		}catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			
			mav.addObject(ERROR_MSG_KEY, ex.getMessage());
			
			mav.setViewName(URL_REDIRECT + "/admin/chips.htm");
			return mav;
		}
	}
	
	/**
	 * 添加碎片
	 * 
	 * */
	@RequestMapping(value="/editChip",method=RequestMethod.POST)
	public ModelAndView editChip(ChipInfo info){
		ModelAndView mav = new ModelAndView();
		mav.setViewName(URL_REDIRECT + "/admin/chips.htm?chip_ca_id="+info.getChip_ca_id());
		try{
			if(info==null&&StringUtils.isBlank(info.getChip_name())
					&&StringUtils.isBlank(info.getChip_ca_id())
					&&StringUtils.isBlank(info.getChip_id())
					&&StringUtils.isBlank(info.getChip_con())){
				mav.addObject(ERROR_MSG_KEY, "参数为空，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			PublicResult<Boolean> editResult = chipService.updateInfo(info);
			if(!editResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "修改失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			return mav;
		}catch(Exception ex){
			logger.error(ex.getMessage(), ex);
			
			mav.addObject(ERROR_MSG_KEY, ex.getMessage());
			
			mav.setViewName(URL_REDIRECT + "/admin/chips.htm");
			return mav;
		}
	}
	
	
	/**
	 * 获取碎片列表forward
	 * */
	@RequestMapping(value="/chips")
	public ModelAndView albumList(@RequestParam(value = "p", required = false) Integer pageNo,
			@RequestParam(value = "chip_ca_id", required = false) String chip_ca_id){
		ModelAndView mav = new ModelAndView();
		try{
			pageNo = pageNo==null?1:pageNo;
			int startIndex = (pageNo - 1) * PAGE_SIZE;
			int totalPage = 0;
			PublicResult<ChipInfo> result = chipService.queryInfoList(startIndex, PAGE_SIZE,chip_ca_id);
			if(result!=null){
				mav.addObject("chipList", result.getModelList());
			}
			if(StringUtils.isNotBlank(chip_ca_id)){
				PublicResult<ChipCategory> caResult = chipCaService.queryInfo(chip_ca_id, null);
				 mav.addObject("caInfo",caResult.getModel());
			}
			
			mav.setViewName("admin/chip/chipList");
			
			PublicResult<ChipCategory> caResult = chipCaService.queryInfoList(0, 0);
			mav.addObject("chipcaList",caResult.getModelList());
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
	
	
	@RequestMapping(value="/delChip")
	public ModelAndView delAlbumPic(@RequestParam(value = "chip_id", required = false) String chip_id,
			HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName(URL_REDIRECT + "/admin/chips.htm");
		try{
			PublicResult<ChipInfo> queryResult = chipService.queryInfo(chip_id, null,null);
			if(queryResult.isSuccess()){
				
				//检查改分类下是否有碎片
				PublicResult<Boolean> result = chipService.deleteInfo(chip_id);
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
			
			mav.setViewName(URL_REDIRECT + "/admin/chips.htm");
			return mav;
		}

	}
}
