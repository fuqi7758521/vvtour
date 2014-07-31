package com.vvtour.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.common.utils.CodeEnum;
import com.common.utils.PublicResult;
import com.usual.manager.SystemIdManager;
import com.usual.service.BaseService;
import com.usual.utils.IdTypeEnum;
import com.vvtour.shop.entity.VisitParent;
import com.vvtour.shop.entity.VisitTag;
import com.vvtour.shop.manager.VisitParentManager;
import com.vvtour.shop.service.VisitParentService;

public class VisitParentServiceImpl extends BaseService implements
		VisitParentService {
	
	private final static Logger logger = Logger
			.getLogger(VisitParentServiceImpl.class);
	
	@Autowired
	private VisitParentManager vparentManager;
	
	@Autowired
	private SystemIdManager systemIdManager;
	
	@Override
	public PublicResult<VisitParent> queryVisitParentList(int start, int max) {
		PublicResult<VisitParent> result = new PublicResult<VisitParent>(false);

		try {

			long count = vparentManager.queryVisitParentCount();
			result.setCount(count);
			if (count > 0) {
				List<VisitParent> albums = vparentManager.queryVisitParentList(start, max);
				result.setModelList(albums);
			}
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}
	
	@Override
	public PublicResult<VisitParent> encaVisitParentList(List<String> nameList,String vparent_type){
		PublicResult<VisitParent> result = new PublicResult<VisitParent>(false);
		List<VisitParent> infoList = new ArrayList<VisitParent>();
		try {
			String vparent_id;
			for(String name : nameList){
				VisitParent info = new VisitParent();
				vparent_id = systemIdManager.getSystemId(IdTypeEnum.ADMIN_VISIT_PARENT_ID);
				info.setVparent_id(vparent_id);
				info.setVparent_name(name);
				info.setVparent_type(vparent_type);
				infoList.add(info);
			}
			result.setModelList(infoList);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<String> addVisitParent(VisitParent info) {
		PublicResult<String> result = new PublicResult<String>(false);
		if (info == null) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}
		try {
			String vparent_name = info.getVparent_name();
			VisitParent isExist = vparentManager.queryInfoByVParentName(vparent_name);
			if (isExist!=null) {
				logger.error("add VisitParentTag is exist " + isExist.toString());
				return failPublicResult(result,
						CodeEnum.VALIDATE_DATA_EXIST.getCode());
			}
			String vparent_id = systemIdManager.getSystemId(IdTypeEnum.ADMIN_VISIT_PARENT_ID);
			info.setVparent_id(vparent_id);
			boolean regResult = vparentManager.addVisitParent(info);
			
			if(regResult){
				result.setModel(vparent_id);
			}
			
			return succPublicResult(result);
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}
	
	@Override
	public PublicResult<Boolean> addVisitParentBatch(List<VisitParent> infoList) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);
		if (infoList == null) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}
		try {
			boolean addResult = vparentManager.addVisitParentBatch(infoList);
			result.setModel(addResult);
			return succPublicResult(result);
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<VisitParent> queryVisitParentByVParentId(
			String vparent_id) {
		PublicResult<VisitParent> result = new PublicResult<VisitParent>(false);
		if (StringUtils.isBlank(vparent_id)) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}

		try {
			VisitParent info = vparentManager.queryVParentNameByVParentId(vparent_id);
			result.setModel(info);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<VisitParent> queryVisitParentByVParentName(
			String vparent_name) {
		PublicResult<VisitParent> result = new PublicResult<VisitParent>(false);
		if (StringUtils.isBlank(vparent_name)) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}

		try {
			VisitParent info = vparentManager.queryInfoByVParentName(vparent_name);
			result.setModel(info);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}


	@Override
	public PublicResult<Long> queryVParentCount() {
		PublicResult<Long> result = new PublicResult<Long>(false);

		try {
			long count = vparentManager.queryVisitParentCount();
			result.setModel(count);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Boolean> deltelVisitParent(String vparent_id) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);
		try {
			boolean flag = vparentManager.deleteVParent(vparent_id);
			result.setModel(flag);
			return succPublicResult(result);
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<String> addVisitTag(String vparent_id,VisitTag tagInfo) {
		PublicResult<String> result = new PublicResult<String>(false);
		if (vparent_id == null) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}
		try {
			VisitParent info = new VisitParent();
			info.setVparent_id(vparent_id);
			String visit_id = systemIdManager.getSystemId(IdTypeEnum.ADMIN_VISIT_TAG_ID);
			tagInfo.setVisit_id(visit_id);
			boolean regResult = vparentManager.addVisitTag(info,tagInfo);
			
			if(regResult){
				result.setModel(visit_id);
			}
			
			return succPublicResult(result);
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}
	
	@Override
	public PublicResult<List<String>> addVisitTags(String vparent_id,
			List<String> list) {
		PublicResult<List<String>> result = new PublicResult<List<String>>(false);
		if (vparent_id == null) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}
		try {
			List<String> processList = new ArrayList<String>();
			VisitParent info = new VisitParent();
			info.setVparent_id(vparent_id);
			VisitTag tagInfo = new VisitTag();
			String visit_id;
			boolean regResult = false;
			for(String visit_name:list){
				visit_id = systemIdManager.getSystemId(IdTypeEnum.ADMIN_VISIT_TAG_ID);
				tagInfo.setVisit_id(visit_id);
				tagInfo.setVisit_name(visit_name);
				regResult = vparentManager.addVisitTag(info,tagInfo);
				processList.add(visit_name);
			}
			
			if(regResult){
				result.setModel(processList);
			}
			
			return succPublicResult(result);
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<VisitParent> queryVisitTagByVisitId(String vparent_id,String visit_id) {
		PublicResult<VisitParent> result = new PublicResult<VisitParent>(false);
		if (StringUtils.isBlank(visit_id)) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}

		try {
			VisitParent info = vparentManager.queryVisitNameByVisitId(vparent_id, visit_id);
			result.setModel(info);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<VisitParent> queryVisitTagByVisitName(String vparent_id,String visit_name) {
		PublicResult<VisitParent> result = new PublicResult<VisitParent>(false);
		if (StringUtils.isBlank(visit_name)) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}

		try {
			VisitParent info = vparentManager.queryVisitNameByVisitName(vparent_id, visit_name);
			result.setModel(info);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<VisitTag> addVisitTagList(String vparent_id,
			List<VisitTag> taglist) {
		PublicResult<VisitTag> result = new PublicResult<VisitTag>(false);
		if (taglist == null) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}
		try {
			VisitParent info = new VisitParent();
			info.setVparent_id(vparent_id);
			String visit_id = "";
			boolean addResult = false;
			List<VisitTag> list = new ArrayList<VisitTag>();
			for(VisitTag tagInfo:taglist){
				visit_id = systemIdManager.getSystemId(IdTypeEnum.ADMIN_VISIT_TAG_ID);
				tagInfo.setVisit_id(visit_id);
				addResult = vparentManager.addVisitTag(info,tagInfo);
				list.add(tagInfo);
			}
			if(addResult){
				result.setModelList(list);
			}
			
			return succPublicResult(result);
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Boolean> editVisitTag(String vparent_id,
			String visit_id, String visit_name) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);
		try {
			boolean editResult = false;
			editResult = vparentManager.editVisitParent(vparent_id, visit_id, visit_name);
			result.setModel(editResult);
			if(editResult){
				return succPublicResult(result);
			}
			return failPublicResult(result, CodeEnum.ERROR_OPERATE_FAIL.getCode());
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Boolean> deltelVisitTag(String vparent_id,
			String visit_id) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);
		try {
			boolean flag = vparentManager.deleteVisitTag(vparent_id, visit_id);
			result.setModel(flag);
			return succPublicResult(result);
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

}
