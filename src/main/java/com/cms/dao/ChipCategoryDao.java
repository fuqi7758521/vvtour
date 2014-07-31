package com.cms.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.cms.entity.ChipCategory;

public interface ChipCategoryDao {

	/**
	 * @param query
	 * @return
	 * 
	 */
	public ChipCategory queryInfo(Query query);
	
	/**
	 * @param ChipCategory
	 */
	public void addInfo(ChipCategory info);
	
	/**
	 * @param ChipCategory
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
	public List<ChipCategory> queryInfoList(Query query);
	
	/**
	 * @param query
	 * @return
	 */
	public long queryChipInfoCount(Query query);
	
	/**
	 * @param query
	 * @return
	 */
	public boolean deleteInfo(Query query);
}
