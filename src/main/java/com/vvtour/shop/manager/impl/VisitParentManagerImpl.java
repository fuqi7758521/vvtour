package com.vvtour.shop.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.vvtour.shop.dao.VisitParentDao;
import com.vvtour.shop.entity.VisitParent;
import com.vvtour.shop.entity.VisitTag;
import com.vvtour.shop.manager.VisitParentManager;

public class VisitParentManagerImpl implements VisitParentManager {
	
	@Autowired
	private VisitParentDao visitParentDao;
	
	class VisitParentField{
		final static String VPARENTID = "vparent_id";
		
		final static String VPARENTNAME = "vparent_name";
		
		final static String VISITTAG = "visit_tag";
		
		final static String VISITID = "visit_id";
		
		final static String VISITNAME = "visit_name";
		
	}

	@Override
	public boolean addVisitParent(VisitParent info) {
		visitParentDao.addVisitParent(info);
		return true;
	}
	
	@Override
	public boolean addVisitParentBatch(List<VisitParent> infoList) {
		visitParentDao.addVisitParentBatch(infoList);
		return true;
	}

	@Override
	public VisitParent queryInfoByVParentName(String vparent_name) {
		Query query = Query.query(Criteria.where(VisitParentField.VPARENTNAME).is(vparent_name));
		VisitParent info = visitParentDao.queryVisitParent(query);
		
		return info;
	}

	@Override
	public VisitParent queryVParentNameByVParentId(String vparent_id) {
		Query query = Query.query(Criteria.where(VisitParentField.VPARENTID).is(vparent_id));
		VisitParent info = visitParentDao.queryVisitParent(query);
		
		return info;
	}

	@Override
	public List<VisitParent> queryVisitParentList(int start, int max) {
		Query query = Query.query(Criteria.where(VisitParentField.VPARENTID).ne(null));
		if(max>0){
			query.skip(start);
			query.limit(max);
		}
		return visitParentDao.queryVisitParentList(query);
	}

	@Override
	public long queryVisitParentCount() {
		Query query = Query.query(Criteria.where(VisitParentField.VPARENTID).ne(null));
		
		return visitParentDao.queryVisitParentCount(query);
	}

	@Override
	public boolean deleteVParent(String vparent_id) {
		Query query = Query.query(Criteria.where(VisitParentField.VPARENTID).is(vparent_id));
		return visitParentDao.deleteVisitParent(query);
	}

	@Override
	public boolean addVisitTag(VisitParent info,VisitTag tagInfo) {
		Query query = Query.query(Criteria.where(VisitParentField.VPARENTID).is(info.getVparent_id()));
		Update update = new Update();
		update.addToSet("visit_tag", tagInfo);
		visitParentDao.addVisitTag(query, update, info);
		return true;
	}

	@Override
	public VisitParent queryVisitNameByVisitName(String vparent_id,String visit_name) {
		Query query = Query.query(Criteria.where(VisitParentField.VPARENTID).is(vparent_id).and("visit_tag.visit_name").is(visit_name));
		VisitParent info = visitParentDao.queryVisitParent(query);
		return info;
	}

	@Override
	public VisitParent queryVisitNameByVisitId(String vparent_id,String visit_id) {
		Query query = Query.query(Criteria.where(VisitParentField.VPARENTID).is(vparent_id).and("visit_tag.visit_id").is(visit_id));
		VisitParent info = visitParentDao.queryVisitParent(query);
		return info;
	}

	@Override
	public boolean editVisitParent(String vparent_id, String visit_id,
			String visit_name) {
		Query query = Query.query(Criteria.where(VisitParentField.VPARENTID).is(vparent_id).and("visit_tag.visit_id").is(visit_id));
		Update update = new Update();
		update.set("visit_tag.$.visit_name", visit_name);
		return visitParentDao.editVisitTag(query, update, new VisitParent());
	}


	@Override
	public boolean deleteVisitTag(String vparent_id, String visit_id) {
		Query query = Query.query(Criteria.where(VisitParentField.VPARENTID).is(vparent_id).and("visit_tag.visit_id").is(visit_id));
		Update update = new Update();
        update.unset("visit_tag.$");
		return visitParentDao.deleteVisitTag(query, update, new VisitParent());
	}

}
