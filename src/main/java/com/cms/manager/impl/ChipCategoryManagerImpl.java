package com.cms.manager.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.cms.dao.ChipCategoryDao;
import com.cms.entity.ChipCategory;
import com.cms.manager.ChipCategoryManager;
import com.cms.manager.impl.ChipInfoManagerImpl.ChipInfoField;

public class ChipCategoryManagerImpl implements ChipCategoryManager {

	@Autowired
	private ChipCategoryDao  chipCaDao;
	
	class ChipCaField{
		final static String CHIPCAID = "chip_ca_id";
		
		final static String CHIPCANAME = "chip_ca_name";
		
		final static String PAGEURL = "page_url";
		
	}
	
	@Override
	public boolean addInfo(ChipCategory info) {
		chipCaDao.addInfo(info);
		return true;
	}

	@Override
	public ChipCategory queryInfo(String ca_id, String ca_name) {
		Query query = new Query();
		
		if(StringUtils.isNotBlank(ca_id)){
			query.addCriteria(Criteria.where(ChipCaField.CHIPCAID).is(ca_id));
		}
		if(StringUtils.isNotBlank(ca_name)){
			query.addCriteria(Criteria.where(ChipCaField.CHIPCANAME).is(ca_name));
		}
		ChipCategory info = chipCaDao.queryInfo(query);
		return info;
	}

	@Override
	public List<ChipCategory> queryInfoList(int start, int max) {
		Query query = new Query();
		if(max>0){
			query.skip(start);
			query.limit(max);
		}
		return chipCaDao.queryInfoList(query);
	}

	@Override
	public long queryInfoCount() {
		Query query = new Query();
		return chipCaDao.queryChipInfoCount(query);
	}

	@Override
	public boolean deltelInfo(String ca_id) {
		Query query = Query.query(Criteria.where(ChipCaField.CHIPCAID).is(ca_id));
		return chipCaDao.deleteInfo(query);
	}

	@Override
	public boolean updateInfo(ChipCategory info) {
		Query query = new Query();
		Update update = new Update();
		query = query.addCriteria(Criteria.where(ChipCaField.CHIPCAID).is(info.getChip_ca_id()));
		if(StringUtils.isNotBlank(info.getChip_ca_id())){
			update.set(ChipCaField.CHIPCAID, info.getChip_ca_id());
		}
		if(StringUtils.isNotBlank(info.getChip_ca_name())){
			update.set(ChipCaField.CHIPCANAME, info.getChip_ca_name());
		}
		if(StringUtils.isNotBlank(info.getPage_url())){
			update.set(ChipCaField.PAGEURL, info.getPage_url());
		}
		return chipCaDao.updateInfo(query, update);
	}

}
