package com.vvtour.shop;

import com.vvtour.shop.utils.JSONView;



public interface Constant {

	String JSON_ROOT="JSON_ROOT";
	
	JSONView JSON_VIEW=new JSONView();
	
	String PASSWORD_SALT_KEY = "Salt.chengtu.com.2014";
	
	Integer SEX_MALE = 1;
	
	Integer SEX_FEMALE = 0;
	
	Integer EMAIL_CHECKED = 1;
	
	Integer EMAIL_UNCHECKED = 0;
	
	Integer USER_STATUS_NORMAL = 0;
	
	Integer USER_STATUS_BANNED = -1;
	
	Integer USER_STATUS_REMOVED = -2;
	
}
