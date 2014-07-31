package com.vvtour.shop.service;

import java.util.List;

import com.common.utils.PublicResult;
import com.vvtour.shop.entity.CategoryInfo;

public interface CategoryService {

	/**
	 * @param start
	 * @param max
	 * @return
	 */
	public PublicResult<CategoryInfo> encaCategoryInfoList(String ca_type,String parent_id,List<String> nameList);
	
	/**
	 * @param CategoryInfo
	 * @return
	 */
	public PublicResult<Boolean> addCategoryInfo(List<CategoryInfo> info);
	
	/**
	 * @param path_id,path_name
	 * @return
	 */
	public PublicResult<Boolean> updateCategoryInfoName(String ca_id,String ca_name);
	
	/**
	 * 将某个路线转移到某个目的地标签下
	 * @param ca_id,parent_id
	 * @return
	 */
	public PublicResult<Boolean> updateVisit(String ca_id,String parent_id);
	
	/**
	 * 
	 * @param ca_id,ca_name
	 * @return
	 */
	public PublicResult<CategoryInfo> queryCategoryInfo(String ca_id,String ca_name);
	
	/**
	 * 
	 * @param parent_id,ca_name
	 * @return
	 */
	public PublicResult<CategoryInfo> queryCategoryInfoExists(String parent_id,String ca_name);
	
	
	/**
	 * @param parent_id
	 * @param start
	 * @param max
	 * @return
	 */
	public PublicResult<CategoryInfo> queryCategoryInfoList(String ca_type,String parent_id,int start, int max);
	
	/**
	 * @param visit_id
	 * @return
	 */
	public PublicResult<Long> queryCategoryInfoCount(String ca_type,String parent_id);
	
	/**
	 * @param ca_id
	 * @return
	 */
	public PublicResult<Boolean> deletelCategoryInfo(String ca_id);
}
