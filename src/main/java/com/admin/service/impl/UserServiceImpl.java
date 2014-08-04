package com.admin.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.admin.criteria.SearchPagerModel;
import com.admin.criteria.UserCriteria;
import com.admin.entity.User;
import com.admin.manager.UserManager;
import com.admin.service.UserService;
import com.usual.service.BaseService;

public class UserServiceImpl extends BaseService implements UserService {

	private final static Logger logger = Logger.getLogger(UserServiceImpl.class);


	@Autowired
	private UserManager userManager;

	@Override
	public SearchPagerModel<User> getUsers(UserCriteria criteria) {

		SearchPagerModel<User> pager = criteria.getPageModel();
		Long count = userManager.getUserCount(criteria);
		if (null != count && count.intValue() > 0) {
			List<User> result = userManager.getUsers(criteria);
			pager.setResultList(result);
			pager.setTotal(count);
		}
		return pager;

	}

	@Override
	public User getUser(String userId) {
		
		return userManager.getUser(userId);

	}

	@Override
	public boolean addUpdateUser(User to) {
	
		return userManager.addUpdateUser(to);
	}

}
