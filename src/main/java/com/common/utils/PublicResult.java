package com.common.utils;

import java.io.Serializable;
import java.util.List;

public class PublicResult<T> implements Serializable {

	private static final long serialVersionUID = 7693661082059858021L;
	
	private boolean success;
	
	private T model;
	
	private List<T> modelList;
	
	private long count;
	
	private Integer errorCode;
	
	private String errorMsg;
	
	private String cnErrorMsg;
	
	
	public PublicResult(boolean success) {
		this.success = success;
	}
	
	public PublicResult() {
	}
	
	 /**
     * @return
     */
    public boolean isSuccess() {
        return success;
    }
    
    /**
     * @param success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * @return
     */
    public boolean getSuccess() {
        return success;
    }
    
	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}

	public List<T> getModelList() {
		return modelList;
	}

	public void setModelList(List<T> modelList) {
		this.modelList = modelList;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getCnErrorMsg() {
		return cnErrorMsg;
	}

	public void setCnErrorMsg(String cnErrorMsg) {
		this.cnErrorMsg = cnErrorMsg;
	}
}
