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
	
	String EMAIL_SEND_USERNAME = "qi.fu@yunyoyo.cn";
	
	String EMAIL_SEND_PASSWORD =  "911911";
	
	String EMAIL_SEND_SERVER = "qi.fu@yunyoyo.cn";

	String DOMAIN = "http://127.0.0.1:8080/vvtour";
}
