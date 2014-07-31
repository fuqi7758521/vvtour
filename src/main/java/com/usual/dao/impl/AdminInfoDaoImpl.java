package com.usual.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.usual.dao.AdminInfoDao;
import com.usual.dao.BaseDao;
import com.usual.entity.AdminInfo;

public class AdminInfoDaoImpl extends BaseDao implements AdminInfoDao {

	@Override
	public AdminInfo queryUser(Query query) {
		return (AdminInfo)queryOne(query,new AdminInfo());
	}

	@Override
	public void addAdmin(AdminInfo adminInfo) {
		saveOne(adminInfo);
	}

	@Override
	public AdminInfo updateAdmin(Query query, Update update) {
		return (AdminInfo) findAndModify(query, update, new AdminInfo());
	}

	@Override
	public boolean updateBatchAdmin(Query query, Update update) {
		return updateBatch(query, update, new AdminInfo());
	}

	@Override
	public List<AdminInfo> queryUserList(Query query) {
		return (List<AdminInfo>) queryList(query, new AdminInfo());
	}

	@Override
	public long queryAdminInfoCount(Query query) {
		return getCount(query, new AdminInfo());
	}

}
