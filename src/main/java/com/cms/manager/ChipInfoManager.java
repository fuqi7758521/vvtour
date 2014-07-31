package com.cms.manager;

import java.util.List;

import com.cms.entity.ChipInfo;

public interface ChipInfoManager {

	/**
	 * @param info
	 * @return
	 */
	public boolean addInfo(ChipInfo info);
	
	/**
	 * @param albumId
	 * @return
	 */
	public boolean updateInfo(ChipInfo info);
	
	/**
	 * @param chip_id,chip_name
	 * @return
	 */
	public ChipInfo queryInfo(String chip_id,String chip_name,String chip_var);
	
	/**
	 * @param start
	 * @param max
	 * @return
	 */
	public List<ChipInfo> queryInfoList(int start, int max,String chip_ca_id);
	
	/**
	 * @return
	 */
	public long queryInfoCount(String chip_ca_id);
	
	/**
	 * @param albumId
	 * @return
	 */
	public boolean deleteInfo(String chip_id);
}
