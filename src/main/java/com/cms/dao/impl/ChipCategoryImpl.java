package com.cms.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.cms.dao.ChipCategoryDao;
import com.cms.entity.ChipCategory;
import com.usual.dao.BaseDao;

public class ChipCategoryImpl extends BaseDao implements ChipCategoryDao {

	@Override
	public ChipCategory queryInfo(Query query) {
		return (ChipCategory)queryOne(query,new ChipCategory());
	}

	@Override
	public void addInfo(ChipCategory info) {
		saveOne(info);
	}

	@Override
	public boolean updateBatchInfo(Query query, Update update) {
		return updateBatch(query, update, new ChipCategory());
	}

	@Override
	public List<ChipCategory> queryInfoList(Query query) {
		return (List<ChipCategory>) queryList(query, new ChipCategory());
	}

	@Override
	public long queryChipInfoCount(Query query) {
		return getCount(query, new ChipCategory());
	}

	@Override
	public boolean deleteInfo(Query query) {
		delOne(query,new ChipCategory());
		return true;
	}

	@Override
	public boolean updateInfo(Query query, Update update) {
		ChipCategory info = new ChipCategory();
		info = (ChipCategory)findAndModify(query, update, new ChipCategory());
		if(info!=null)return true;
		else return false;
	}


}
