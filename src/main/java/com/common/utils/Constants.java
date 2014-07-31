package com.common.utils;

public class Constants {


	public final static String AJAX_RESULT_SUCCESS = "1|";

	public final static String AJAX_RESULT_FAIL = "0|";

	public final static String AJAX_RESULT_ERROR = "-1|";
	
	//============= 通用状态值 0=开放可用,1=已屏蔽,-1=已删除 ==============
	public final static int COMMON_STATUS_OPEN = 1;
	
	public final static int COMMON_STATUS_UNAUDITED = 0;
	
	public final static int COMMON_STATUS_SHIELD = -1;
	
	public static final String LOGIN_TO_URL = "toUrl";
	
	//============= 普通用户 0:普通用户 1:前台管理员 ==============
	public final static int USER_ROLE_USER = 0;
	
	public final static int USER_ROLE_MASTER = 1;

	public final static String ACTION_MESSAGE_ERROR = "actionMessageError";
	
	public final static String ACTION_MESSAGE = "actionMessage";
	
	public final static String RETURN_RESULT_KEY = "result";
	
	public final static String RETURN_RESULT_TYPE = "resultType";

	public final static String LOGIN_USER_KEY = "LOGIN_USER_KEY";
	
	public final static String LOGIN_ADMIN_KEY = "LOGIN_ADMIN_KEY";

	public final static String RANDOM_VERCODE = "RANDOM_VERCODE";

	public final static String FORGET_USER_KEY = "forgetUser";

	public final static String PAGEINDEX = "pageIndex";

	public final static String LAST_QUERY_TIME = "lastTime";
	
	public final static String INDEX_COUNT_DATA = "indexCountData";

	public final static String TIME_FORMAT_SECOND = "yyyy-MM-dd HH:mm:ss";

	public final static String TIME_FORMAT_MINUTE = "yyyy-MM-dd HH:mm";

	public final static String TIME_FORMAT_DAY = "yyyy-MM-dd";
	
	public final static String TIME_FORMAT_MON_DAY = "MM-dd";

	public final static String SIGN = "ok";

	public final static int ACTION_ALBUMPIC_UPLOAD = 0;

	public final static int ACTION_ALBUMPIC_DEL = 1;
	
	public final static String DEFAULT_USER_HAED = "/images/35.jpg";
}
