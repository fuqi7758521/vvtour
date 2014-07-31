package com.cms.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.cms.entity.ChipCategory;
import com.cms.manager.ChipCategoryManager;
import com.cms.service.ChipCategoryService;
import com.common.utils.CodeEnum;
import com.common.utils.PublicResult;
import com.usual.manager.SystemIdManager;
import com.usual.service.BaseService;
import com.usual.utils.IdTypeEnum;

public class ChipCategoryServiceImpl extends BaseService implements
		ChipCategoryService {
	
	private final static Logger logger = Logger
			.getLogger(ChipCategoryServiceImpl.class);
	
	@Autowired
	private ChipCategoryManager chipCaManager;
	
	@Autowired
	private SystemIdManager systemIdManager;

	@Override
	public PublicResult<String> addInfo(ChipCategory info) {
		PublicResult<String> result = new PublicResult<String>(false);
		if (info == null) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}
		try {
			String ca_name = info.getChip_ca_name();
			ChipCategory isExist = chipCaManager.queryInfo(null, ca_name);
			if (isExist!=null) {
				logger.error("ChipCategory Name is exist " + isExist.toString());
				return failPublicResult(result,
						CodeEnum.VALIDATE_DATA_EXIST.getCode());
			}
			String chip_ca_id = systemIdManager.getSystemId(IdTypeEnum.CHIP_CATEGORY_ID);
			info.setChip_ca_id(chip_ca_id);
			boolean regResult = chipCaManager.addInfo(info);
			
			if(regResult){
				result.setModel(chip_ca_id);
			}
			
			return succPublicResult(result);
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}
	
	@Override
	public PublicResult<Boolean> updateInfo(ChipCategory info) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);
		try {
			boolean editResult = false;
			editResult = chipCaManager.updateInfo(info);
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
	public PublicResult<ChipCategory> queryInfo(String ca_id, String ca_name) {
		PublicResult<ChipCategory> result = new PublicResult<ChipCategory>(false);

		try {
			ChipCategory info = chipCaManager.queryInfo(ca_id, ca_name);
			result.setModel(info);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<ChipCategory> queryInfoList(int start, int max) {
		PublicResult<ChipCategory> result = new PublicResult<ChipCategory>(false);

		try {

			long count = chipCaManager.queryInfoCount();
			result.setCount(count);
			if (count > 0) {
				List<ChipCategory> infos = chipCaManager.queryInfoList(start, max);
				result.setModelList(infos);
			}
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Long> queryCount() {
		PublicResult<Long> result = new PublicResult<Long>(false);

		try {
			long count = chipCaManager.queryInfoCount();
			result.setModel(count);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Boolean> deltelInfo(String ca_id) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);
		try {
			boolean flag = chipCaManager.deltelInfo(ca_id);
			result.setModel(flag);
			return succPublicResult(result);
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

}
