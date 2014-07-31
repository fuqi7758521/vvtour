package com.cms.service;

import com.cms.entity.ChipCategory;
import com.common.utils.PublicResult;

public interface ChipCategoryService {

	/**
	 * @param ChipCategory
	 * @return
	 */
	public PublicResult<String> addInfo(ChipCategory info);
	
	/**
	 * @param ChipCategory
	 * @return
	 */
	public PublicResult<Boolean> updateInfo(ChipCategory info);
	
	/**
	 * 
	 * @param ca_id ca_name
	 * @return
	 */
	public PublicResult<ChipCategory> queryInfo(String chip_ca_id,String chip_ca_name);
	
	
	/**
	 * @param start
	 * @param max
	 * @return
	 */
	public PublicResult<ChipCategory> queryInfoList(int start, int max);
	
	/**
	 * 
	 * @return
	 */
	public PublicResult<Long> queryCount();
	
	/**
	 * @param ca_id
	 * @return
	 */
	public PublicResult<Boolean> deltelInfo(String ca_id);
}
