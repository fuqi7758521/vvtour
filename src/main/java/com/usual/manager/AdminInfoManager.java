package com.usual.manager;

import java.util.List;

import com.usual.entity.AdminInfo;

public interface AdminInfoManager {
	
	/**
	 * @param userName
	 * @return
	 */
	public boolean userNameExist(String userName);
	
	/**
	 * @param userId
	 * @return
	 */
	public boolean checkUserIdExist(String userId);
	
	/**
	 * @param userName
	 * @param password
	 * @return
	 */
	public AdminInfo userLogin(String userName, String password);
	
	/**
	 * @param adminInfo
	 * @return
	 */
	public boolean registAdminInfo(AdminInfo adminInfo);
	
	/**
	 * @param userName
	 * @return
	 */
	public AdminInfo queryAdminInfoByUserName(String userName);
	
	/**
	 * @param userId
	 * @return
	 */
	public AdminInfo queryAdminInfoByUserId(String userId);
	
	/**
	 * @param userId
	 * @param newPassword
	 * @return
	 */
	public boolean updateAdminPassword(String userId, String newPassword);
	
	/**
	 * @param start
	 * @param max
	 * @return
	 */
	public List<AdminInfo> queryAdminInfoList(int start, int max);
	
	/**
	 * @return
	 */
	public long queryAdminInfoCount();
	
	/**
	 * @param userId
	 * @param role
	 * @return
	 */
	public boolean updateUserStatus(String userId, int status);
	
	/**
	 * @param userIds
	 * @param status
	 * @return
	 */
	public boolean shieldOrDeltelUser(String [] userIds, int status);
	
	/**
	 * @param userId
	 * @param auths
	 * @param status
	 * @return
	 */
	public boolean updateAdminAuth(String userId,String [] auths, int status);
	
	/**
	 * @param userIds
	 * @return
	 */
	public List<AdminInfo> queryAdminInfosByUserIds(List<String> userIds);

}
