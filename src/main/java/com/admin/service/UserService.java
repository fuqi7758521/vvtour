package com.admin.service;

import com.admin.criteria.SearchPagerModel;
import com.admin.criteria.UserCriteria;
import com.admin.entity.User;

public interface UserService {

	SearchPagerModel<User> getUsers(UserCriteria criteria);
	
	User getUser(String userId);
	
	boolean addUpdateUser(User to);
	
}
