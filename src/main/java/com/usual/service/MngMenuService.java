package com.usual.service;

import com.common.utils.PublicResult;
import com.usual.entity.ManageMenu;

public interface MngMenuService {
	
	/**
	 * @param menuInfo
	 * @return
	 */
	public PublicResult<String> addManageMenu(ManageMenu menuInfo);
	
	/**
	 * @param menu_name
	 * @return
	 */
	public PublicResult<Boolean> checkMenuNameExist(String menu_name);
	
	/**
	 * @param menuId
	 * @return
	 */
	public PublicResult<Boolean> deleteAuthByMngIdAndAuthId(String menu_id,String auth_id);
	
	/**
	 * @param menuId,menu_name
	 * @return
	 */
	public PublicResult<Boolean> updateManageMenu(String menu_id,String menu_name);
	
	/**
	 * @param menu_id
	 * @return
	 */
	public PublicResult<ManageMenu> queryManageMenu(String menu_id);
	
	/**
	 * 
	 * @return
	 */
	public PublicResult<Long> queryManageMenuCount();
	
	/**
	 * @param start
	 * @param max
	 * @return
	 */
	public PublicResult<ManageMenu> queryManageMenuList(int start, int max);

}
