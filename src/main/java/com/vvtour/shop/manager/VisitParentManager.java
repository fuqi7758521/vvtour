package com.vvtour.shop.manager;

import java.util.List;

import com.vvtour.shop.entity.VisitParent;
import com.vvtour.shop.entity.VisitTag;


public interface VisitParentManager {

	/**
	 * @param adminInfo
	 * @return
	 */
	public boolean addVisitParent(VisitParent info);
	
	/**
	 * @param adminInfo
	 * @return
	 */
	public boolean addVisitParentBatch(List<VisitParent> infoList);
	
	/**
	 * @param vparent_id
	 * @param visit_id
	 * @param visit_name
	 * @return
	 */
	public boolean editVisitParent(String vparent_id,String visit_id,String visit_name);
	
	/**
	 * @param vparent_name
	 * @return
	 */
	public VisitParent queryInfoByVParentName(String vparent_name);
	
	/**
	 * @param vparent_id
	 * @return
	 */
	public VisitParent queryVParentNameByVParentId(String vparent_id);
	
	/**
	 * @param info
	 * @return
	 */
	public boolean addVisitTag(VisitParent info,VisitTag tagInfo);
	
	/**
	 * @param visit_name
	 * @return
	 */
	public VisitParent queryVisitNameByVisitName(String vparent_id,String visit_name);
	
	/**
	 * @param visit_id
	 * @return
	 */
	public VisitParent queryVisitNameByVisitId(String vparent_id,String visit_id);
	
	/**
	 * @param start
	 * @param max
	 * @return
	 */
	public List<VisitParent> queryVisitParentList(int start, int max);
	
	/**
	 * @return
	 */
	public long queryVisitParentCount();
	
	/**
	 * @param vparent_id
	 * @return
	 */
	public boolean deleteVParent(String vparent_id);

	/**
	 * @param vparent_id
	 * @param visit_id
	 * @return
	 */
	public boolean deleteVisitTag(String vparent_id,String visit_id);
}
