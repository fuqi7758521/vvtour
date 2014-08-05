package com.vvtour.shop.manager;

import java.util.List;

import com.vvtour.shop.criteria.UserCriteria;
import com.vvtour.shop.entity.User;

public interface UserManager {
	
	 Long getUserCount(UserCriteria criteria);
	
	 List<User> getUsers(UserCriteria criteria);
	
	 User getUser(String userId);
	 
	 User getUser(UserCriteria criteria);
	
	 void addUser(User to);
	 
	 void updateUser(User to);

}
