package com.usual.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.common.utils.CodeEnum;
import com.common.utils.PublicResult;
import com.usual.entity.ManageMenu;
import com.usual.manager.MngMenuManager;
import com.usual.manager.SystemIdManager;
import com.usual.service.BaseService;
import com.usual.service.MngMenuService;
import com.usual.utils.IdTypeEnum;

public class MngMenuServiceImpl extends BaseService implements MngMenuService {
	
	private final static Logger logger = Logger
			.getLogger(MngMenuServiceImpl.class);
	
	@Autowired
	private MngMenuManager menuManager;
	
	@Autowired
	private SystemIdManager systemIdManager;

	@Override
	public PublicResult<String> addManageMenu(ManageMenu menuInfo) {
		PublicResult<String> result = new PublicResult<String>(false);
		if (menuInfo == null) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}
		try {
			String menu_id = systemIdManager.getSystemId(IdTypeEnum.ADMIN_MENU_ID);
			menuInfo.setMenu_id(menu_id);
			
			boolean addResult = menuManager.addManageMenu(menuInfo);
			if(addResult){
				result.setModel(menu_id);
			}
			return succPublicResult(result);
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
		
	}
	
	@Override
	public PublicResult<Boolean> checkMenuNameExist(String menu_name) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);
		if (StringUtils.isBlank(menu_name)) {
			logger.error("request param is null ");
			return failPublicResult(result, CodeEnum.VALIDATE_PARAM_EMPTY.getCode());
		}

		try {
			boolean isExiste = menuManager.menuNameExist(menu_name);
			result.setModel(isExiste);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Boolean> deleteAuthByMngIdAndAuthId(String menu_id,String auth_id) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);
		try {
			boolean flag = menuManager.deleteAuthByMngIdAndAuthId(menu_id,auth_id);
			result.setModel(flag);
			return succPublicResult(result);
			
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Boolean> updateManageMenu(String menu_id,String menu_name) {
		PublicResult<Boolean> result = new PublicResult<Boolean>(false);

		try {

			boolean flag = menuManager.updateManageMenu(menu_id,menu_name);
			result.setModel(flag);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<ManageMenu> queryManageMenu(String menu_id) {
		PublicResult<ManageMenu> result = new PublicResult<ManageMenu>(false);

		try {
			
			if(StringUtils.isBlank(menu_id)){
				logger.error("request param is null ");
				return failPublicResult(result, CodeEnum.VALIDATE_USERNAME_EMPTY.getCode());
			}
			
			ManageMenu menuInfo = menuManager.queryManageMenu(menu_id);
			if(menuInfo != null){
				result.setModel(menuInfo);
				return succPublicResult(result);
			}
			
			return failPublicResult(result, CodeEnum.EXCEPTION_USER_NOTEXIST.getCode());
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<ManageMenu> queryManageMenuList(int start, int max) {
		PublicResult<ManageMenu> result = new PublicResult<ManageMenu>(false);

		try {

			long count = menuManager.queryManageMenuCount();
			result.setCount(count);
			if (count > 0) {
				List<ManageMenu> menus = menuManager.queryMngList(start, max);
				result.setModelList(menus);
			}
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

	@Override
	public PublicResult<Long> queryManageMenuCount() {
		PublicResult<Long> result = new PublicResult<Long>(false);

		try {
			long count = menuManager.queryManageMenuCount();
			result.setModel(count);
			return succPublicResult(result);
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
			return failPublicResult(result, CodeEnum.EXCEPTION.getCode());
		}
	}

}
