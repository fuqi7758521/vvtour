package com.cms.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.cms.entity.ChipInfo;
import com.cms.manager.ChipInfoManager;
import com.cms.service.ChipInfoService;
import com.common.utils.CodeEnum;
import com.common.utils.PublicResult;
import com.usual.manager.SystemIdManager;
import com.usual.service.BaseService;
import com.usual.utils.IdTypeEnum;

public class ChipInfoServiceImpl extends BaseService implements ChipInfoService {

	private final static Logger logger = Logger
			.getLogger(ChipInfoServiceImpl.class);
	
	@Autowired
	private ChipInfoManager chipManager;
	
	@Autowired
	private SystemIdManager systemIdManager;
	
	@Override
	public PublicResult<String> addInfo(ChipInfo info) {
		PublicResult<String> result = new PublicResult<String>(false);
		if (info == null) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}
		try {
			String chip_name = info.getChip_name();
			ChipInfo isExist = chipManager.queryInfo(null, chip_name,null);
			if (isExist!=null) {
				logger.error("ChipInfo Name is exist " + isExist.toString());
				return failPublicResult(result,
						CodeEnum.VALIDATE_DATA_EXIST.getCode());
			}
			String chip_id = systemIdManager.getSystemId(IdTypeEnum.CHIP_ID);
			info.setChip_id(chip_id);
			info.setChip_con_bak(info.getChip_con());
			boolean regResult = chipManager.addInfo(info);
			
			if(regResult){
				result.setModel(chip_id);
			}
			
			return succPublicResult(result);
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<ChipInfo> queryInfo(String chip_id, String chip_name,String chip_var) {
		PublicResult<ChipInfo> result = new PublicResult<ChipInfo>(false);

		try {
			ChipInfo info = chipManager.queryInfo(chip_id, chip_name,chip_var);
			result.setModel(info);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<ChipInfo> queryInfoList(int start, int max,String chip_ca_id) {
		PublicResult<ChipInfo> result = new PublicResult<ChipInfo>(false);

		try {

			long count = chipManager.queryInfoCount(chip_ca_id);
			result.setCount(count);
			if (count > 0) {
				List<ChipInfo> infos = chipManager.queryInfoList(start, max,chip_ca_id);
				result.setModelList(infos);
			}
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Long> queryCount(String chip_ca_id) {
		PublicResult<Long> result = new PublicResult<Long>(false);

		try {
			long count = chipManager.queryInfoCount(chip_ca_id);
			result.setModel(count);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Boolean> deleteInfo(String chip_id) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);
		try {
			boolean flag = chipManager.deleteInfo(chip_id);
			result.setModel(flag);
			return succPublicResult(result);
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Boolean> updateInfo(ChipInfo info) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);
		try {
			boolean editResult = false;
			editResult = chipManager.updateInfo(info);
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

}
