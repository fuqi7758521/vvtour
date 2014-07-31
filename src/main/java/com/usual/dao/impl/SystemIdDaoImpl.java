package com.usual.dao.impl;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.usual.dao.BaseDao;
import com.usual.dao.SystemIdDao;
import com.usual.entity.SystemId;

public class SystemIdDaoImpl extends BaseDao implements SystemIdDao {

	public void saveSystemId(SystemId systemId) {
		saveOne(systemId);
	}

	public SystemId update(Query query, Update update) {
		return (SystemId) findAndModify(query, update, new SystemId());
	}
}
