package com.cms.web;

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

import com.cms.entity.ChipInfo;
import com.cms.service.ChipInfoService;
import com.common.utils.PublicResult;
import com.usual.utils.Page;
import com.usual.utils.ValidateUtil;
import com.usual.web.BaseController;
import com.vvtour.shop.entity.ProductInfo;
import com.vvtour.shop.service.ProductInfoService;

@Controller
@RequestMapping("/")
public class IndexController extends BaseController {

	private final static Logger logger = Logger.getLogger(IndexController.class);
	
	@Autowired
	private ProductInfoService productService;
	
	@Autowired
	private ChipInfoService chipService;
	
	/**
	 * 首页
	 * 
	 * */
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public ModelAndView toIndex(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/index");
		try{
			//获取index_guide碎片
			PublicResult<ChipInfo> guideResult = chipService.queryInfo(null, null,"index_guide");
			if(!guideResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo info = guideResult.getModel();
			mav.addObject("index_guide", info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> menuResult = chipService.queryInfo(null, null,"index_menu");
			if(!menuResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo menu_info = menuResult.getModel();
			mav.addObject("index_menu", menu_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> bannerResult = chipService.queryInfo(null, null,"index_banner");
			if(!bannerResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo banner_info = bannerResult.getModel();
			mav.addObject("index_banner", banner_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> msResult = chipService.queryInfo(null, null,"index_mashang_tag");
			if(!msResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo ms_tag_info = msResult.getModel();
			mav.addObject("index_mashang_tag", ms_tag_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> msIMGResult = chipService.queryInfo(null, null,"index_mashang_img");
			if(!msIMGResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo ms_IMGinfo = msIMGResult.getModel();
			mav.addObject("index_mashang_img", ms_IMGinfo.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> bigIMGResult = chipService.queryInfo(null, null,"index_mashang_bigIMG");
			if(!bigIMGResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo big_IMGinfo = bigIMGResult.getModel();
			mav.addObject("index_mashang_bigIMG", big_IMGinfo.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> haiwaiResult = chipService.queryInfo(null, null,"index_haiwai");
			if(!haiwaiResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo haiwai_info = haiwaiResult.getModel();
			mav.addObject("index_haiwai", haiwai_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> guoneiResult = chipService.queryInfo(null, null,"index_guonei");
			if(!guoneiResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo guonei_info = guoneiResult.getModel();
			mav.addObject("index_guonei", guonei_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> zhoubianResult = chipService.queryInfo(null, null,"index_zhoubian");
			if(!zhoubianResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo zhoubian_info = zhoubianResult.getModel();
			mav.addObject("index_zhoubian", zhoubian_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> btmADResult = chipService.queryInfo(null, null,"index_buttom_ad");
			if(!btmADResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo btm_ADinfo = btmADResult.getModel();
			mav.addObject("index_buttom_ad", btm_ADinfo.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> tuangouResult = chipService.queryInfo(null, null,"index_tuangou");
			if(!tuangouResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo tuangou_info = tuangouResult.getModel();
			mav.addObject("index_tuangou", tuangou_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> cuxiaoResult = chipService.queryInfo(null, null,"index_cuxiao");
			if(!cuxiaoResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo cuxiao_info = cuxiaoResult.getModel();
			mav.addObject("index_cuxiao", cuxiao_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> topAbResult = chipService.queryInfo(null, null,"index_top_abroad");
			if(!topAbResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo top_ab_info = topAbResult.getModel();
			mav.addObject("index_top_abroad", top_ab_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> topDoResult = chipService.queryInfo(null, null,"index_top_domestic");
			if(!topDoResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo do_info = topDoResult.getModel();
			mav.addObject("index_top_domestic", do_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> topArResult = chipService.queryInfo(null, null,"index_top_around");
			if(!topArResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo top_AR_info = topArResult.getModel();
			mav.addObject("index_top_around", top_AR_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> aboutResult = chipService.queryInfo(null, null,"index_buttom_aboutus");
			if(!aboutResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo about_info = aboutResult.getModel();
			mav.addObject("index_buttom_aboutus", about_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> friendsResult = chipService.queryInfo(null, null,"index_buttom_friends");
			if(!friendsResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo friends_info = friendsResult.getModel();
			mav.addObject("index_buttom_friends", friends_info.getChip_con());
			
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, "发生错误,请联系技术人员");
			return mav;
		}
		return mav;
	}
	
	/**
	 * 频道页_出境
	 * 
	 * */
	@RequestMapping(value="/channel_abroad",method=RequestMethod.GET)
	public ModelAndView toChannel_Abroad(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/channel_abroad");
		try{
			
			//获取common_buttom_ad碎片
			PublicResult<ChipInfo> comBtmADResult = chipService.queryInfo(null, null,"common_buttom_ad");
			if(!comBtmADResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo comBtmADinfo = comBtmADResult.getModel();
			mav.addObject("common_buttom_ad", comBtmADinfo.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> tuangouResult = chipService.queryInfo(null, null,"channel_abroad_tuangou");
			if(!tuangouResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo info = tuangouResult.getModel();
			mav.addObject("channel_abroad_tuangou", info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> menuResult = chipService.queryInfo(null, null,"channel_abroad_con1");
			if(!menuResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo menu_info = menuResult.getModel();
			mav.addObject("channel_abroad_con1", menu_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> bannerResult = chipService.queryInfo(null, null,"channel_abroad_con2");
			if(!bannerResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo banner_info = bannerResult.getModel();
			mav.addObject("channel_abroad_con2", banner_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> msResult = chipService.queryInfo(null, null,"channel_abroad_con3");
			if(!msResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo ms_tag_info = msResult.getModel();
			mav.addObject("channel_abroad_con3", ms_tag_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> msIMGResult = chipService.queryInfo(null, null,"channel_abroad_con4");
			if(!msIMGResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo ms_IMGinfo = msIMGResult.getModel();
			mav.addObject("channel_abroad_con4", ms_IMGinfo.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> haiwaiResult = chipService.queryInfo(null, null,"channel_abroad_con5");
			if(!haiwaiResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo haiwai_info = haiwaiResult.getModel();
			mav.addObject("channel_abroad_con5", haiwai_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> guoneiResult = chipService.queryInfo(null, null,"channel_abroad_con6");
			if(!guoneiResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo guonei_info = guoneiResult.getModel();
			mav.addObject("channel_abroad_con6", guonei_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> zhoubianResult = chipService.queryInfo(null, null,"channel_abroad_con7");
			if(!zhoubianResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo zhoubian_info = zhoubianResult.getModel();
			mav.addObject("channel_abroad_con7", zhoubian_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> btmADResult = chipService.queryInfo(null, null,"channel_abroad_con8");
			if(!btmADResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo btm_ADinfo = btmADResult.getModel();
			mav.addObject("channel_abroad_con8", btm_ADinfo.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> cn9Result = chipService.queryInfo(null, null,"channel_abroad_con9");
			if(!cn9Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo con9Info = cn9Result.getModel();
			mav.addObject("channel_abroad_con9", con9Info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> cuxiaoResult = chipService.queryInfo(null, null,"channel_abroad_con10");
			if(!cuxiaoResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo cuxiao_info = cuxiaoResult.getModel();
			mav.addObject("channel_abroad_con10", cuxiao_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> topAbResult = chipService.queryInfo(null, null,"channel_abroad_hot");
			if(!topAbResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo top_ab_info = topAbResult.getModel();
			mav.addObject("channel_abroad_hot", top_ab_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> topDoResult = chipService.queryInfo(null, null,"channel_common_banner");
			if(!topDoResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo do_info = topDoResult.getModel();
			mav.addObject("channel_common_banner", do_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> topArResult = chipService.queryInfo(null, null,"channel_common_menu");
			if(!topArResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo top_AR_info = topArResult.getModel();
			mav.addObject("channel_common_menu", top_AR_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> aboutResult = chipService.queryInfo(null, null,"index_buttom_aboutus");
			if(!aboutResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo about_info = aboutResult.getModel();
			mav.addObject("index_buttom_aboutus", about_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con1Result = chipService.queryInfo(null, null,"channel_common_con1");
			if(!con1Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo friends_info = con1Result.getModel();
			mav.addObject("channel_common_con1", friends_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con2Result = chipService.queryInfo(null, null,"channel_common_con2");
			if(!con2Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo con2_info = con2Result.getModel();
			mav.addObject("channel_common_con2", con2_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con3Result = chipService.queryInfo(null, null,"channel_common_con3");
			if(!con3Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo con3_info = con3Result.getModel();
			mav.addObject("channel_common_con3", con3_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con4Result = chipService.queryInfo(null, null,"channel_common_con4");
			if(!con4Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo con4_info = con4Result.getModel();
			mav.addObject("channel_common_con4", con4_info.getChip_con());
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, "发生错误,请联系技术人员");
			return mav;
		}
		return mav;
	}
	
	/**
	 * 频道页_国内
	 * 
	 * */
	@RequestMapping(value="/channel_domestic",method=RequestMethod.GET)
	public ModelAndView toChannel_Domestic(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/channel_domestic");
		try{
			
			//获取common_buttom_ad碎片
			PublicResult<ChipInfo> comBtmADResult = chipService.queryInfo(null, null,"common_buttom_ad");
			if(!comBtmADResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo comBtmADinfo = comBtmADResult.getModel();
			mav.addObject("common_buttom_ad", comBtmADinfo.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> tuangouResult = chipService.queryInfo(null, null,"channel_domestic_tuangou");
			if(!tuangouResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo info = tuangouResult.getModel();
			mav.addObject("channel_domestic_tuangou", info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> menuResult = chipService.queryInfo(null, null,"channel_domestic_con1");
			if(!menuResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo menu_info = menuResult.getModel();
			mav.addObject("channel_domestic_con1", menu_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> bannerResult = chipService.queryInfo(null, null,"channel_domestic_con2");
			if(!bannerResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo banner_info = bannerResult.getModel();
			mav.addObject("channel_domestic_con2", banner_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> msResult = chipService.queryInfo(null, null,"channel_domestic_con3");
			if(!msResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo ms_tag_info = msResult.getModel();
			mav.addObject("channel_domestic_con3", ms_tag_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> msIMGResult = chipService.queryInfo(null, null,"channel_domestic_con4");
			if(!msIMGResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo ms_IMGinfo = msIMGResult.getModel();
			mav.addObject("channel_domestic_con4", ms_IMGinfo.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> haiwaiResult = chipService.queryInfo(null, null,"channel_domestic_con5");
			if(!haiwaiResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo haiwai_info = haiwaiResult.getModel();
			mav.addObject("channel_domestic_con5", haiwai_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> guoneiResult = chipService.queryInfo(null, null,"channel_domestic_con6");
			if(!guoneiResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo guonei_info = guoneiResult.getModel();
			mav.addObject("channel_domestic_con6", guonei_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> zhoubianResult = chipService.queryInfo(null, null,"channel_domestic_con7");
			if(!zhoubianResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo zhoubian_info = zhoubianResult.getModel();
			mav.addObject("channel_domestic_con7", zhoubian_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> btmADResult = chipService.queryInfo(null, null,"channel_domestic_con8");
			if(!btmADResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo btm_ADinfo = btmADResult.getModel();
			mav.addObject("channel_domestic_con8", btm_ADinfo.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> cn9Result = chipService.queryInfo(null, null,"channel_domestic_con9");
			if(!cn9Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo con9Info = cn9Result.getModel();
			mav.addObject("channel_domestic_con9", con9Info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> topAbResult = chipService.queryInfo(null, null,"channel_domestic_hot");
			if(!topAbResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo top_ab_info = topAbResult.getModel();
			mav.addObject("channel_domestic_hot", top_ab_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> topDoResult = chipService.queryInfo(null, null,"channel_common_banner");
			if(!topDoResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo do_info = topDoResult.getModel();
			mav.addObject("channel_common_banner", do_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> topArResult = chipService.queryInfo(null, null,"channel_common_menu");
			if(!topArResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo top_AR_info = topArResult.getModel();
			mav.addObject("channel_common_menu", top_AR_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> aboutResult = chipService.queryInfo(null, null,"index_buttom_aboutus");
			if(!aboutResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo about_info = aboutResult.getModel();
			mav.addObject("index_buttom_aboutus", about_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con1Result = chipService.queryInfo(null, null,"channel_common_con1");
			if(!con1Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo friends_info = con1Result.getModel();
			mav.addObject("channel_common_con1", friends_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con2Result = chipService.queryInfo(null, null,"channel_common_con2");
			if(!con2Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo con2_info = con2Result.getModel();
			mav.addObject("channel_common_con2", con2_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con3Result = chipService.queryInfo(null, null,"channel_common_con3");
			if(!con3Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo con3_info = con3Result.getModel();
			mav.addObject("channel_common_con3", con3_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con4Result = chipService.queryInfo(null, null,"channel_common_con4");
			if(!con4Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo con4_info = con4Result.getModel();
			mav.addObject("channel_common_con4", con4_info.getChip_con());
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, "发生错误,请联系技术人员");
			return mav;
		}
		return mav;
	}
	
	/**
	 * 频道页_周边
	 * 
	 * */
	@RequestMapping(value="/channel_around",method=RequestMethod.GET)
	public ModelAndView toChannel_Around(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/channel_around");
		try{
			
			//获取common_buttom_ad碎片
			PublicResult<ChipInfo> comBtmADResult = chipService.queryInfo(null, null,"common_buttom_ad");
			if(!comBtmADResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo comBtmADinfo = comBtmADResult.getModel();
			mav.addObject("common_buttom_ad", comBtmADinfo.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> tuangouResult = chipService.queryInfo(null, null,"channel_around_tuangou");
			if(!tuangouResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo info = tuangouResult.getModel();
			mav.addObject("channel_around_tuangou", info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> menuResult = chipService.queryInfo(null, null,"channel_around_con1");
			if(!menuResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo menu_info = menuResult.getModel();
			mav.addObject("channel_around_con1", menu_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> bannerResult = chipService.queryInfo(null, null,"channel_around_con2");
			if(!bannerResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo banner_info = bannerResult.getModel();
			mav.addObject("channel_around_con2", banner_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> msResult = chipService.queryInfo(null, null,"channel_around_con3");
			if(!msResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo ms_tag_info = msResult.getModel();
			mav.addObject("channel_around_con3", ms_tag_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> msIMGResult = chipService.queryInfo(null, null,"channel_around_con4");
			if(!msIMGResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo ms_IMGinfo = msIMGResult.getModel();
			mav.addObject("channel_around_con4", ms_IMGinfo.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> haiwaiResult = chipService.queryInfo(null, null,"channel_around_con5");
			if(!haiwaiResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo haiwai_info = haiwaiResult.getModel();
			mav.addObject("channel_around_con5", haiwai_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> guoneiResult = chipService.queryInfo(null, null,"channel_around_con6");
			if(!guoneiResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo guonei_info = guoneiResult.getModel();
			mav.addObject("channel_around_con6", guonei_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> zhoubianResult = chipService.queryInfo(null, null,"channel_around_con7");
			if(!zhoubianResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo zhoubian_info = zhoubianResult.getModel();
			mav.addObject("channel_around_con7", zhoubian_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> btmADResult = chipService.queryInfo(null, null,"channel_around_con8");
			if(!btmADResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo btm_ADinfo = btmADResult.getModel();
			mav.addObject("channel_around_con8", btm_ADinfo.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> topAbResult = chipService.queryInfo(null, null,"channel_around_hot");
			if(!topAbResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo top_ab_info = topAbResult.getModel();
			mav.addObject("channel_around_hot", top_ab_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> topDoResult = chipService.queryInfo(null, null,"channel_common_banner");
			if(!topDoResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo do_info = topDoResult.getModel();
			mav.addObject("channel_common_banner", do_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> topArResult = chipService.queryInfo(null, null,"channel_common_menu");
			if(!topArResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo top_AR_info = topArResult.getModel();
			mav.addObject("channel_common_menu", top_AR_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> aboutResult = chipService.queryInfo(null, null,"index_buttom_aboutus");
			if(!aboutResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo about_info = aboutResult.getModel();
			mav.addObject("index_buttom_aboutus", about_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con1Result = chipService.queryInfo(null, null,"channel_common_con1");
			if(!con1Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo friends_info = con1Result.getModel();
			mav.addObject("channel_common_con1", friends_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con2Result = chipService.queryInfo(null, null,"channel_common_con2");
			if(!con2Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo con2_info = con2Result.getModel();
			mav.addObject("channel_common_con2", con2_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con3Result = chipService.queryInfo(null, null,"channel_common_con3");
			if(!con3Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo con3_info = con3Result.getModel();
			mav.addObject("channel_common_con3", con3_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con4Result = chipService.queryInfo(null, null,"channel_common_con4");
			if(!con4Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo con4_info = con4Result.getModel();
			mav.addObject("channel_common_con4", con4_info.getChip_con());
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, "发生错误,请联系技术人员");
			return mav;
		}
		return mav;
	}
	
	/**
	 * 频道页_马尔代夫
	 * 
	 * */
	@RequestMapping(value="/channel_madai",method=RequestMethod.GET)
	public ModelAndView toChannel_Madai(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/channel_madai");
		try{
			
			//获取common_buttom_ad碎片
			PublicResult<ChipInfo> comBtmADResult = chipService.queryInfo(null, null,"common_buttom_ad");
			if(!comBtmADResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo comBtmADinfo = comBtmADResult.getModel();
			mav.addObject("common_buttom_ad", comBtmADinfo.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> tuangouResult = chipService.queryInfo(null, null,"channel_madai_tuangou");
			if(!tuangouResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo info = tuangouResult.getModel();
			mav.addObject("channel_madai_tuangou", info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> menuResult = chipService.queryInfo(null, null,"channel_madai_con1");
			if(!menuResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo menu_info = menuResult.getModel();
			mav.addObject("channel_madai_con1", menu_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> bannerResult = chipService.queryInfo(null, null,"channel_madai_con2");
			if(!bannerResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo banner_info = bannerResult.getModel();
			mav.addObject("channel_madai_con2", banner_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> msResult = chipService.queryInfo(null, null,"channel_madai_con3");
			if(!msResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo ms_tag_info = msResult.getModel();
			mav.addObject("channel_madai_con3", ms_tag_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> msIMGResult = chipService.queryInfo(null, null,"channel_madai_con4");
			if(!msIMGResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo ms_IMGinfo = msIMGResult.getModel();
			mav.addObject("channel_madai_con4", ms_IMGinfo.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> haiwaiResult = chipService.queryInfo(null, null,"channel_madai_con5");
			if(!haiwaiResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo haiwai_info = haiwaiResult.getModel();
			mav.addObject("channel_madai_con5", haiwai_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> guoneiResult = chipService.queryInfo(null, null,"channel_madai_con6");
			if(!guoneiResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo guonei_info = guoneiResult.getModel();
			mav.addObject("channel_madai_con6", guonei_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> zhoubianResult = chipService.queryInfo(null, null,"channel_madai_con7");
			if(!zhoubianResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo zhoubian_info = zhoubianResult.getModel();
			mav.addObject("channel_madai_con7", zhoubian_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> btmADResult = chipService.queryInfo(null, null,"channel_madai_con8");
			if(!btmADResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo btm_ADinfo = btmADResult.getModel();
			mav.addObject("channel_madai_con8", btm_ADinfo.getChip_con());
			
			
			//获取index_menu碎片
			PublicResult<ChipInfo> topAbResult = chipService.queryInfo(null, null,"channel_madai_hot");
			if(!topAbResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo top_ab_info = topAbResult.getModel();
			mav.addObject("channel_madai_hot", top_ab_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> topDoResult = chipService.queryInfo(null, null,"channel_common_banner");
			if(!topDoResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo do_info = topDoResult.getModel();
			mav.addObject("channel_common_banner", do_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> topArResult = chipService.queryInfo(null, null,"channel_common_menu");
			if(!topArResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo top_AR_info = topArResult.getModel();
			mav.addObject("channel_common_menu", top_AR_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con1Result = chipService.queryInfo(null, null,"channel_common_con1");
			if(!con1Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo friends_info = con1Result.getModel();
			mav.addObject("channel_common_con1", friends_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con2Result = chipService.queryInfo(null, null,"channel_common_con2");
			if(!con2Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo con2_info = con2Result.getModel();
			mav.addObject("channel_common_con2", con2_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con3Result = chipService.queryInfo(null, null,"channel_common_con3");
			if(!con3Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo con3_info = con3Result.getModel();
			mav.addObject("channel_common_con3", con3_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con4Result = chipService.queryInfo(null, null,"channel_common_con4");
			if(!con4Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo con4_info = con4Result.getModel();
			mav.addObject("channel_common_con4", con4_info.getChip_con());
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, "发生错误,请联系技术人员");
			return mav;
		}
		return mav;
	}
	
	/**
	 * 频道页_海岛
	 * 
	 * */
	@RequestMapping(value="/channel_island",method=RequestMethod.GET)
	public ModelAndView toChannel_Island(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/channel_island");
		try{
			
			//获取common_buttom_ad碎片
			PublicResult<ChipInfo> comBtmADResult = chipService.queryInfo(null, null,"common_buttom_ad");
			if(!comBtmADResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo comBtmADinfo = comBtmADResult.getModel();
			mav.addObject("common_buttom_ad", comBtmADinfo.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> tuangouResult = chipService.queryInfo(null, null,"channel_island_tuangou");
			if(!tuangouResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo info = tuangouResult.getModel();
			mav.addObject("channel_island_tuangou", info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> menuResult = chipService.queryInfo(null, null,"channel_island_con1");
			if(!menuResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo menu_info = menuResult.getModel();
			mav.addObject("channel_island_con1", menu_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> bannerResult = chipService.queryInfo(null, null,"channel_island_con2");
			if(!bannerResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo banner_info = bannerResult.getModel();
			mav.addObject("channel_island_con2", banner_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> msResult = chipService.queryInfo(null, null,"channel_island_con3");
			if(!msResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo ms_tag_info = msResult.getModel();
			mav.addObject("channel_island_con3", ms_tag_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> msIMGResult = chipService.queryInfo(null, null,"channel_island_con4");
			if(!msIMGResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo ms_IMGinfo = msIMGResult.getModel();
			mav.addObject("channel_island_con4", ms_IMGinfo.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> haiwaiResult = chipService.queryInfo(null, null,"channel_island_con5");
			if(!haiwaiResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo haiwai_info = haiwaiResult.getModel();
			mav.addObject("channel_island_con5", haiwai_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> guoneiResult = chipService.queryInfo(null, null,"channel_island_con6");
			if(!guoneiResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo guonei_info = guoneiResult.getModel();
			mav.addObject("channel_island_con6", guonei_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> zhoubianResult = chipService.queryInfo(null, null,"channel_island_con7");
			if(!zhoubianResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo zhoubian_info = zhoubianResult.getModel();
			mav.addObject("channel_island_con7", zhoubian_info.getChip_con());
			
			
			//获取index_menu碎片
			PublicResult<ChipInfo> topAbResult = chipService.queryInfo(null, null,"channel_island_hot");
			if(!topAbResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo top_ab_info = topAbResult.getModel();
			mav.addObject("channel_island_hot", top_ab_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> topDoResult = chipService.queryInfo(null, null,"channel_common_banner");
			if(!topDoResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo do_info = topDoResult.getModel();
			mav.addObject("channel_common_banner", do_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> topArResult = chipService.queryInfo(null, null,"channel_common_menu");
			if(!topArResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo top_AR_info = topArResult.getModel();
			mav.addObject("channel_common_menu", top_AR_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con1Result = chipService.queryInfo(null, null,"channel_common_con1");
			if(!con1Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo friends_info = con1Result.getModel();
			mav.addObject("channel_common_con1", friends_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con2Result = chipService.queryInfo(null, null,"channel_common_con2");
			if(!con2Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo con2_info = con2Result.getModel();
			mav.addObject("channel_common_con2", con2_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con3Result = chipService.queryInfo(null, null,"channel_common_con3");
			if(!con3Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo con3_info = con3Result.getModel();
			mav.addObject("channel_common_con3", con3_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con4Result = chipService.queryInfo(null, null,"channel_common_con4");
			if(!con4Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo con4_info = con4Result.getModel();
			mav.addObject("channel_common_con4", con4_info.getChip_con());
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, "发生错误,请联系技术人员");
			return mav;
		}
		return mav;
	}
	
	/**
	 * 频道页_自由行
	 * 
	 * */
	@RequestMapping(value="/channel_freedom",method=RequestMethod.GET)
	public ModelAndView toChannel_Freedom(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/channel_freedom");
		try{
			//获取common_buttom_ad碎片
			PublicResult<ChipInfo> comBtmADResult = chipService.queryInfo(null, null,"common_buttom_ad");
			if(!comBtmADResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo comBtmADinfo = comBtmADResult.getModel();
			mav.addObject("common_buttom_ad", comBtmADinfo.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> tuangouResult = chipService.queryInfo(null, null,"channel_freedom_tuangou");
			if(!tuangouResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo info = tuangouResult.getModel();
			mav.addObject("channel_freedom_tuangou", info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> menuResult = chipService.queryInfo(null, null,"channel_freedom_con1");
			if(!menuResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo menu_info = menuResult.getModel();
			mav.addObject("channel_freedom_con1", menu_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> bannerResult = chipService.queryInfo(null, null,"channel_freedom_con2");
			if(!bannerResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo banner_info = bannerResult.getModel();
			mav.addObject("channel_freedom_con2", banner_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> msResult = chipService.queryInfo(null, null,"channel_freedom_con3");
			if(!msResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo ms_tag_info = msResult.getModel();
			mav.addObject("channel_freedom_con3", ms_tag_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> msIMGResult = chipService.queryInfo(null, null,"channel_freedom_con4");
			if(!msIMGResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo ms_IMGinfo = msIMGResult.getModel();
			mav.addObject("channel_freedom_con4", ms_IMGinfo.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> haiwaiResult = chipService.queryInfo(null, null,"channel_freedom_con5");
			if(!haiwaiResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo haiwai_info = haiwaiResult.getModel();
			mav.addObject("channel_freedom_con5", haiwai_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> guoneiResult = chipService.queryInfo(null, null,"channel_freedom_con6");
			if(!guoneiResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo guonei_info = guoneiResult.getModel();
			mav.addObject("channel_freedom_con6", guonei_info.getChip_con());
			
			
			//获取index_menu碎片
			PublicResult<ChipInfo> topAbResult = chipService.queryInfo(null, null,"channel_freedom_hot");
			if(!topAbResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo top_ab_info = topAbResult.getModel();
			mav.addObject("channel_freedom_hot", top_ab_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> topDoResult = chipService.queryInfo(null, null,"channel_common_banner");
			if(!topDoResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo do_info = topDoResult.getModel();
			mav.addObject("channel_common_banner", do_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> topArResult = chipService.queryInfo(null, null,"channel_common_menu");
			if(!topArResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo top_AR_info = topArResult.getModel();
			mav.addObject("channel_common_menu", top_AR_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> aboutResult = chipService.queryInfo(null, null,"index_buttom_aboutus");
			if(!aboutResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo about_info = aboutResult.getModel();
			mav.addObject("index_buttom_aboutus", about_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con1Result = chipService.queryInfo(null, null,"channel_common_con1");
			if(!con1Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo friends_info = con1Result.getModel();
			mav.addObject("channel_common_con1", friends_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con2Result = chipService.queryInfo(null, null,"channel_common_con2");
			if(!con2Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo con2_info = con2Result.getModel();
			mav.addObject("channel_common_con2", con2_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con3Result = chipService.queryInfo(null, null,"channel_common_con3");
			if(!con3Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo con3_info = con3Result.getModel();
			mav.addObject("channel_common_con3", con3_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con4Result = chipService.queryInfo(null, null,"channel_common_con4");
			if(!con4Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo con4_info = con4Result.getModel();
			mav.addObject("channel_common_con4", con4_info.getChip_con());
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, "发生错误,请联系技术人员");
			return mav;
		}
		return mav;
	}
	
	/**
	 * 频道页_自由行
	 * 
	 * */
	@RequestMapping(value="/channel_beijing",method=RequestMethod.GET)
	public ModelAndView toChannel_Beijing(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/channel_beijing");
		try{
			//获取common_buttom_ad碎片
			PublicResult<ChipInfo> comBtmADResult = chipService.queryInfo(null, null,"common_buttom_ad");
			if(!comBtmADResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo comBtmADinfo = comBtmADResult.getModel();
			mav.addObject("common_buttom_ad", comBtmADinfo.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> tuangouResult = chipService.queryInfo(null, null,"channel_beijing_tuangou");
			if(!tuangouResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo info = tuangouResult.getModel();
			mav.addObject("channel_beijing_tuangou", info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> menuResult = chipService.queryInfo(null, null,"channel_beijing_con1");
			if(!menuResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo menu_info = menuResult.getModel();
			mav.addObject("channel_beijing_con1", menu_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> bannerResult = chipService.queryInfo(null, null,"channel_beijing_con2");
			if(!bannerResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo banner_info = bannerResult.getModel();
			mav.addObject("channel_beijing_con2", banner_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> msResult = chipService.queryInfo(null, null,"channel_beijing_con3");
			if(!msResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo ms_tag_info = msResult.getModel();
			mav.addObject("channel_beijing_con3", ms_tag_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> msIMGResult = chipService.queryInfo(null, null,"channel_beijing_con4");
			if(!msIMGResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo ms_IMGinfo = msIMGResult.getModel();
			mav.addObject("channel_beijing_con4", ms_IMGinfo.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> haiwaiResult = chipService.queryInfo(null, null,"channel_beijing_con5");
			if(!haiwaiResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo haiwai_info = haiwaiResult.getModel();
			mav.addObject("channel_beijing_con5", haiwai_info.getChip_con());
			
			
			//获取index_menu碎片
			PublicResult<ChipInfo> topAbResult = chipService.queryInfo(null, null,"channel_beijing_hot");
			if(!topAbResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo top_ab_info = topAbResult.getModel();
			mav.addObject("channel_beijing_hot", top_ab_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> topDoResult = chipService.queryInfo(null, null,"channel_common_banner");
			if(!topDoResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo do_info = topDoResult.getModel();
			mav.addObject("channel_common_banner", do_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> topArResult = chipService.queryInfo(null, null,"channel_common_menu");
			if(!topArResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo top_AR_info = topArResult.getModel();
			mav.addObject("channel_common_menu", top_AR_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> aboutResult = chipService.queryInfo(null, null,"index_buttom_aboutus");
			if(!aboutResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo about_info = aboutResult.getModel();
			mav.addObject("index_buttom_aboutus", about_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con1Result = chipService.queryInfo(null, null,"channel_common_con1");
			if(!con1Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo friends_info = con1Result.getModel();
			mav.addObject("channel_common_con1", friends_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con2Result = chipService.queryInfo(null, null,"channel_common_con2");
			if(!con2Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo con2_info = con2Result.getModel();
			mav.addObject("channel_common_con2", con2_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con3Result = chipService.queryInfo(null, null,"channel_common_con3");
			if(!con3Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo con3_info = con3Result.getModel();
			mav.addObject("channel_common_con3", con3_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con4Result = chipService.queryInfo(null, null,"channel_common_con4");
			if(!con4Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo con4_info = con4Result.getModel();
			mav.addObject("channel_common_con4", con4_info.getChip_con());
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, "发生错误,请联系技术人员");
			return mav;
		}
		return mav;
	}
	
	/**
	 * 频道页_自由行
	 * 
	 * */
	@RequestMapping(value="/channel_cruise",method=RequestMethod.GET)
	public ModelAndView toChannel_Cruise(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/channel_cruise");
		try{
			//获取common_buttom_ad碎片
			PublicResult<ChipInfo> comBtmADResult = chipService.queryInfo(null, null,"common_buttom_ad");
			if(!comBtmADResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo comBtmADinfo = comBtmADResult.getModel();
			mav.addObject("common_buttom_ad", comBtmADinfo.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> tuangouResult = chipService.queryInfo(null, null,"channel_cruise_tuangou");
			if(!tuangouResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo info = tuangouResult.getModel();
			mav.addObject("channel_cruise_tuangou", info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> menuResult = chipService.queryInfo(null, null,"channel_cruise_con1");
			if(!menuResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo menu_info = menuResult.getModel();
			mav.addObject("channel_cruise_con1", menu_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> bannerResult = chipService.queryInfo(null, null,"channel_cruise_con2");
			if(!bannerResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo banner_info = bannerResult.getModel();
			mav.addObject("channel_cruise_con2", banner_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> msResult = chipService.queryInfo(null, null,"channel_cruise_con3");
			if(!msResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo ms_tag_info = msResult.getModel();
			mav.addObject("channel_cruise_con3", ms_tag_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> msIMGResult = chipService.queryInfo(null, null,"channel_cruise_con4");
			if(!msIMGResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo ms_IMGinfo = msIMGResult.getModel();
			mav.addObject("channel_cruise_con4", ms_IMGinfo.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> haiwaiResult = chipService.queryInfo(null, null,"channel_cruise_con5");
			if(!haiwaiResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo haiwai_info = haiwaiResult.getModel();
			mav.addObject("channel_cruise_con5", haiwai_info.getChip_con());
			
			
			//获取index_menu碎片
			PublicResult<ChipInfo> topAbResult = chipService.queryInfo(null, null,"channel_cruise_hot");
			if(!topAbResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo top_ab_info = topAbResult.getModel();
			mav.addObject("channel_cruise_hot", top_ab_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> topDoResult = chipService.queryInfo(null, null,"channel_common_banner");
			if(!topDoResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo do_info = topDoResult.getModel();
			mav.addObject("channel_common_banner", do_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> topArResult = chipService.queryInfo(null, null,"channel_common_menu");
			if(!topArResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo top_AR_info = topArResult.getModel();
			mav.addObject("channel_common_menu", top_AR_info.getChip_con());
			
			//获取index_guide碎片
			PublicResult<ChipInfo> aboutResult = chipService.queryInfo(null, null,"index_buttom_aboutus");
			if(!aboutResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo about_info = aboutResult.getModel();
			mav.addObject("index_buttom_aboutus", about_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con1Result = chipService.queryInfo(null, null,"channel_common_con1");
			if(!con1Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo friends_info = con1Result.getModel();
			mav.addObject("channel_common_con1", friends_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con2Result = chipService.queryInfo(null, null,"channel_common_con2");
			if(!con2Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo con2_info = con2Result.getModel();
			mav.addObject("channel_common_con2", con2_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con3Result = chipService.queryInfo(null, null,"channel_common_con3");
			if(!con3Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo con3_info = con3Result.getModel();
			mav.addObject("channel_common_con3", con3_info.getChip_con());
			
			//获取index_menu碎片
			PublicResult<ChipInfo> con4Result = chipService.queryInfo(null, null,"channel_common_con4");
			if(!con4Result.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo con4_info = con4Result.getModel();
			mav.addObject("channel_common_con4", con4_info.getChip_con());
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage(), ex);
			mav.addObject(ERROR_MSG_KEY, "发生错误,请联系技术人员");
			return mav;
		}
		return mav;
	}
	
	/**
	 * 搜索页
	 * 
	 * */
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public ModelAndView search(@RequestParam(value = "p", required = false) Integer pageNo,
			@RequestParam(value = "search", required = false) String search){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/searchList");
		try{
			
			//获取common_buttom_ad碎片
			PublicResult<ChipInfo> rightTuangouResult = chipService.queryInfo(null, null,"search_right_tuangou");
			if(!rightTuangouResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo rightTuaninfo = rightTuangouResult.getModel();
			mav.addObject("search_right_tuangou", rightTuaninfo.getChip_con());
			
			//获取common_buttom_ad碎片
			PublicResult<ChipInfo> comBtmADResult = chipService.queryInfo(null, null,"common_buttom_ad");
			if(!comBtmADResult.isSuccess()){
				//检查改分类下是否有碎片
				mav.addObject(ERROR_MSG_KEY, "获取失败，请联系技术人员");
				mav.setViewName("/admin/doFail");
				return mav;
			}
			ChipInfo comBtmADinfo = comBtmADResult.getModel();
			mav.addObject("common_buttom_ad", comBtmADinfo.getChip_con());
			
			int pageSize=10;
			String pro_id=null;
			pageNo = pageNo==null?1:pageNo;
			int start = (pageNo - 1) * pageSize;
			int totalPage = 0;
			if(StringUtils.isNotBlank(search)){
				if(ValidateUtil.isNumeric(search)){
					pro_id = search;
					search = null;
				}else{
					search = URLDecoder.decode(search, "UTF-8");
				}
			}
			
			//浏览
			PublicResult<ProductInfo> result = productService.queryProductList(start, pageSize, null, null,pro_id,search);
			
			Page page = new Page(pageSize,result.getCount(),pageNo);
            totalPage = page.getTotalPage();
            mav.addObject("currentPage",pageNo);
            mav.addObject("pageSize",pageSize);
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
