package com.usual.manager.impl;

import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.usual.manager.SystemIdManager;
import com.usual.utils.IdTypeEnum;
import com.usual.manager.impl.SystemIdManagerImpl;
import com.usual.entity.SystemId;
import com.usual.dao.SystemIdDao;

public class SystemIdManagerImpl implements SystemIdManager {
	
	private final static Logger logger = Logger.getLogger(SystemIdManagerImpl.class);
	
	@Autowired
	private SystemIdDao systemIdDao;

	public String getSystemId(IdTypeEnum idType) {
		Query query = Query.query(Criteria.where(SystemIdFiled.IDTYPE).is(idType.getType()));
		Update update = new Update();
		update.inc(SystemIdFiled.NEXTNUM, 1);
		SystemId systemId = systemIdDao.update(query, update);
		if(systemId == null){
			logger.error("first time take ID failed " + idType.getType());
			systemId = systemIdDao.update(query, update);
		}
		
		if(systemId == null){
			logger.error("second time take ID failed " + idType.getType());
			return UUID.randomUUID().toString();
		}
		return String.valueOf(systemId.getNextNum());
	}
	
	
	class SystemIdFiled{
		final static String IDTYPE = "idType";
		
		final static String INITNUM = "initNum";
		
		final static String NEXTNUM = "nextNum";
	}

}
