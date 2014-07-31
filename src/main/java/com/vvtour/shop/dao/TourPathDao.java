package com.vvtour.shop.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.vvtour.shop.entity.TourPath;

public interface TourPathDao {

	/**
	 * @param query
	 * @return
	 * 
	 */
	public TourPath queryTourPath(Query query);
	
	/**
	 * @param TourPath
	 */
	public void addTourPath(TourPath info);
	
	/**
	 * @param TourPath
	 */
	public void addTourPathBatch(List<TourPath> infoList);
	
	/**
	 * @param TourPath
	 */
	public boolean editTourPath(Query query, Update update);
	
	/**
	 * @param query
	 * @return
	 * 
	 */
	public List<TourPath> queryTourPathList(Query query);
	
	/**
	 * @param query
	 * @return
	 */
	public long queryTourPathCount(Query query);
	
	/**
	 * @param query
	 * @return
	 */
	public boolean deleteTourPath(Query query);
	
}
