package com.vvtour.shop.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.usual.dao.BaseDao;
import com.vvtour.shop.dao.VisitParentDao;
import com.vvtour.shop.entity.VisitParent;
import com.vvtour.shop.entity.VisitTag;

public class VisitParentDaoImpl extends BaseDao implements VisitParentDao {

	@Override
	public VisitParent queryVisitParent(Query query) {
		return (VisitParent)queryOne(query,new VisitParent());
	}

	@Override
	public void addVisitParent(VisitParent info) {
		saveOne(info);
	}
	
	@Override
	public void addVisitParentBatch(List<VisitParent> infoList) {
		saveBatch(infoList);
	}
	
	@Override
	public void addVisitTag(Query query, Update update,VisitParent info) {
		saveInnerObjOne(query,update,info);
	}

	@Override
	public VisitParent updateVisitParentCount(Query query, Update update) {
		return (VisitParent) findAndModify(query, update, new VisitParent());
	}

	@Override
	public boolean updateBatchVisitParent(Query query, Update update) {
		return updateBatch(query, update, new VisitParent());
	}

	@Override
	public List<VisitParent> queryVisitParentList(Query query) {
		return (List<VisitParent>) queryList(query, new VisitParent());
	}

	@Override
	public long queryVisitParentCount(Query query) {
		return getCount(query, new VisitParent());
	}

	@Override
	public boolean deleteVisitParent(Query query) {
		delOne(query,new VisitParent());
		return true;
	}

	@Override
	public boolean editVisitTag(Query query, Update update, VisitParent info) {
		return updateInnerObjOne(query, update, info);
	}

	@Override
	public boolean deleteVisitTag(Query query, Update update, VisitParent info) {
		// TODO Auto-generated method stub
		return updateInnerObjOne(query, update, info);
	}

}
