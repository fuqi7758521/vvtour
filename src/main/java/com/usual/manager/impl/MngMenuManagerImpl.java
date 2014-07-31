package com.usual.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.usual.dao.ManageMenuDao;
import com.usual.entity.Authority;
import com.usual.entity.ManageMenu;
import com.usual.manager.MngMenuManager;

public class MngMenuManagerImpl implements MngMenuManager {

	@Autowired
	private ManageMenuDao mngInfoDao;
	
	@Override
	public ManageMenu queryManageMenu(String menu_id) {
		Query query = Query.query(Criteria.where(ManageMenuInfoField.MENUID).is(menu_id));
		
		return mngInfoDao.queryManageMenu(query);
	}
	
	@Override
	public boolean addManageMenu(ManageMenu menuInfo) {
		mngInfoDao.addManageMenu(menuInfo);
		return true;
	}
	
	@Override
	public boolean menuNameExist(String menu_name) {
		Query query = Query.query(Criteria.where(ManageMenuInfoField.MENUNAME).is(menu_name));
		ManageMenu menuInfo = mngInfoDao.queryManageMenu(query);
		
		return menuInfo == null ? false : true;
	}

	@Override
	public void addAuthority(String mng_id,Authority authInfo) {
		Query query = Query.query(Criteria.where(ManageMenuInfoField.MENUID).is(mng_id));
		Update update = new Update();
        update.addToSet(ManageMenuInfoField.AUTH, authInfo);
        mngInfoDao.addAuthority(query, update);
	}
	
	@Override
	public boolean updateManageMenu(String menu_id, String menu_name) {
		Query query = Query.query(Criteria.where(ManageMenuInfoField.MENUID).is(menu_id));
		Update update = new Update();
		
		update.set(ManageMenuInfoField.MENUNAME, menu_name);
		
		ManageMenu mngInfo = mngInfoDao.updateManageMenu(query, update);
		if(mngInfo == null){
			return false;
		}
		return true;
		
	}

	@Override
	public boolean updateAuthority(String menu_id,Authority authInfo) {
		Query query = Query.query(Criteria.where(ManageMenuInfoField.MENUID).is(menu_id).and("auth.auth_id").is(authInfo.getAuth_id()));
		Update update = new Update();
		
		update.set("auth.$.auth_cnname", authInfo.getAuth_cnname());
		
		update.set("auth.$.auth_url", authInfo.getAuth_url());
		
		ManageMenu mngInfo = mngInfoDao.updateManageMenu(query, update);
		if(mngInfo == null){
			return false;
		}
		return true;
	}
	
	@Override
	public long queryManageMenuCount() {
		Query query = Query.query(Criteria.where(ManageMenuInfoField.MENUNAME).ne(null));
		
		return mngInfoDao.queryManageMenuCount(query);
	}

	@Override
	public List<ManageMenu> queryMngList(int start, int max) {
		Query query = Query.query(Criteria.where(ManageMenuInfoField.MENUNAME).ne(null));
		query.skip(start);
		query.limit(max);
		
		return mngInfoDao.queryMngList(query);
	}
	
	@Override
	public boolean deleteAuthByMngIdAndAuthId(String mng_id, String auth_id) {
		Query query = Query.query(Criteria.where(ManageMenuInfoField.MENUID).is(mng_id).and("auth.auth_id").is(auth_id));
		Update update = new Update();
		update.unset("auth.$");
		ManageMenu mngInfo = mngInfoDao.updateManageMenu(query, update);
		if(mngInfo == null){
			return false;
		}
		return true;
	}

	class ManageMenuInfoField{
		final static String MENUID = "menu_id";
		
		final static String MENUNAME = "menu_name";
		
		final static String AUTH = "auth";
		
	}

}
