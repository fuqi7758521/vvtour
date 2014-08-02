package com.vvtour.shop.manager.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.vvtour.shop.dao.ProductInfoDao;
import com.vvtour.shop.dao.UserDao;
import com.vvtour.shop.entity.ProductInfo;
import com.vvtour.shop.entity.TourPath;
import com.vvtour.shop.entity.User;
import com.vvtour.shop.manager.ProductInfoManager;
import com.vvtour.shop.manager.UserManager;
import com.vvtour.shop.manager.impl.CategoryInfoManagerImpl.CategoryInfoField;
import com.vvtour.shop.manager.impl.ProductInfoManagerImpl.ProductInfoField;
import com.vvtour.shop.manager.impl.TourPathManagerImpl.TourPathField;

public class UserManagerImpl implements UserManager {

	@Autowired
	private UserDao userDao;

	class UserField{
		
		final static String USERID = "user_id";
		final static String USERNAME = "username";
		final static String NICKNAME = "nickname";
		final static String EMAIL = "email";
		final static String MOBILE_PHONE = "mobile_phone";
		final static String STATUS = "status";
	}
	
	
	@Override
	public boolean editUser(User to) {
		Query query = Query.query(Criteria.where(UserField.USERID).is(to.getUserId()));
		Update update = new Update();
		update.set(UserField.STATUS, to.getStatus());
		return userDao.editUser(query, update);
	}


	@Override
	public User queryUser(String userId) {
		
		Query query = new Query();
		if(StringUtils.isNotBlank(userId)){
			query = query.addCriteria(Criteria.where(UserField.USERID).is(userId));
		}
		User user = userDao.queryUser(query);
		
		return user;
	}
	
}
