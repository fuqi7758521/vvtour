package com.usual.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.usual.entity.AdminInfo;
import com.usual.manager.AdminInfoManager;
import com.usual.manager.SystemIdManager;
import com.usual.service.AdminInfoService;
import com.usual.service.BaseService;
import com.common.utils.CodeEnum;
import com.usual.utils.IdTypeEnum;
import com.common.utils.PublicResult;

public class AdminInfoServiceImpl extends BaseService implements
		AdminInfoService {
	
	private final static Logger logger = Logger
			.getLogger(AdminInfoServiceImpl.class);
	
	@Autowired
	private AdminInfoManager adminInfoManager;
	
	@Autowired
	private SystemIdManager systemIdManager;

	@Override
	public PublicResult<String> registAdmin(AdminInfo adminInfo) {
		PublicResult<String> result = new PublicResult<String>(false);
		if (adminInfo == null) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}
		try {
			String userName = adminInfo.getAdmin_name();
			boolean isExist = adminInfoManager.userNameExist(userName);
			if (isExist) {
				logger.error("registAdminUser is exist " + adminInfo.toString());
				return failPublicResult(result,
						CodeEnum.VALIDATE_USERNAME_EXIST.getCode());
			}
			String userId = systemIdManager.getSystemId(IdTypeEnum.ADMIN_USER_ID);
			adminInfo.setAdmin_id(userId);
			boolean regResult = adminInfoManager.registAdminInfo(adminInfo);
			
			if(regResult){
				result.setModel(userId);
			}
			
			return succPublicResult(result);
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Boolean> userNameExist(String userName) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);
		if (StringUtils.isBlank(userName)) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}

		try {
			boolean isExiste = adminInfoManager.userNameExist(userName);
			result.setModel(isExiste);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<AdminInfo> userLogin(String userName, String password) {
		PublicResult<AdminInfo> result = new PublicResult<AdminInfo>(false);

		if (StringUtils.isBlank(userName)) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_USERNAME_EMPTY.getCode());
		}

		if (StringUtils.isBlank(password)) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PASSWORD_EMPTY.getCode());
		}

		try {

			AdminInfo adminInfo = adminInfoManager.userLogin(userName, password);
			if (adminInfo == null) {
				logger.error("login error userName:" + userName + " password:"
						+ password);
				return failPublicResult(result,
						CodeEnum.VALIDATE_PASSWORD_EMPTY.getCode());
			}

			result.setModel(adminInfo);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<AdminInfo> queryAdminInfoByUserName(String userName) {
		PublicResult<AdminInfo> result = new PublicResult<AdminInfo>(false);

		if (StringUtils.isBlank(userName)) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_USERNAME_EMPTY.getCode());
		}
		try {
			AdminInfo adminInfo = adminInfoManager
					.queryAdminInfoByUserName(userName);
			if (adminInfo == null) {
				logger.error("userInfo not existe userName:" + userName);
				return failPublicResult(result,
						CodeEnum.VALIDATE_LOGIN_INVALID.getCode());
			}

			result.setModel(adminInfo);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Boolean> updateAdminPassword(String userId,
			String newPassword) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);

		if (StringUtils.isBlank(userId)) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_USERNAME_EMPTY.getCode());
		}

		if (StringUtils.isBlank(newPassword)) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PASSWORD_EMPTY.getCode());
		}

		try {
			boolean bool = adminInfoManager.updateAdminPassword(userId,
					newPassword);
			if (!bool) {
				return failPublicResult(result,
						CodeEnum.ERROR_OPERATE_FAIL.getCode());
			}

			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<AdminInfo> queryAdminInfoList(int start, int max) {
		PublicResult<AdminInfo> result = new PublicResult<AdminInfo>(false);

		try {

			long count = adminInfoManager.queryAdminInfoCount();
			result.setCount(count);
			if (count > 0) {
				List<AdminInfo> users = adminInfoManager.queryAdminInfoList(start,
						max);
				result.setModelList(users);
			}
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Boolean> updateAdminInfoStatus(String userId, int status) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);

		try {

			boolean flag = adminInfoManager.updateUserStatus(userId, status);
			result.setModel(flag);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Boolean> updateAdminStatus(String[] userIds, int status) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);

		try {

			boolean flag = adminInfoManager.shieldOrDeltelUser(userIds, status);
			result.setModel(flag);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<AdminInfo> getAdminInfosByUserIds(List<String> userIds) {
		PublicResult<AdminInfo> result = new PublicResult<AdminInfo>(false);

		try {

			List<AdminInfo> adminInfos = adminInfoManager
					.queryAdminInfosByUserIds(userIds);

			int count = adminInfos.size();
			result.setCount(count);
			if (count > 0) {
				result.setModelList(adminInfos);
			}

			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<AdminInfo> getAdminInfoByUserId(String userId) {
		PublicResult<AdminInfo> result = new PublicResult<AdminInfo>(false);

		try {
			if(StringUtils.isBlank(userId)){
				logger.error("request param is null ");
				return failPublicResult(result, CodeEnum.VALIDATE_USERNAME_EMPTY.getCode());
			}
			
			AdminInfo adminInfo = adminInfoManager.queryAdminInfoByUserId(userId);
			if(adminInfo != null){
				result.setModel(adminInfo);
				return succPublicResult(result);
			}
			
			return failPublicResult(result, CodeEnum.EXCEPTION_USER_NOTEXIST.getCode());
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Long> queryAdminCount() {
		PublicResult<Long> result = new PublicResult<Long>(false);

		try {
			long count = adminInfoManager.queryAdminInfoCount();
			result.setModel(count);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Boolean> updateAdminAuth(String userId,String[] auth,int status) {
		//修改管理员权限：要么审核通过，要么修改权限
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);

		try {

			boolean flag = adminInfoManager.updateAdminAuth(userId,auth, status);
			result.setModel(flag);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

}
