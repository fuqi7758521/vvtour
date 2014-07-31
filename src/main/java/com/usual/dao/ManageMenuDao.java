package com.usual.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.usual.entity.ManageMenu;

public interface ManageMenuDao {
	
	/**
	 * @param query
	 * @return
	 * 
	 */
	public ManageMenu queryManageMenu(Query query);
	
	/**
	 * @param menuInfo
	 */
	public void addManageMenu(ManageMenu menuInfo);
	
	/**
	 * @param menuInfo
	 */
	public void addAuthority(Query query, Update update);
	
	/**
	 * @param query
	 * @param update
	 * @return
	 */
	public ManageMenu updateManageMenu(Query query,Update update);
	
	/**
	 * @param query
	 * @return
	 */
	public long queryManageMenuCount(Query query);
	
	/**
	 * @param query
	 * @return
	 * 
	 */
	public List<ManageMenu> queryMngList(Query query);

}
