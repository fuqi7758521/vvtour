package com.usual.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.usual.dao.BaseDao;
import com.usual.dao.ManageMenuDao;
import com.usual.entity.ManageMenu;

public class ManageMenuDaoImpl extends BaseDao implements ManageMenuDao {

	@Override
	public ManageMenu queryManageMenu(Query query) {
		return (ManageMenu)queryOne(query,new ManageMenu());
	}

	@Override
	public void addAuthority(Query query, Update update) {
		saveInnerObjOne(query,update,new ManageMenu());
	}

	@Override
	public ManageMenu updateManageMenu(Query query, Update update) {
		return (ManageMenu) findAndModify(query, update, new ManageMenu());
	}

	@Override
	public List<ManageMenu> queryMngList(Query query) {
		return (List<ManageMenu>) queryList(query, new ManageMenu());
	}

	@Override
	public void addManageMenu(ManageMenu menuInfo) {
		saveOne(menuInfo);
	}

	@Override
	public long queryManageMenuCount(Query query) {
		return getCount(query, new ManageMenu());
	}

}
