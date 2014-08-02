package com.vvtour.shop.manager;

import com.vvtour.shop.entity.User;

public interface UserManager {
	
	public boolean editUser(User to);
	
	public User queryUser(String userId);
	
	
}
