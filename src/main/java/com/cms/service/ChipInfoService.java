package com.cms.service;

import com.cms.entity.ChipInfo;
import com.common.utils.PublicResult;

public interface ChipInfoService {

	/**
	 * @param ChipInfo
	 * @return
	 */
	public PublicResult<String> addInfo(ChipInfo info);
	
	/**
	 * @param ChipInfo
	 * @return
	 */
	public PublicResult<Boolean> updateInfo(ChipInfo info);
	
	/**
	 * 
	 * @param chip_id chip_name
	 * @return
	 */
	public PublicResult<ChipInfo> queryInfo(String chip_id,String chip_name,String chip_var);
	
	
	/**
	 * @param start
	 * @param max
	 * @return
	 */
	public PublicResult<ChipInfo> queryInfoList(int start, int max,String chip_ca_id);
	
	/**
	 * 
	 * @return
	 */
	public PublicResult<Long> queryCount(String chip_ca_id);
	
	/**
	 * @param chip_id
	 * @return
	 */
	public PublicResult<Boolean> deleteInfo(String chip_id);
}
