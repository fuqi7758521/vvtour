package com.admin.manager;

import java.util.List;

import com.admin.criteria.UserCriteria;
import com.admin.entity.User;

public interface UserManager {
	
	public Long getUserCount(UserCriteria criteria);
	
	public List<User> getUsers(UserCriteria criteria);
	
	public User getUser(String userId);
	
	public boolean addUpdateUser(User to);
}
