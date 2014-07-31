package com.usual.service;

import java.util.List;

import com.common.utils.PublicResult;
import com.usual.entity.AdminInfo;

public interface AdminInfoService {


	/**
	 * @param adminInfo
	 * @return
	 */
	public PublicResult<String> registAdmin(AdminInfo adminInfo);
	
	/**
	 * @param userName
	 * @return
	 */
	public PublicResult<Boolean> userNameExist(String userName);
	
	/**
	 * @param userId,auth[],status
	 * @return
	 */
	public PublicResult<Boolean> updateAdminAuth(String userId,String[] auths,int status);
	
	/**
	 * @param userName
	 * @param password
	 * @return
	 */
	public PublicResult<AdminInfo> userLogin(String userName, String password);
	
	/**
	 * @param userName
	 * @return
	 */
	public PublicResult<AdminInfo> queryAdminInfoByUserName(String userName);
	
	/**
	 * @param userId
	 * @param newPassword
	 * @return
	 */
	public PublicResult<Boolean> updateAdminPassword(String userId, String newPassword);
	
	/**
	 * @param start
	 * @param max
	 * @return
	 */
	public PublicResult<AdminInfo> queryAdminInfoList(int start, int max);
	
	/**
	 * @param userId
	 * @param role
	 * @return
	 */
	public PublicResult<Boolean> updateAdminInfoStatus(String userId, int status);
	
	/**
	 * @param userIds
	 * @param status
	 * @return
	 */
	public PublicResult<Boolean> updateAdminStatus(String [] userIds, int status);
	
	/**
	 * @param userIds
	 * @return
	 */
	public PublicResult<AdminInfo> getAdminInfosByUserIds(List<String> userIds);
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public PublicResult<AdminInfo> getAdminInfoByUserId(String userId);
	
	
	/**
	 * 
	 * @return
	 */
	public PublicResult<Long> queryAdminCount();
}
