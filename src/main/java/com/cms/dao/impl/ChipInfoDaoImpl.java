package com.cms.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.cms.dao.ChipInfoDao;
import com.cms.entity.ChipCategory;
import com.cms.entity.ChipInfo;
import com.usual.dao.BaseDao;

public class ChipInfoDaoImpl extends BaseDao implements ChipInfoDao {

	@Override
	public ChipInfo queryInfo(Query query) {
		return (ChipInfo)queryOne(query,new ChipInfo());
	}

	@Override
	public void addInfo(ChipInfo info) {
		saveOne(info);
	}
	
	@Override
	public boolean updateInfo(Query query, Update update) {
		ChipInfo info = new ChipInfo();
		info = (ChipInfo)findAndModify(query, update, new ChipInfo());
		if(info!=null)return true;
		else return false;
	}

	@Override
	public boolean updateBatchInfo(Query query, Update update) {
		return updateBatch(query, update, new ChipInfo());
	}

	@Override
	public List<ChipInfo> queryInfoList(Query query) {
		return (List<ChipInfo>) queryList(query, new ChipInfo());
	}

	@Override
	public long queryCount(Query query) {
		return getCount(query, new ChipInfo());
	}

	@Override
	public boolean deleteInfo(Query query) {
		delOne(query,new ChipCategory());
		return true;
	}

	

}
