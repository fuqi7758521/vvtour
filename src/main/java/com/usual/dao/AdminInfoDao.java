package com.usual.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.usual.entity.AdminInfo;

public interface AdminInfoDao {
	
	/**
	 * @param query
	 * @return
	 * 
	 */
	public AdminInfo queryUser(Query query);
	
	/**
	 * @param adminInfo
	 */
	public void addAdmin(AdminInfo adminInfo);
	
	/**
	 * @param query
	 * @param update
	 * @return
	 */
	public AdminInfo updateAdmin(Query query,Update update);
	
	/**
	 * @param query
	 * @param update
	 * @return
	 */
	public boolean updateBatchAdmin(Query query,Update update);
	
	/**
	 * @param query
	 * @return
	 * 
	 */
	public List<AdminInfo> queryUserList(Query query);
	
	/**
	 * @param query
	 * @return
	 */
	public long queryAdminInfoCount(Query query);

}
