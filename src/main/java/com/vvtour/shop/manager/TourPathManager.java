package com.vvtour.shop.manager;

import java.util.List;

import com.vvtour.shop.entity.TourPath;

public interface TourPathManager {
	
	/**
	 * @param TourPath info
	 * @return
	 */
	public boolean addTourPath(TourPath info);
	
	/**
	 * @param List<TourPath> infoList
	 * @return
	 */
	public boolean addTourPathBatch(List<TourPath> infoList);
	
	/**
	 * @param String path_id,String path_name,String ca_id,String ca_name
	 */
	public boolean editTourPath(String path_id,String path_name,
			String ca_id,String ca_name);
	
	/**
	 * @param ca_id,path_id,path_name
	 * @return
	 */
	public TourPath queryInfo(String ca_id,String path_id,String path_name);
	
	/**
	 * @param start
	 * @param max
	 * @return
	 */
	public List<TourPath> queryTourPathList(String ca_id,int start, int max);
	
	/**
	 * @return
	 */
	public long queryTourPathCount(String ca_id);
	
	/**
	 * @param path_id
	 * @return
	 */
	public boolean deltelTourPath(String path_id);

}
