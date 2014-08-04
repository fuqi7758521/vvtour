package com.admin.manager.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.admin.criteria.UserCriteria;
import com.admin.dao.UserDao;
import com.admin.entity.User;
import com.admin.manager.UserManager;

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
	public boolean addUpdateUser(User to) {
		// 目前只是更新用户状态，其他信息的编辑和添加以后再进行补充
		Query query = Query.query(Criteria.where(UserField.USERID).is(
				to.getUserId()));
		Update update = new Update();
		update.set(UserField.STATUS, to.getStatus());
		return userDao.editUser(query, update);

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
