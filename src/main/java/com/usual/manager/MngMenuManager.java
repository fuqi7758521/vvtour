package com.usual.manager;

import java.util.List;

import com.usual.entity.Authority;
import com.usual.entity.ManageMenu;

public interface MngMenuManager {
	
	/**
	 * @param query
	 * @return
	 * 
	 */
	public ManageMenu queryManageMenu(String menu_id);
	
	/**
	 * @param menu_cnname
	 * @return
	 */
	public boolean menuNameExist(String menu_cnname);
	
	/**
	 * @param mng_name
	 * @return
	 * 
	 */
	public boolean addManageMenu(ManageMenu menuInfo);
	
	/**
	 * @param menu_id,menu_cnname
	 */
	public boolean updateManageMenu(String menu_id,String menu_cnname);
	
	/**
	 * @param mngInfo
	 */
	public void addAuthority(String menu_id,Authority authInfo);
	
	/**
	 * @param query
	 * @param update
	 * @return
	 */
	public boolean updateAuthority(String menu_id,Authority authInfo);
	
	/**
	 * @return
	 */
	public long queryManageMenuCount();
	
	/**
	 * @param query
	 * @return
	 * 
	 */
	public List<ManageMenu> queryMngList(int start, int max);
	
	/**
	 * @param mng_id,auth_id
	 * @return
	 */
	public boolean deleteAuthByMngIdAndAuthId(String menu_id,String auth_id);

}
