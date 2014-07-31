package com.vvtour.shop.entity;

import com.usual.entity.BaseEntity;

public class Customer extends BaseEntity {

	private static final long serialVersionUID = -2596325136987266551L;
	
	private final static String collectionName = "customer";
	
	protected Customer() {
		super(collectionName);
	}


}
