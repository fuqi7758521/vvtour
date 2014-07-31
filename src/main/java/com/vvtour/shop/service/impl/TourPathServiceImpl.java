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
import com.vvtour.shop.entity.TourPath;
import com.vvtour.shop.manager.TourPathManager;
import com.vvtour.shop.service.TourPathService;

public class TourPathServiceImpl extends BaseService implements TourPathService {
	
	private final static Logger logger = Logger
			.getLogger(TourPathServiceImpl.class);
	
	@Autowired
	private TourPathManager tourPathManager;
	
	@Autowired
	private SystemIdManager systemIdManager;
	
	@Override
	public PublicResult<TourPath> encaTourPathList(String ca_id,String ca_name,List<String> nameList) {
		PublicResult<TourPath> result = new PublicResult<TourPath>(false);
		List<TourPath> infoList = new ArrayList<TourPath>();
		try {
			String path_id;
			for(String path_name : nameList){
				TourPath info = new TourPath();
				path_id = systemIdManager.getSystemId(IdTypeEnum.TOUR_PATH_ID);
				info.setCa_id(ca_id);
				info.setCa_name(ca_name);
				info.setPath_id(path_id);
				info.setPath_name(path_name);
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
	public PublicResult<Boolean> addTourPath(List<TourPath> infoList) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);
		if (infoList == null) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}
		try {
			boolean addResult = tourPathManager.addTourPathBatch(infoList);
			result.setModel(addResult);
			return succPublicResult(result);
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Boolean> updateTourPathName(String path_id,
			String path_name) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);
		try {
			boolean editResult = false;
			editResult = tourPathManager.editTourPath(path_id,path_name,null,null);
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
	public PublicResult<Boolean> updateVisit(String ca_id,
			String ca_name, String path_id) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);
		try {
			boolean editResult = false;
			editResult = tourPathManager.editTourPath(path_id,null,ca_id,ca_name);
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
	public PublicResult<TourPath> queryTourPath(String path_id, String path_name) {
		PublicResult<TourPath> result = new PublicResult<TourPath>(false);
		if (StringUtils.isBlank(path_id)&&StringUtils.isBlank(path_name)) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}

		try {
			TourPath info = tourPathManager.queryInfo(null,path_id, path_name);
			result.setModel(info);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}
	
	@Override
	public PublicResult<TourPath> queryTourPathExists(String ca_id,
			String path_name) {
		PublicResult<TourPath> result = new PublicResult<TourPath>(false);
		if (StringUtils.isBlank(path_name)) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}

		try {
			TourPath info = tourPathManager.queryInfo(ca_id,null, path_name);
			result.setModel(info);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<TourPath> queryTourPathList(String ca_id, int start,
			int max) {
		PublicResult<TourPath> result = new PublicResult<TourPath>(false);

		try {
			long count = tourPathManager.queryTourPathCount(ca_id);
			result.setCount(count);
			if (count > 0) {
				List<TourPath> albums = tourPathManager.queryTourPathList(ca_id, start, max);
				result.setModelList(albums);
			}
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Long> queryTourPathCount(String ca_id) {
		PublicResult<Long> result = new PublicResult<Long>(false);

		try {
			long count = tourPathManager.queryTourPathCount(ca_id);
			result.setModel(count);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Boolean> deletelTourPath(String path_id) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);
		try {
			boolean flag = tourPathManager.deltelTourPath(path_id);
			result.setModel(flag);
			return succPublicResult(result);
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

}
