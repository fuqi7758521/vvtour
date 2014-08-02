package com.vvtour.shop.service.impl;


import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.common.utils.CodeEnum;
import com.common.utils.PublicResult;
import com.usual.manager.SystemIdManager;
import com.usual.service.BaseService;
import com.vvtour.shop.entity.ProductInfo;
import com.vvtour.shop.entity.User;
import com.vvtour.shop.manager.UserManager;
import com.vvtour.shop.service.UserService;

public class UserServiceImpl extends BaseService implements
		UserService {
	
	private final static Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	private static final Integer USER_STATUS_DELETED = -2;
	
	private static final Integer USER_STATUS_NORMAL = 0;
	
	private static final Integer USER_STATUS_BANNED = -1;

	@Autowired
	private UserManager userManager;
	

	@Override
	public PublicResult<Boolean> editUser(User to) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);
		try {
			boolean editResult = false;
			editResult = userManager.editUser(to);
			result.setModel(editResult);
			if(editResult){
				return succPublicResult(result);
			}
			return failPublicResult(result, CodeEnum.ERROR_OPERATE_FAIL.getCode());
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}


	@Override
	public PublicResult<User> queryUser(String userId) {
		PublicResult<User> result = new PublicResult<User>(false);
		if (StringUtils.isBlank(userId)&&StringUtils.isBlank(userId)) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}

		try {
			User user = userManager.queryUser(userId);
			result.setModel(user);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}
	
}
