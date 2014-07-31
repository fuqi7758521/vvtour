package com.cms.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.cms.entity.ChipInfo;

public interface ChipInfoDao {

	/**
	 * @param query
	 * @return
	 * 
	 */
	public ChipInfo queryInfo(Query query);
	
	/**
	 * @param ChipInfo
	 */
	public void addInfo(ChipInfo info);
	
	/**
	 * @param ChipInfo
	 */
	public boolean updateInfo(Query query, Update update);
	
	/**
	 * @param query
	 * @param update
	 * @return
	 */
	public boolean updateBatchInfo(Query query,Update update);
	
	/**
	 * @param query
	 * @return
	 * 
	 */
	public List<ChipInfo> queryInfoList(Query query);
	
	/**
	 * @param query
	 * @return
	 */
	public long queryCount(Query query);
	
	/**
	 * @param query
	 * @return
	 */
	public boolean deleteInfo(Query query);
}
