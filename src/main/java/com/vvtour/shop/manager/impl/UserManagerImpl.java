package com.vvtour.shop.manager.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.vvtour.shop.criteria.UserCriteria;
import com.vvtour.shop.dao.UserDao;
import com.vvtour.shop.entity.User;
import com.vvtour.shop.manager.UserManager;

public class UserManagerImpl implements UserManager {
	
	@Autowired
	private UserDao userDao;

	class UserField {

		final static String USERID = "user_id";
		final static String USERNAME = "username";
		final static String NICKNAME = "nickname";
		final static String EMAIL = "email";
		final static String MOBILE_PHONE = "mobile_phone";
		final static String STATUS = "status";
		final static String PROVINCE = "province";
		final static String CITY = "city";
		final static String SEX = "sex";
	}

	@Override
	public Long getUserCount(UserCriteria criteria) {
		return userDao.queryUserCount(getQuery(criteria));
	}

	@Override
	public List<User> getUsers(UserCriteria criteria) {
		return userDao.queryUserList(getQuery(criteria));
	}

	@Override
	public User getUser(String userId) {

		Query query = new Query();
		if (StringUtils.isNotBlank(userId)) {
			query = query.addCriteria(Criteria.where(UserField.USERID).is(
					userId));
		}
		return userDao.queryUser(query);
	}

	@Override
	public void addUpdateUser(User to) {
		if(StringUtils.isEmpty(to.getUserId())){
			userDao.add(to);
		}else{
			Query query = Query.query(Criteria.where(UserField.USERID).is(
					to.getUserId()));
			Update update = new Update();
			if(StringUtils.isNotEmpty(to.getUsername())){
				update.set(UserField.USERNAME, to.getUsername());
			}
			if(StringUtils.isNotEmpty(to.getEmail())){
				update.set(UserField.EMAIL, to.getEmail());
			}
			if(to.getSex() != null){
				update.set(UserField.SEX, to.getSex());
			}
			if(StringUtils.isNotEmpty(to.getProvince())){
				update.set(UserField.PROVINCE, to.getProvince());
			}
			if(StringUtils.isNotEmpty(to.getCity())){
				update.set(UserField.CITY, to.getCity());
			}
			userDao.editUser(query, update);
		}

	}

	// 获取查询条件
	private Query getQuery(UserCriteria criteria) {
		Query query = new Query();

		if (StringUtils.isNotEmpty(criteria.getUserId())) {
			query.addCriteria(Criteria.where(UserField.USERID).is(
					criteria.getUserId()));
		}

		if (StringUtils.isNotEmpty(criteria.getEmail())) {
			query.addCriteria(Criteria.where(UserField.EMAIL).is(
					criteria.getEmail()));
		}

		if (StringUtils.isNotEmpty(criteria.getMobilePhone())) {
			query.addCriteria(Criteria.where(UserField.MOBILE_PHONE).is(
					criteria.getMobilePhone()));
		}

		if (StringUtils.isNotEmpty(criteria.getUsername())) {
			query.addCriteria(Criteria.where(UserField.USERNAME).is(
					criteria.getUsername()));
		}

		if (criteria.getStatus() != null) {
			query.addCriteria(Criteria.where(UserField.STATUS).is(
					criteria.getStatus()));
		}

		return query;
	}
}
