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
import com.vvtour.shop.entity.CategoryInfo;
import com.vvtour.shop.entity.TourPath;
import com.vvtour.shop.manager.CategoryInfoManager;
import com.vvtour.shop.manager.TourPathManager;
import com.vvtour.shop.service.CategoryService;

public class CategoryServiceImpl extends BaseService implements CategoryService {

	private final static Logger logger = Logger
			.getLogger(CategoryServiceImpl.class);
	
	@Autowired
	private CategoryInfoManager categoryManager;
	
	@Autowired
	private SystemIdManager systemIdManager;
	
	@Override
	public PublicResult<CategoryInfo> encaCategoryInfoList(String ca_type,
			String parent_id,List<String> nameList) {
		PublicResult<CategoryInfo> result = new PublicResult<CategoryInfo>(false);
		List<CategoryInfo> infoList = new ArrayList<CategoryInfo>();
		try {
			String ca_id;
			for(String ca_name : nameList){
				CategoryInfo info = new CategoryInfo();
				ca_id = systemIdManager.getSystemId(IdTypeEnum.CATEGORY_ID);
				info.setCa_id(ca_id);
				info.setCa_name(ca_name);
				info.setIshas(false);
				info.setCa_type(ca_type);
				info.setParent_id(parent_id);
				info.setPro_num(0);
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
	public PublicResult<Boolean> addCategoryInfo(List<CategoryInfo> infoList) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);
		if (infoList == null) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}
		try {
			boolean addResult = categoryManager.addCategoryInfoBatch(infoList);
			result.setModel(addResult);
			return succPublicResult(result);
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Boolean> updateCategoryInfoName(String ca_id,
			String ca_name) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);
		try {
			boolean editResult = false;
			editResult = categoryManager.editCategoryName(ca_id, ca_name);
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
	public PublicResult<Boolean> updateVisit(String ca_id, String parent_id) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);
		try {
			boolean editResult = false;
			CategoryInfo info = new CategoryInfo();
			info.setCa_id(ca_id);
			info.setParent_id(parent_id);
			editResult = categoryManager.editCategoryInfo(info);
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
	public PublicResult<CategoryInfo> queryCategoryInfo(String ca_id,
			String ca_name) {
		PublicResult<CategoryInfo> result = new PublicResult<CategoryInfo>(false);
		if (StringUtils.isBlank(ca_id)||StringUtils.isBlank(ca_name)) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}

		try {
			CategoryInfo info = categoryManager.queryInfo(ca_id, ca_name,null);
			result.setModel(info);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<CategoryInfo> queryCategoryInfoExists(String parent_id,
			String ca_name) {
		PublicResult<CategoryInfo> result = new PublicResult<CategoryInfo>(false);
		if (StringUtils.isBlank(ca_name)) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}

		try {
			CategoryInfo info = new CategoryInfo();
			if(StringUtils.isNotBlank(parent_id)){
				info = categoryManager.queryInfo(null,ca_name,parent_id);
			}else{
				info = categoryManager.queryInfo(null,ca_name,null);
			}
			
			result.setModel(info);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<CategoryInfo> queryCategoryInfoList(String ca_type,String parent_id,
			int start, int max) {
		PublicResult<CategoryInfo> result = new PublicResult<CategoryInfo>(false);

		try {
			long count = categoryManager.queryCategoryInfoCount(ca_type,parent_id);
			result.setCount(count);
			if (count > 0) {
				List<CategoryInfo> albums = categoryManager.queryCategoryInfoList(ca_type,parent_id,start, max);
				result.setModelList(albums);
			}
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Long> queryCategoryInfoCount(String ca_type,String parent_id) {
		PublicResult<Long> result = new PublicResult<Long>(false);

		try {
			long count = categoryManager.queryCategoryInfoCount(ca_type,parent_id);
			result.setModel(count);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Boolean> deletelCategoryInfo(String ca_id) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);
		try {
			boolean flag = categoryManager.deleteCategory(ca_id);
			result.setModel(flag);
			return succPublicResult(result);
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

}
