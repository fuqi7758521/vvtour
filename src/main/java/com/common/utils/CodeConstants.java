package com.common.utils;

public class CodeConstants {
	
	
	
	/**
	 * 1000		系统错误、异常
	 * 2000		验证错误
	 * 
	 * */
	public final static int ID_TYPE_INIT_NUM = 10001;				
	
	public final static int ERROR_CODE_INIT = 1000;					//系统错误
	
	public final static int ERROR_EXCEPTION = ERROR_CODE_INIT + 1;		//系统出现异常
	
	public final static int ERROR_OPERATE_FAIL = ERROR_CODE_INIT + 2;	//操作失败
	
	public final static int ERROR_VALIDATE_FAIL = ERROR_CODE_INIT + 3;	//验证出现异常
	
	public final static int VALIDATE_CODE_INIT = 2000;					//验证错误

	public final static int VALIDATE_PARAM_EMPTY = VALIDATE_CODE_INIT + 1;//参数为空
	
	public final static int VALIDATE_USERNAME_EMPTY = VALIDATE_CODE_INIT + 2;		//用户名为空
	
	public final static int VALIDATE_USERNAME_LENGTH = VALIDATE_CODE_INIT + 3;		//用户名长度不在规定范围
	
	public final static int VALIDATE_USERNAME_INVALID = VALIDATE_CODE_INIT + 4;		//用户名不符合规则
	
	public final static int VALIDATE_USERNAME_EXIST = VALIDATE_CODE_INIT + 5;		//用户名已经存在
	
	public final static int VALIDATE_PASSWORD_EMPTY = VALIDATE_CODE_INIT + 6;		//密码为空
	
	public final static int VALIDATE_PASSWORD_LENGTH = VALIDATE_CODE_INIT + 7;		//密码长度不在规定范围
	
	public final static int VALIDATE_PASSWORD_INVALID = VALIDATE_CODE_INIT + 8;		//密码不符合规则
	
	public final static int VALIDATE_PASSWORD_SIMPLE = VALIDATE_CODE_INIT + 9;		//密码太过简单
	
	public final static int VALIDATE_PINCODE_INVALID = VALIDATE_CODE_INIT + 10;		//验证码错误
	
	public final static int VALIDATE_REALNAME_EMPTY = VALIDATE_CODE_INIT + 11;		//姓名或昵称不能为空
	
	public final static int VALIDATE_REALNAME_LENGTH = VALIDATE_CODE_INIT + 12;		//姓名或昵称长度不在规定范围内
	
	public final static int VALIDATE_REALNAME_INVALID = VALIDATE_CODE_INIT + 13;		//姓名或昵称必须是汉字
	
	public final static int VALIDATE_LOGIN_ERROR = VALIDATE_CODE_INIT + 14;			//用户名或密码不正确
	
	public final static int VALIDATE_DATA_EXIST = VALIDATE_CODE_INIT + 15;			//数据已经存在
	
	
}
