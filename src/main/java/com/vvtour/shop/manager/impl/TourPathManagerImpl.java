package com.vvtour.shop.manager.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.vvtour.shop.dao.TourPathDao;
import com.vvtour.shop.entity.TourPath;
import com.vvtour.shop.manager.TourPathManager;

public class TourPathManagerImpl implements TourPathManager {
	
	@Autowired
	private TourPathDao tourpathDao;
	
	class TourPathField{
		final static String PATHID = "path_id";
		
		final static String PATHNAME = "path_name";
		
		final static String CAID = "ca_id";
		
		final static String CANAME = "ca_name";
		
	}

	@Override
	public boolean addTourPath(TourPath info) {
		tourpathDao.addTourPath(info);
		return true;
	}
	
	@Override
	public boolean addTourPathBatch(List<TourPath> infoList) {
		tourpathDao.addTourPathBatch(infoList);
		return true;
	}

	@Override
	public boolean editTourPath(String path_id,String path_name,String ca_id,String ca_name) {
		Query query = new Query();
		Update update = new Update();
		query = query.addCriteria(Criteria.where(TourPathField.PATHID).is(path_id));
		if(StringUtils.isNotBlank(ca_id)){
			update.set(TourPathField.CAID, ca_id);
		}
		if(StringUtils.isNotBlank(ca_name)){
			update.set(TourPathField.CANAME, ca_name);
		}
		if(StringUtils.isNotBlank(path_name)){
			update.set(TourPathField.PATHNAME, path_name);
		}
		return tourpathDao.editTourPath(query, update);
	}

	@Override
	public TourPath queryInfo(String ca_id,String path_id,String path_name) {
		
		Query query = new Query();
		if(StringUtils.isNotBlank(ca_id)){
			query = query.addCriteria(Criteria.where(TourPathField.CAID).is(ca_id));
		}
		if(StringUtils.isNotBlank(path_id)){
			query = query.addCriteria(Criteria.where(TourPathField.PATHID).is(path_id));
		}
		if(StringUtils.isNotBlank(path_name)){
			query = query.addCriteria(Criteria.where(TourPathField.PATHNAME).is(path_name));
		}
		TourPath info = tourpathDao.queryTourPath(query);
		
		return info;
	}

	@Override
	public List<TourPath> queryTourPathList(String ca_id,int start, int max) {
		Query query = new Query();
		if(StringUtils.isNotBlank(ca_id)){
			query.addCriteria(Criteria.where(TourPathField.CAID).ne(ca_id));
		}
		if(max>0){
			query.skip(start);
			query.limit(max);
		}
		return tourpathDao.queryTourPathList(query);
	}

	@Override
	public long queryTourPathCount(String ca_id) {
		Query query = new Query();
		if(StringUtils.isNotBlank(ca_id)){
			query.addCriteria(Criteria.where(TourPathField.CAID).ne(ca_id));
		}
		return tourpathDao.queryTourPathCount(query);
	}

	@Override
	public boolean deltelTourPath(String path_id) {
		Query query = new Query();
		query.addCriteria(Criteria.where(TourPathField.PATHID).is(path_id));
		return tourpathDao.deleteTourPath(query);
	}

}
