package com.usual.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Order;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.usual.dao.AdminInfoDao;
import com.usual.entity.AdminInfo;
import com.usual.manager.AdminInfoManager;

public class AdminInfoManagerImpl implements AdminInfoManager {
	
	@Autowired
	private AdminInfoDao adminInfoDao;

	@Override
	public boolean userNameExist(String userName) {
		Query query = Query.query(Criteria.where(AdminInfoField.ADMINNAME).is(userName));
		query.addCriteria(Criteria.where(AdminInfoField.STATUS).ne(AdminInfo.USER_LOCK));
		AdminInfo adminInfo = adminInfoDao.queryUser(query);
		
		return adminInfo == null ? false : true;
	}

	@Override
	public boolean checkUserIdExist(String userId) {
		Query query = Query.query(Criteria.where(AdminInfoField.ADMINID).is(userId));
		AdminInfo adminInfo = adminInfoDao.queryUser(query);
		
		return adminInfo == null ? false : true;
	}

	@Override
	public AdminInfo userLogin(String userName, String password) {
		Query query = Query.query(Criteria.where(AdminInfoField.ADMINNAME).is(userName));
		query.addCriteria(Criteria.where(AdminInfoField.PASSWORD).is(password));
		query.addCriteria(Criteria.where(AdminInfoField.STATUS).ne(AdminInfo.USER_LOCK));
		
		return adminInfoDao.queryUser(query);
	}

	@Override
	public boolean registAdminInfo(AdminInfo adminInfo) {
		adminInfoDao.addAdmin(adminInfo);
		return true;
	}

	@Override
	public AdminInfo queryAdminInfoByUserName(String userName) {
		Query query = Query.query(Criteria.where(AdminInfoField.ADMINNAME).is(userName));
		query.addCriteria(Criteria.where(AdminInfoField.STATUS).ne(AdminInfo.USER_LOCK));
		
		return adminInfoDao.queryUser(query);
	}

	@Override
	public AdminInfo queryAdminInfoByUserId(String userId) {
		Query query = Query.query(Criteria.where(AdminInfoField.ADMINID).is(userId));
		query.addCriteria(Criteria.where(AdminInfoField.STATUS).ne(AdminInfo.USER_LOCK));
		
		return adminInfoDao.queryUser(query);
	}

	@Override
	public boolean updateAdminPassword(String userId, String newPassword) {
		Query query = Query.query(Criteria.where(AdminInfoField.ADMINID).is(userId));
		Update update = new Update();
		update.set(AdminInfoField.PASSWORD, newPassword);
		
		AdminInfo adminInfo = adminInfoDao.updateAdmin(query, update);
		if(adminInfo == null){
			return false;
		}
		return true;
	}

	@Override
	public List<AdminInfo> queryAdminInfoList(int start, int max) {
		Query query = Query.query(Criteria.where(AdminInfoField.STATUS).ne(AdminInfo.USER_LOCK));
		query.skip(start);
		query.limit(max);
		query.sort().on(AdminInfoField.REGISTTIME, Order.DESCENDING);
		
		return adminInfoDao.queryUserList(query);
	}

	@Override
	public long queryAdminInfoCount() {
		Query query = Query.query(Criteria.where(AdminInfoField.STATUS).ne(AdminInfo.USER_LOCK));
		
		return adminInfoDao.queryAdminInfoCount(query);
	}

	@Override
	public boolean updateUserStatus(String userId, int status) {
		Query query = Query.query(Criteria.where(AdminInfoField.ADMINID).is(userId));
		Update update = new Update();
		update.set(AdminInfoField.STATUS, status);
		
		AdminInfo adminInfo = adminInfoDao.updateAdmin(query, update);
		if(adminInfo == null){
			return false;
		}
		return true;
	}

	@Override
	public boolean shieldOrDeltelUser(String[] userIds, int status) {
		Query query = Query.query(Criteria.where(AdminInfoField.ADMINID).in((Object [])userIds));
		query.addCriteria(Criteria.where(AdminInfoField.STATUS).ne(AdminInfo.USER_LOCK));
		Update update = new Update();
		update.set(AdminInfoField.STATUS, status);
		
		return adminInfoDao.updateBatchAdmin(query, update);
	}
	
	@Override
	public boolean updateAdminAuth(String userId,String[] auths, int status) {
		Query query = Query.query(Criteria.where(AdminInfoField.ADMINID).is(userId));
		query.addCriteria(Criteria.where(AdminInfoField.STATUS).ne(AdminInfo.USER_LOCK));
		Update update = new Update();
		update.set(AdminInfoField.STATUS, status);
		update.set(AdminInfoField.AUTHS, auths);
		
		return adminInfoDao.updateBatchAdmin(query, update);
	}

	@Override
	public List<AdminInfo> queryAdminInfosByUserIds(List<String> userIds) {
		Query query = Query.query(Criteria.where(AdminInfoField.ADMINID).in(userIds));
		query.addCriteria(Criteria.where(AdminInfoField.STATUS).ne(AdminInfo.USER_LOCK));
		
		return adminInfoDao.queryUserList(query);
	}

	class AdminInfoField{
		final static String ADMINID = "admin_id";
		
		final static String ADMINNAME = "admin_name";
		
		final static String REALNAME = "real_name";
		
		final static String PASSWORD = "password";
		
		final static String REGISTTIME = "regist_time";
		
		final static String AUTHS = "auths";
		
		final static String EMAIL = "email";
		
		final static String LASTLOGIN = "last_login";
		
		final static String LASTIP = "last_ip";
		
		final static String RANK = "rank";
		
		final static String STATUS = "status";
		
		final static String DEPARTMENT = "department";
	}

}
