package com.usual.entity;

import java.io.Serializable;

public class BaseEntity implements Serializable{

	private static final long serialVersionUID = 6784723472354325L;
	
	protected String collectionName;

	public String getCollectionName() {
		return collectionName;
	}
	
	protected BaseEntity(String collectionName){
		this.collectionName = collectionName;
	}
}
