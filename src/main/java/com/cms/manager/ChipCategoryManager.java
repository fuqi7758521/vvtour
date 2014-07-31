package com.cms.manager;

import java.util.List;

import com.cms.entity.ChipCategory;


public interface ChipCategoryManager {

	/**
	 * @param info
	 * @return
	 */
	public boolean addInfo(ChipCategory info);
	
	/**
	 * @param info
	 * @return
	 */
	public boolean updateInfo(ChipCategory info);
	
	/**
	 * @param albumName
	 * @return
	 */
	public ChipCategory queryInfo(String ca_id,String ca_name);
	
	/**
	 * @param start
	 * @param max
	 * @return
	 */
	public List<ChipCategory> queryInfoList(int start, int max);
	
	/**
	 * @return
	 */
	public long queryInfoCount();
	
	/**
	 * @param albumId
	 * @return
	 */
	public boolean deltelInfo(String ca_id);
}
