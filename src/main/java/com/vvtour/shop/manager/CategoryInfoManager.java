package com.vvtour.shop.manager;

import java.util.List;

import com.vvtour.shop.entity.CategoryInfo;

public interface CategoryInfoManager {
	
	/**
	 * @param CategoryInfo
	 * @return
	 */
	public boolean addCategoryInfo(CategoryInfo info);
	
	/**
	 * @param adminInfo
	 * @return
	 */
	public boolean addCategoryInfoBatch(List<CategoryInfo> infoList);
	
	/**
	 * @return
	 */
	public boolean editCategoryInfo(CategoryInfo info);
	
	/**
	 * @return
	 */
	public boolean editCategoryName(String ca_id,String ca_name);
	
	/**
	 * @param ca_id,ca_name
	 * @return
	 */
	public CategoryInfo queryInfo(String ca_id,String ca_name,String parent_id);
	
	/**
	 * @param start
	 * @param max
	 * @return
	 */
	public List<CategoryInfo> queryCategoryInfoList(String ca_type,String parent_id,int start, int max);
	
	/**
	 * @return
	 */
	public long queryCategoryInfoCount(String ca_type,String parent_id);
	
	/**
	 * @param vparent_id
	 * @return
	 */
	public boolean deleteCategory(String ca_id);

}
