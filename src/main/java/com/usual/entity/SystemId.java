package com.usual.entity;

public class SystemId extends BaseEntity {

	private static final long serialVersionUID = 6714450485231069000L;
	
	private int idType;
	
	private long initNum;
	
	private long nextNum;
	
	private String typeName;
	
	private final static String collectionName = "system_id";
	
	public SystemId() {
		super(collectionName);
	}

	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public long getInitNum() {
		return initNum;
	}

	public void setInitNum(long initNum) {
		this.initNum = initNum;
	}

	public long getNextNum() {
		return nextNum;
	}

	public void setNextNum(long nextNum) {
		this.nextNum = nextNum;
	}
	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "SystemId [idType=" + idType + ", initNum=" + initNum
				+ ", nextNum=" + nextNum 
				+ ", typeName=" + typeName + ",toString()=" + super.toString()
				+ "]";
	}
}
