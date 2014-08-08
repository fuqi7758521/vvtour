package com.vvtour.shop.manager.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

		final static String USERID = "userId";
		final static String USERNAME = "username";
		final static String NICKNAME = "nickname";
		final static String REALNAME = "realname";
		final static String EMAIL = "email";
		final static String MOBILE = "mobile";
		final static String STATUS = "status";
		final static String PROVINCE = "province";
		final static String CITY = "city";
		final static String SEX = "sex";
		final static String PASSWORD = "password";
		final static String BIRTHDAY_YEAR = "yearOfBirthday";
		final static String BIRTHDAY_MONTH = "monthOfBirthday";
		final static String BIRTHDAY_DAY = "dayOfBirthday";
		final static String VALIDATE_EMAIL = "validateEmail";
		final static String LAST_LOGIN_DATE = "lastLoginDate";
		final static String SIGN_UP_DATE = "signUpDate";
	}

	@Override
	public Long getUserCount(UserCriteria criteria) {
		return userDao.queryUserCount(getQuery(criteria,false));
	}

	@Override
	public List<User> getUsers(UserCriteria criteria) {
		return userDao.queryUserList(getQuery(criteria,true));
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
	public void addUser(User to) {
		userDao.add(to);
	}

	@Override
	public void updateUser(User to) {
		Query query = Query.query(Criteria.where(UserField.USERID).is(
				to.getUserId()));
		Update update = new Update();
		if (StringUtils.isNotEmpty(to.getUsername())) {
			update.set(UserField.USERNAME, to.getUsername());
		}
		if (StringUtils.isNotEmpty(to.getEmail())) {
			update.set(UserField.EMAIL, to.getEmail());
		}
		if (to.getSex() != null) {
			update.set(UserField.SEX, to.getSex());
		}
		if (StringUtils.isNotEmpty(to.getProvince())) {
			update.set(UserField.PROVINCE, to.getProvince());
		}
		if (StringUtils.isNotEmpty(to.getCity())) {
			update.set(UserField.CITY, to.getCity());
		}
		if (StringUtils.isNotEmpty(to.getPassword())){
			update.set(UserField.PASSWORD, to.getPassword());
		}
		if (StringUtils.isNotEmpty(to.getRealname())){
			update.set(UserField.REALNAME, to.getRealname());
		}
		if (to.getYearOfBirthday() != null){
			update.set(UserField.BIRTHDAY_YEAR, to.getYearOfBirthday());
		}
		if (to.getMonthOfBirthday() != null){
			update.set(UserField.BIRTHDAY_MONTH, to.getMonthOfBirthday());
		}
		if (to.getDayOfBirthday() != null){
			update.set(UserField.BIRTHDAY_DAY, to.getDayOfBirthday());
		}
		if (to.getValidateEmail() != null){
			update.set(UserField.VALIDATE_EMAIL, to.getValidateEmail());
		}
		if(to.getLastLoginDate() != null){
			update.set(UserField.LAST_LOGIN_DATE, to.getLastLoginDate());
		}
		if(to.getStatus() != null){
			update.set(UserField.STATUS, to.getStatus());
		}
		userDao.editUser(query, update);
	}

	// 获取查询条件
	private Query getQuery(UserCriteria criteria, boolean needPage) {
		Query query = new Query();

		if (StringUtils.isNotEmpty(criteria.getUserId())) {
			query.addCriteria(Criteria.where(UserField.USERID).is(
					criteria.getUserId()));
		}

		if (StringUtils.isNotEmpty(criteria.getEmail())) {
			query.addCriteria(Criteria.where(UserField.EMAIL).is(
					criteria.getEmail()));
		}

		if (StringUtils.isNotEmpty(criteria.getMobile())) {
			query.addCriteria(Criteria.where(UserField.MOBILE).is(
					criteria.getMobile()));
		}

		if (StringUtils.isNotEmpty(criteria.getUsername())) {
			query.addCriteria(Criteria.where(UserField.USERNAME).is(
					criteria.getUsername()));
		}

		if (criteria.getStatus() != null) {
			query.addCriteria(Criteria.where(UserField.STATUS).is(
					criteria.getStatus()));
		}
		
		if(StringUtils.isNotEmpty(criteria.getPassword())){
			query.addCriteria(Criteria.where(UserField.PASSWORD).is(criteria.getPassword()));
		}
		if(needPage){
			if(criteria.getPageModel() != null){
				query.skip(criteria.getPageModel().getOffset());
				query.limit(criteria.getPageModel().getPageSize());
			}
		}
		query.with(new Sort(Sort.Direction.DESC, UserField.SIGN_UP_DATE));

		return query;
	}

	@Override
	public User getUser(UserCriteria criteria) {
		return userDao.queryUser(getQuery(criteria,false));
	}
}
