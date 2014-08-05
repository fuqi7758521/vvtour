package com.vvtour.shop.service;

import com.vvtour.shop.entity.User;
import com.vvtour.shop.criteria.*;

public interface UserService {
	
	void addUser(User to);
	
	void updateUser(User to);
	
	SearchPagerModel<User> getUsers(UserCriteria criteria);
	
	User getUser(String userId);
	
	User getUser(UserCriteria criteria);
	
}
