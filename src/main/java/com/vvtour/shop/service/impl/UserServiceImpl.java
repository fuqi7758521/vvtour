package com.vvtour.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.usual.manager.SystemIdManager;
import com.usual.utils.IdTypeEnum;
import com.vvtour.shop.entity.User;
import com.vvtour.shop.service.UserService;
import com.vvtour.shop.manager.UserManager;
import com.vvtour.shop.criteria.*;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserManager userManager;
	
	@Autowired
	private SystemIdManager systemIdManager;
	
	@Override
	public void addUser(User to) {
		String userId = systemIdManager.getSystemId(IdTypeEnum.USER_ID);
		to.setUserId(userId);
		userManager.addUser(to);
	}

	@Override
	public void updateUser(User to) {
		userManager.updateUser(to);
	}
	
	@Override
	public SearchPagerModel<User> getUsers(UserCriteria criteria) {

		SearchPagerModel<User> pager = criteria.getPageModel();
		if(pager == null){
			pager = new SearchPagerModel<User>();
		}
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
	public User getUser(UserCriteria criteria) {
		return userManager.getUser(criteria);
	}

}
