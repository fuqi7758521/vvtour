package com.usual.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.common.utils.CodeEnum;
import com.common.utils.PublicResult;
import com.usual.entity.AdminInfo;
import com.usual.entity.BaseEntity;

/**
 * @author John
 * @date 7/6/2014
 * @Target 	这个类主要验证客户端提交内容的有效性
 * 
 * */
public class ValidateUtil {

	private final static Logger logger = Logger.getLogger(ValidateUtil.class);
	
	public static<T extends BaseEntity> PublicResult<Boolean> checkRegistAdmin(AdminInfo info){
		PublicResult<Boolean> publicResult = new PublicResult<Boolean>(false);
		try{
			//==========================================验证用户名
			
			if(StringUtils.isBlank(info.getAdmin_name())){
				
				return failPublicResult(publicResult, CodeEnum.VALIDATE_USERNAME_EMPTY.getCode());
			}
			
			if(!isMatchParttern(REG_USERNAME_LENGTH_PATTERN,info.getAdmin_name())){
				
				return failPublicResult(publicResult, CodeEnum.VALIDATE_USERNAME_LENGTH.getCode());
			}
			
			if(!isMatchParttern(REG_USERNAME_PATTERN,info.getAdmin_name())){
				
				return failPublicResult(publicResult, CodeEnum.VALIDATE_USERNAME_INVALID.getCode());
			}
			
			//==========================================验证密码
			if(StringUtils.isBlank(info.getPassword())){
				
				return failPublicResult(publicResult, CodeEnum.VALIDATE_PASSWORD_EMPTY.getCode());
			}
			
			if(!isMatchParttern(REG_PASSWORD_LENGTH_PATTERN,info.getPassword())){
				
				return failPublicResult(publicResult, CodeEnum.VALIDATE_PASSWORD_LENGTH.getCode());
			}
			
			if(!isMatchParttern(REG_PASSWORD_PATTERN,info.getPassword())){
				
				return failPublicResult(publicResult, CodeEnum.VALIDATE_PASSWORD_INVALID.getCode());
			}
			
			//==========================================验证真实姓名
			if(StringUtils.isBlank(info.getReal_name())){
				
				return failPublicResult(publicResult, CodeEnum.VALIDATE_REALNAME_EMPTY.getCode());
			}
			
			if(!isMatchParttern(REG_NICKNAME_LENGTH_PATTERN,info.getReal_name())){
				
				return failPublicResult(publicResult, CodeEnum.VALIDATE_REALNAME_LENGTH.getCode());
			}
			
			if(!isChinese(info.getReal_name())){
				
				return failPublicResult(publicResult, CodeEnum.VALIDATE_REALNAME_INVALID.getCode());
			}
			
			return succPublicResult(publicResult);
			
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage(),ex);
			return failPublicResult(publicResult, CodeEnum.EXCEPTION_VALIDATE.getCode());
		}
	}
	
	/**
	 * 验证前台用户名
	 * 匹配长度
	 * 匹配格式
	 * */
	public static PublicResult<Boolean> checkUserName(String username){
		PublicResult<Boolean> publicResult = new PublicResult<Boolean>(false);
		if(StringUtils.isBlank(username)){
			
			return failPublicResult(publicResult, CodeEnum.EXCEPTION.getCode());
		}
		
		if(!isMatchParttern(REG_USERNAME_LENGTH_PATTERN,username)){
			
			return failPublicResult(publicResult, CodeEnum.EXCEPTION.getCode());
		}
		
		if(!isMatchParttern(REG_USERNAME_PATTERN,username)){
			
			return failPublicResult(publicResult, CodeEnum.EXCEPTION.getCode());
		}
		return succPublicResult(publicResult);
		
	}
    
	/**
	 * 验证前台密码
	 * */
	public static PublicResult<Boolean> checkPassword(String password){
		PublicResult<Boolean> publicResult = new PublicResult<Boolean>(false);
		if(StringUtils.isBlank(password)){
			
			return failPublicResult(publicResult, CodeEnum.EXCEPTION.getCode());
		}
		
		if(!isMatchParttern(REG_PASSWORD_LENGTH_PATTERN,password)){
			
			return failPublicResult(publicResult, CodeEnum.EXCEPTION.getCode());
		}
		
		if(!isMatchParttern(REG_PASSWORD_PATTERN,password)){
			
			return failPublicResult(publicResult, CodeEnum.EXCEPTION.getCode());
		}
		return succPublicResult(publicResult);
	}
	
	/**
	 * 验证后台用户名
	 * */
	public static PublicResult<Boolean> checkAdminUserName(String admin){
		PublicResult<Boolean> publicResult = new PublicResult<Boolean>(false);
		if(StringUtils.isBlank(admin)){
			
			return failPublicResult(publicResult, CodeEnum.EXCEPTION.getCode());
		}
		
		if(!isMatchParttern(REG_USERNAME_LENGTH_PATTERN,admin)){
			
			return failPublicResult(publicResult, CodeEnum.EXCEPTION.getCode());
		}
		
		if(!isMatchParttern(REG_USERNAME_PATTERN,admin)){
			
			return failPublicResult(publicResult, CodeEnum.EXCEPTION.getCode());
		}
		return succPublicResult(publicResult);
	}
	
	/**
	 * 验证昵称
	 * */
	public static PublicResult<Boolean> checkNickName(String nickname){
		PublicResult<Boolean> publicResult = new PublicResult<Boolean>(false);

		if(StringUtils.isBlank(nickname)){
			
			return failPublicResult(publicResult, CodeEnum.EXCEPTION.getCode());
		}
		
		if(!isMatchParttern(REG_NICKNAME_LENGTH_PATTERN,nickname)){
			
			return failPublicResult(publicResult, CodeEnum.EXCEPTION.getCode());
		}
		
		if(isChinese(nickname)){
			
			return failPublicResult(publicResult, CodeEnum.EXCEPTION.getCode());
		}
		return succPublicResult(publicResult);
	}
	
	/**
     * @param publicResult
     * @return
     */
	public static <T extends Object> PublicResult<T> failPublicResult(PublicResult<T> result, int errorCode){
		
		if(result == null){
			result = new PublicResult<T>(false);
		}
		
		result.setSuccess(false);
		result.setErrorMsg(CodeEnum.getCodeEnum(errorCode).getMsg());
		result.setErrorCode(errorCode);
		result.setCnErrorMsg(CodeEnum.getCodeEnum(errorCode).getCnMsg());
		return result;
	}
	
	/**
     * @param publicResult
     * @return
     */
    public static <T extends Object> PublicResult<T> succPublicResult(PublicResult<T> result){
    	
    	if(result == null){
			result = new PublicResult<T>(false);
		}
    	
    	result.setSuccess(true);
        return result;
    }
	
	/**根据正则表达式判断是否匹配*/
	public static boolean isMatchParttern(String regex,String content){
		boolean flg = Pattern.matches(regex, content);
		return flg;
	}
	
	/**
	 * 通过正则规则替换字符串内匹配的内容
	 * @param content 要替换的内容
	 * @param replace 替换成的内容
	 * @param regex 替换正则的规则
	 * */
	public static String replaceContentByRegex(String content,String replace,String regex){
		if(StringUtils.isBlank(replace)){
			replace = "";
		}
		String str = content.replace(regex, replace);
		return str;
	}
	
	
	/**  由数字、下划线、字母组成的公式是：(^[a-z0-9A-Z])[a-z0-9A-Z_]+([a-z0-9-A-Z])   
	 * 	 如果同时控制长度：/^[a-z0-9A-Z]{6,18}$/  输入6-18位  */
	public static final String REG_USERNAME_PATTERN = "^[a-z0-9A-Z]+$";		//用户名正则表达式  英文、数字组成
	
	public static final String REG_USERNAME_LENGTH_PATTERN = ".{6,18}$";	//判断用户名长度在6-18位之间
		
	public static final String REG_PASSWORD_PATTERN = "^[a-z0-9A-Z]+$";		//密码正则表达式  英文、数字组成
	
	public static final String REG_PASSWORD_LENGTH_PATTERN = ".{8,18}$";	//判断密码长度在8-18位之间
	
	/**  不加下划线由数字、字母和汉字组成的是：^[a-zA-Z0-9\u4e00-\u9fa5]+$     */
	public static final String REG_NICKNAME_LENGTH_PATTERN = ".{2,5}$";			//判断昵称长度在2-5位之间
	
	public static final String REG_EMAIL_PATTERN = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";			//邮箱正则表达式
	
	public static final String REG_PHONE_PATTERN = "^1[3-9][0-9]{9}$";			//手机号正则表达式

	
	public static void main(String args[]){
		//PublicResult<Boolean> publicResult = checkNickName("123");
//		System.out.println(publicResult.isSuccess());
//		System.out.println(publicResult.getErrorMsg());
//		System.out.println(publicResult.getCnErrorMsg());
		System.out.println(isChinese("范e围"));
		
	}
	
	public static boolean isChinese(String str) {

        Pattern p = Pattern.compile("^[\u4e00-\u9fa5]+$");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }
	
	public static boolean isNumeric(String str){ 
	    Pattern pattern = Pattern.compile("[0-9]*"); 
	    return pattern.matcher(str).matches();    
	 }
}
