package com.vvtour.shop.manager;

import java.util.List;

import com.vvtour.shop.criteria.UserCriteria;
import com.vvtour.shop.entity.User;

public interface UserManager {
	
	public Long getUserCount(UserCriteria criteria);
	
	public List<User> getUsers(UserCriteria criteria);
	
	public User getUser(String userId);
	
	public void addUpdateUser(User to);

}
