package com.common.utils;


public enum CodeEnum {

	EXCEPTION(CodeConstants.ERROR_EXCEPTION, "exception", "系统发生异常"),
	
	EXCEPTION_VALIDATE(CodeConstants.ERROR_VALIDATE_FAIL, "validate exception", "验证数据时系统发生异常"),
	
	EXCEPTION_USER_NOTEXIST(CodeConstants.ERROR_EXCEPTION, "the user is not exist", "该用户不存在"),
	
	ERROR_OPERATE_FAIL(CodeConstants.ERROR_OPERATE_FAIL, "operate fail", "执行操作失败"),
	
	VALIDATE_PARAM_EMPTY(CodeConstants.VALIDATE_PARAM_EMPTY, "parameter is empty", "参数为空"),
	
	VALIDATE_USERNAME_EMPTY(CodeConstants.VALIDATE_USERNAME_EMPTY, "username is required", "用户名不能为空"),
	
	VALIDATE_USERNAME_LENGTH(CodeConstants.VALIDATE_USERNAME_LENGTH, "Your username must be between 6 and 18 characters long.", "用户名长度须在6-18位之间"),
	
	VALIDATE_USERNAME_INVALID(CodeConstants.VALIDATE_USERNAME_INVALID, "Only letters, numbers are allowed.", "用户名须由字母和数字组成"),
	
	VALIDATE_USERNAME_EXIST(CodeConstants.VALIDATE_USERNAME_EXIST, "This username is not available.", "用户名已经存在"),
	
	VALIDATE_PASSWORD_EMPTY(CodeConstants.VALIDATE_PASSWORD_EMPTY, "password is required.", "密码不能为空"),
	
	VALIDATE_PASSWORD_LENGTH(CodeConstants.VALIDATE_PASSWORD_LENGTH, "Your password must be between 8 and 18 characters long.", "密码长度须在8-18位之间"),
	
	VALIDATE_PASSWORD_INVALID(CodeConstants.VALIDATE_PASSWORD_INVALID, "Only letters, numbers are allowed.", "密码须由字母和数字组成"),
	
	VALIDATE_PASSWORD_SIMPLE(CodeConstants.VALIDATE_PASSWORD_SIMPLE, "Your password is too simple.", "密码输入的太过简单"),
	
	VALIDATE_PINCODE_INVALID(CodeConstants.VALIDATE_PINCODE_INVALID, "Your pin is not available", "验证码错误"),
    
	VALIDATE_REALNAME_EMPTY(CodeConstants.VALIDATE_REALNAME_EMPTY, "RealName is required", "姓名或昵称不能为空"),
	
	VALIDATE_REALNAME_LENGTH(CodeConstants.VALIDATE_REALNAME_LENGTH, "RealName must be between 2 and 5 Chinese words long.", "姓名或昵称长度须在2-5位之间"),
	
	VALIDATE_REALNAME_INVALID(CodeConstants.VALIDATE_REALNAME_INVALID, "Only Chinese words are allowed", "姓名或昵称必须是汉字"),
	
	VALIDATE_LOGIN_INVALID(CodeConstants.VALIDATE_LOGIN_ERROR, "Login with username or password is invalid", "用户名或密码不正确"),
	
	VALIDATE_DATA_EXIST(CodeConstants.VALIDATE_DATA_EXIST, "This data is exist.", "该信息已经存在"),
	;
	
	private final Integer code;
	private final String msg;
	private final String cnMsg;
	
	CodeEnum(Integer code, String msg,String cnMsg) {
	    this.code = code;
	    this.msg = msg;
	    this.cnMsg = cnMsg;
	}
	
	
	public static CodeEnum getCodeEnum(Integer code) {
	    for (CodeEnum t : CodeEnum.values()) {
	        if (code == t.getCode()) {
	            return t;
	        }
	    }
	    return null;
	}
	
	
	public int getCode() {
	    return code;
	}
	
	public String getCodeStr() {
	    return String.valueOf(getCode());
	}
	
	public String getMsg() {
	    return msg;
	}
	
	public String getCnMsg() {
	    return cnMsg;
	}
}
