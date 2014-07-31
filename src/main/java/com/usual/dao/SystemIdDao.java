package com.usual.dao;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.usual.entity.SystemId;

public interface SystemIdDao {

	public void saveSystemId(SystemId systemId);
	
	public SystemId update(Query query, Update update);
}
