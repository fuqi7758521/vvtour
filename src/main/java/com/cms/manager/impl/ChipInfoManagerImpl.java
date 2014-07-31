package com.cms.manager.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.cms.dao.ChipInfoDao;
import com.cms.entity.ChipInfo;
import com.cms.manager.ChipInfoManager;

public class ChipInfoManagerImpl implements ChipInfoManager {

	@Autowired
	private ChipInfoDao  chipDao;
	
	class ChipInfoField{
		final static String CHIPCAID = "chip_ca_id";
		
		final static String CHIPID = "chip_id";
		
		final static String CHIPVAR = "chip_var";
		
		final static String CHIPNAME = "chip_name";
		
		final static String CHIPCON = "chip_con";
		
		final static String CHIPCONBAK = "chip_con_bak";
		
	}
	
	@Override
	public boolean addInfo(ChipInfo info) {
		chipDao.addInfo(info);
		return true;
	}

	@Override
	public ChipInfo queryInfo(String chip_id, String chip_name,String chip_var) {
		Query query = new Query();
		
		if(StringUtils.isNotBlank(chip_id)){
			query.addCriteria(Criteria.where(ChipInfoField.CHIPID).is(chip_id));
		}
		if(StringUtils.isNotBlank(chip_name)){
			query.addCriteria(Criteria.where(ChipInfoField.CHIPNAME).is(chip_name));
		}
		if(StringUtils.isNotBlank(chip_var)){
			query.addCriteria(Criteria.where(ChipInfoField.CHIPVAR).is(chip_var));
		}
		ChipInfo info = chipDao.queryInfo(query);
		return info;
	}

	@Override
	public List<ChipInfo> queryInfoList(int start, int max, String chip_ca_id) {
		Query query = new Query();
		if(StringUtils.isNotBlank(chip_ca_id)){
			query.addCriteria(Criteria.where(ChipInfoField.CHIPCAID).is(chip_ca_id));
		}
		if(max>0){
			query.skip(start);
			query.limit(max);
		}
		return chipDao.queryInfoList(query);
	}

	@Override
	public long queryInfoCount(String chip_ca_id) {
		Query query = new Query();
		if(StringUtils.isNotBlank(chip_ca_id)){
			query = query.addCriteria(Criteria.where(ChipInfoField.CHIPCAID).is(chip_ca_id));
		}
		return chipDao.queryCount(query);
	}


	@Override
	public boolean updateInfo(ChipInfo info) {
		Query query = new Query();
		Update update = new Update();
		query = query.addCriteria(Criteria.where(ChipInfoField.CHIPID).is(info.getChip_id()));
		if(StringUtils.isNotBlank(info.getChip_ca_id())){
			update.set(ChipInfoField.CHIPCAID, info.getChip_ca_id());
		}
		if(StringUtils.isNotBlank(info.getChip_name())){
			update.set(ChipInfoField.CHIPNAME, info.getChip_name());
		}
		if(StringUtils.isNotBlank(info.getChip_con())){
			update.set(ChipInfoField.CHIPCON, info.getChip_con());
		}
		if(StringUtils.isNotBlank(info.getChip_var())){
			update.set(ChipInfoField.CHIPVAR, info.getChip_var());
		}
		return chipDao.updateInfo(query, update);
	}

	@Override
	public boolean deleteInfo(String chip_id) {
		Query query = Query.query(Criteria.where(ChipInfoField.CHIPID).is(chip_id));
		return chipDao.deleteInfo(query);
	}

}
