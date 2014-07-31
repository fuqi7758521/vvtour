package com.vvtour.shop.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.usual.dao.BaseDao;
import com.vvtour.shop.dao.TourPathDao;
import com.vvtour.shop.entity.TourPath;

public class TourPathDaoImpl extends BaseDao implements TourPathDao {

	@Override
	public TourPath queryTourPath(Query query) {
		return (TourPath)queryOne(query,new TourPath());
	}

	@Override
	public void addTourPath(TourPath info) {
		saveOne(info);
	}

	@Override
	public void addTourPathBatch(List<TourPath> infoList) {
		saveBatch(infoList);
	}

	@Override
	public boolean editTourPath(Query query, Update update) {
		TourPath info = (TourPath) findAndModify(query, update, new TourPath());
		if(info!=null){
			return true;
		}
		return false;
	}

	@Override
	public List<TourPath> queryTourPathList(Query query) {
		return (List<TourPath>) queryList(query, new TourPath());
	}

	@Override
	public long queryTourPathCount(Query query) {
		return getCount(query, new TourPath());
	}

	@Override
	public boolean deleteTourPath(Query query) {
		delOne(query,new TourPath());
		return true;
	}

}
