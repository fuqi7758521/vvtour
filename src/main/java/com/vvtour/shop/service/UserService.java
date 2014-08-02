package com.vvtour.shop.service;

import com.common.utils.PublicResult;
import com.vvtour.shop.criteria.UserCriteria;
import com.vvtour.shop.entity.User;

public interface UserService {

	public PublicResult<Boolean> editUser(User to);
	
	public PublicResult<User> queryUser(String userId);
	
	public PublicResult<User> queryUserList(UserCriteria criteria);
	
}
