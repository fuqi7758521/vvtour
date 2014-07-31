package com.vvtour.shop.service;

import java.util.List;

import com.common.utils.PublicResult;
import com.vvtour.shop.entity.TourPath;

public interface TourPathService {
	
	/**
	 * @param start
	 * @param max
	 * @return
	 */
	public PublicResult<TourPath> encaTourPathList(String ca_id,String ca_name,List<String> nameList);
	
	
	/**
	 * @param TourPath
	 * @return
	 */
	public PublicResult<Boolean> addTourPath(List<TourPath> info);
	
	/**
	 * @param path_id,path_name
	 * @return
	 */
	public PublicResult<Boolean> updateTourPathName(String path_id,String path_name);
	
	/**
	 * 将某个路线转移到某个目的地标签下
	 * @param ca_id,ca_name,path_id
	 * @return
	 */
	public PublicResult<Boolean> updateVisit(String ca_id,String ca_name,String path_id);
	
	/**
	 * 
	 * @param path_id,path_name
	 * @return
	 */
	public PublicResult<TourPath> queryTourPath(String path_id,String path_name);
	
	/**
	 * 
	 * @param ca_id,path_name
	 * @return
	 */
	public PublicResult<TourPath> queryTourPathExists(String ca_id,String path_name);
	
	
	/**
	 * @param ca_id
	 * @param start
	 * @param max
	 * @return
	 */
	public PublicResult<TourPath> queryTourPathList(String ca_id,int start, int max);
	
	/**
	 * @param ca_id
	 * @return
	 */
	public PublicResult<Long> queryTourPathCount(String ca_id);
	
	/**
	 * @param path_id
	 * @return
	 */
	public PublicResult<Boolean> deletelTourPath(String path_id);

}
