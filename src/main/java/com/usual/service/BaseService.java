package com.usual.service;

import com.common.utils.CodeEnum;
import com.common.utils.PublicResult;

public class BaseService {
	
	/**
	 * @param result
	 * @param errorCode
	 * @return
	 */
	public <T extends Object> PublicResult<T> failPublicResult(PublicResult<T> result, int errorCode){
		
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
    public <T extends Object> PublicResult<T> succPublicResult(PublicResult<T> result){
    	
    	if(result == null){
			result = new PublicResult<T>(false);
		}
    	
    	result.setSuccess(true);
        return result;
    }
}
