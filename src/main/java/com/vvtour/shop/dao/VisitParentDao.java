package com.vvtour.shop.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.vvtour.shop.entity.VisitParent;
import com.vvtour.shop.entity.VisitTag;

public interface VisitParentDao {

	/**
	 * @param query
	 * @return
	 * 
	 */
	public VisitParent queryVisitParent(Query query);
	
	/**
	 * @param VisitParent
	 */
	public void addVisitParent(VisitParent info);
	
	/**
	 * @param VisitParent
	 */
	public void addVisitParentBatch(List<VisitParent> infoList);
	
	/**
	 * @param VisitTag
	 */
	public void addVisitTag(Query query, Update update,VisitParent info);
	
	/**
	 * @param VisitTag
	 */
	public boolean editVisitTag(Query query, Update update,VisitParent info);
	
	/**
	 * @param query
	 * @param update
	 * @return
	 */
	public VisitParent updateVisitParentCount(Query query,Update update);
	
	/**
	 * @param query
	 * @param update
	 * @return
	 */
	public boolean updateBatchVisitParent(Query query,Update update);
	
	/**
	 * @param query
	 * @return
	 * 
	 */
	public List<VisitParent> queryVisitParentList(Query query);
	
	/**
	 * @param query
	 * @return
	 */
	public long queryVisitParentCount(Query query);
	
	/**
	 * @param query
	 * @return
	 */
	public boolean deleteVisitParent(Query query);
	
	/**
	 * @param query
	 * @return
	 */
	public boolean deleteVisitTag(Query query, Update update,VisitParent info);
}
