package com.vvtour.shop.service;

import java.util.List;

import com.common.utils.PublicResult;
import com.vvtour.shop.entity.VisitParent;
import com.vvtour.shop.entity.VisitTag;

public interface VisitParentService {
	


	/**
	 * @param VisitParent
	 * @return
	 */
	public PublicResult<String> addVisitParent(VisitParent info);
	
	/**
	 * @param infoList
	 * @return
	 */
	public PublicResult<Boolean> addVisitParentBatch(List<VisitParent> infoList);
	
	/**
	 * @param VisitTag
	 * @return
	 */
	public PublicResult<String> addVisitTag(String vparent_id,VisitTag tagInfo);
	
	/**
	 * @param VisitTag
	 * @return
	 */
	public PublicResult<Boolean> editVisitTag(String vparent_id,String visit_id,String visit_name);
	
	/**
	 * @param VisitTag
	 * @return
	 */
	public PublicResult<List<String>> addVisitTags(String vparent_id,List<String> list);
	
	/**
	 * @param VisitTag
	 * @return
	 */
	public PublicResult<VisitTag> addVisitTagList(String vparent_id,List<VisitTag> taglist);
	
	/**
	 * 
	 * @param vparent_id
	 * @return
	 */
	public PublicResult<VisitParent> queryVisitParentByVParentId(String vparent_id);
	
	
	/**
	 * @param vparent_name
	 * @return
	 */
	public PublicResult<VisitParent> queryVisitParentByVParentName(String vparent_name);
	
	/**
	 * 
	 * @param visit_id
	 * @return
	 */
	public PublicResult<VisitParent> queryVisitTagByVisitId(String vparent_id,String visit_id);
	
	
	/**
	 * @param visit_name
	 * @return
	 */
	public PublicResult<VisitParent> queryVisitTagByVisitName(String vparent_id,String visit_name);
	
	
	/**
	 * @param start
	 * @param max
	 * @return
	 */
	public PublicResult<VisitParent> queryVisitParentList(int start, int max);
	
	/**
	 * @param start
	 * @param max
	 * @return
	 */
	public PublicResult<VisitParent> encaVisitParentList(List<String> nameList,String vparent_type);
	
	/**
	 * 
	 * @return
	 */
	public PublicResult<Long> queryVParentCount();
	
	/**
	 * @param vparent_name
	 * @return
	 */
	public PublicResult<Boolean> deltelVisitParent(String vparent_id);
	
	/**
	 * @param vparent_id
	 * @param visit_id
	 * @return
	 */
	public PublicResult<Boolean> deltelVisitTag(String vparent_id,String visit_id);

}
