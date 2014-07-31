package com.vvtour.shop.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.usual.entity.AlbumInfo;
import com.vvtour.shop.entity.CategoryInfo;

public interface CategoryInfoDao {
	
	/**
	 * @param query
	 * @return
	 * 
	 */
	public CategoryInfo queryCategoryInfo(Query query);
	
	/**
	 * @param CategoryInfo
	 */
	public void addCategoryInfo(CategoryInfo info);
	
	/**
	 * @param CategoryInfo
	 */
	public void addCategoryInfoBatch(List<CategoryInfo> infoList);
	
	/**
	 * @param query
	 * @param update
	 * @return
	 */
	public boolean updateInfo(Query query,Update update);
	
	/**
	 * @param query
	 * @return
	 * 
	 */
	public List<CategoryInfo> queryCategoryInfoList(Query query);
	
	/**
	 * @param query
	 * @return
	 */
	public long queryCategoryInfoCount(Query query);
	
	/**
	 * @param query
	 * @return
	 */
	public boolean deleteCategoryInfo(Query query);
	
}
